package com.springboot.architectural.util;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


@Component
public class EmailUtil {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${app.server-root}")
    private String serverRoot;

    public void sendOtpEmail(String email, String otp, String newPass, String roleId) throws MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject("Verify OTP");
        if (newPass == null || newPass.equals("") || newPass.isBlank() || newPass.isEmpty())
        {
            mimeMessageHelper.setText("""
        <div>
          <h1> OTP: %s  </h1>
          <h3>XEMPHIM-SOA</h3>
          <br/>
          <a href=%s/api/login/verify-account?email=%s&otp=%s&roleId=%s target="_blank">Or click link to verify</a>
        </div>
        """.formatted(otp,serverRoot,email, otp, roleId), true);
        }
        else
        {
            mimeMessageHelper.setText("""
        <div>
           <h3>XEMPHIM-SOA</h3>
           <h1> OTP: %s  </h1>
          <br/>
          <a href=%s/api/login/verify-account?email=%s&otp=%s&newPass=%s&roleId=%s target="_blank">or click link to verify</a>
        </div>
        """.formatted(otp,serverRoot,email, otp, newPass, roleId), true);
        }


        javaMailSender.send(mimeMessage);
    }
}