package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.user.User;

public class UserNotLoggedTripService extends TripService {

    @Override
    User getLoggedUser() {
        return null;
    }
}
