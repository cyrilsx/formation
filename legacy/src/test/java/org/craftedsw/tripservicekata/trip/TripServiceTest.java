package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TripServiceTest {

    public User BEST_FRIEND = new User();
    public User USER_WITH_FRIEND = new User();
    public static final Trip TRIP = createTrip();
    private TripService tripService = new TripService();

    @BeforeEach
    void init() {
        BEST_FRIEND = new User();
        USER_WITH_FRIEND = new User();
    }

    @Test
    void exception_if_user_is_not_logged() {
        tripService = new UserNotLoggedTripService();

        assertThrows(UserNotLoggedInException.class,() -> tripService.getTripsByUser(null));
    }

    @Test
    void no_trip_returned_if_user_has_no_friend() {
        User user = new User();
        tripService = new UserLoggedTripService(user);

        assertTrue(tripService.getTripsByUser(user).isEmpty());
    }

    @Test
    void trips_are_returned_because_its_a_friend_and_has_trips() {
        BEST_FRIEND.addTrip(TRIP);
        BEST_FRIEND.addFriend(USER_WITH_FRIEND);
        tripService = new UserLoggedTripService(USER_WITH_FRIEND);

        assertThat(tripService.getTripsByUser(BEST_FRIEND), contains(TRIP));
    }


    @Test
    void no_trip_returned_if_friend_doesnt_have_any_trip() {
        BEST_FRIEND.addFriend(USER_WITH_FRIEND);
        tripService = new UserLoggedTripService(USER_WITH_FRIEND);

        assertThat(tripService.getTripsByUser(BEST_FRIEND), Matchers.empty());
    }


    @Test
    void no_trip_returned_if_user_is_not_a_friend() {
        BEST_FRIEND.addFriend(USER_WITH_FRIEND);
        tripService = new UserLoggedTripService(new User());

        assertThat(tripService.getTripsByUser(BEST_FRIEND), Matchers.empty());
    }


    private static Trip createTrip() {
        return new Trip();
    }
}
