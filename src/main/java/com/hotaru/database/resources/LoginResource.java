package com.hotaru.database.resources;

import com.hotaru.core.database.ResourceBase;
import com.hotaru.database.entities.Login;
import org.hibernate.criterion.Restrictions;

public class LoginResource extends ResourceBase<Login> {
    private static LoginResource INSTANCE = new LoginResource();

    public static LoginResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LoginResource();
        }
        return INSTANCE;
    }

    private LoginResource() {
    }

    public Login getByLoginName(String name) {
        return (Login) getSession()
                .createCriteria(Login.class)
                .add(Restrictions.eq("loginName", name))
                .uniqueResult();
    }
}
