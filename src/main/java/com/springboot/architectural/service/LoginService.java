package com.springboot.architectural.service;

import com.springboot.architectural.payload.Request.ChangePassRequest;
import com.springboot.architectural.payload.Request.SignUpRequest;

public interface LoginService {
    boolean addUser(SignUpRequest signUpRequest);
    boolean checkLogin(String userName,String email, String password);

    String login(String userName, String email, String password);
    String regenerateOtp(String username, String email, String password,String roleId);
    String verifyAccount(String email, String otp, String newPass, String roleId);

    Boolean changePassByOldPass(ChangePassRequest changePassRequest);
    Boolean changePassByOTP(ChangePassRequest changePassRequest);
    Boolean addUserCustomer(SignUpRequest signUpRequest);

}
