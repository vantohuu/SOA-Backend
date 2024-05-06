package com.springboot.architectural.controller.admin;

import com.springboot.architectural.payload.Request.ChangePassRequest;
import com.springboot.architectural.payload.Request.SignInRequest;
import com.springboot.architectural.payload.Request.SignUpRequest;
import com.springboot.architectural.payload.ResponseData;
import com.springboot.architectural.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/login")
public class AdminLoginController {

    @Autowired
    private LoginService loginService;
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpRequest signUpRequest) {
        ResponseData responseData = new ResponseData();
        responseData.setData(loginService.addUserCustomer(signUpRequest));
        if (responseData.getData().equals(false)) {
            return new ResponseEntity<>(responseData, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody SignInRequest signInRequest) {
        String username =signInRequest.getUsername();
        String password = signInRequest.getPassword();
        String email = signInRequest.getEmail();
        ResponseData responseData = new ResponseData();
        if(loginService.checkLogin(username, email, password)) {
            String token = loginService.login(username, email, password);
            responseData.setData(token);
            responseData.setSuccess(true);
        } else {
            responseData.setData("");
            responseData.setSuccess(false);
            return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/verify-account")
    public ResponseEntity<String> verifyAccount(@RequestParam String email,
                                                @RequestParam String otp,
                                                @RequestParam(defaultValue = "") String newPass,
                                                @RequestParam String roleId
    ) {
        return new ResponseEntity<>(loginService.verifyAccount(email, otp, newPass, roleId), HttpStatus.OK);
    }
    @PutMapping("/regenerate-otp")
    public ResponseEntity<String> regenerateOtp(@RequestParam String email,
                                                @RequestParam String username,
                                                @RequestParam String roleId,
                                                @RequestParam(defaultValue = "") String password) {
        return new ResponseEntity<>(loginService.regenerateOtp(username, email,password, roleId), HttpStatus.OK);
    }
    @PutMapping("/change-pass-otp")
    public ResponseEntity<String> regenerateOtp(@RequestBody ChangePassRequest changePassRequest) {
        return new ResponseEntity<>(loginService.changePassByOTP(changePassRequest).toString(), HttpStatus.OK);
    }

}