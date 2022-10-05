package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.user.User;

import java.util.List;

public class UserLoggedTripService extends TripService {

    private final User user;

    UserLoggedTripService(User user)  {
        this.user = user;
    }

    @Override
    User getLoggedUser() {
        return user;
    }


    @Override
    List<Trip> getTripList(User user) {
        return user.trips();
    }
}
