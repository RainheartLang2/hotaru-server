package com.hotaru.rpc.profile;

import com.hotaru.database.entities.Employee;
import com.hotaru.utils.LoggedInUserHelper;

public class UserProfileService {

    public Employee getProfile() {
        return LoggedInUserHelper.getLoggedInEmployee();
    }
}
