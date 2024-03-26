package com.springboot.architectural.service;

import com.springboot.architectural.payload.Request.SignUpRequest;

public interface Movie_UserService {
    boolean addUser(SignUpRequest signUpRequest);
    boolean checkLogin(String userName, String password);

}
