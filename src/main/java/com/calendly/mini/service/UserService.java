package com.calendly.mini.service;

import com.calendly.mini.model.AuthKey;
import com.calendly.mini.model.vo.Password;
import com.calendly.mini.model.vo.UserName;
import com.calendly.mini.request.RegisterUserRequest;

public interface UserService {

    void register(RegisterUserRequest request);

    AuthKey authenticate(UserName userName, Password password);

}
