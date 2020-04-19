package com.hotaru.database.resources;

import com.hotaru.core.database.ResourceBase;
import com.hotaru.database.entities.Login;

public class LoginResource extends ResourceBase<Login> {
    private static LoginResource INSTANCE = new LoginResource();

    public static LoginResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LoginResource();
        }
        return INSTANCE;
    }

    private LoginResource() {}
}
