package com.calendly.mini.service;

import com.calendly.mini.model.AuthKey;
import com.calendly.mini.model.Email;
import com.calendly.mini.model.Password;
import com.calendly.mini.model.UserName;

public interface UserService {

    void register(UserName userName, Password password, Password confirmPassword, String name, Email email);

    AuthKey authenticate(UserName userName, Password password);

}
