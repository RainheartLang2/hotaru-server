package com.hotaru.rpc.login;

import com.hotaru.core.exceptions.IncorrectCredentialsException;

public interface LoginServiceBase {
    String login(String login, String password) throws IncorrectCredentialsException;
    void logout();
}
