package com.springboot.architectural.service.imp;

import com.springboot.architectural.dto.RoleDTO;
import com.springboot.architectural.entity.ConsentOtpRedis;
import com.springboot.architectural.entity.Movie_User;
import com.springboot.architectural.mapper.RoleMapper;
import com.springboot.architectural.payload.Request.ChangePassRequest;
import com.springboot.architectural.payload.Request.SignUpRequest;
import com.springboot.architectural.repository.ConsentOtpRedisRepository;
import com.springboot.architectural.repository.MovieUserRepository;
import com.springboot.architectural.repository.RoleRepository;
import com.springboot.architectural.security.JwtTokenProvider;
import com.springboot.architectural.service.LoginService;
import com.springboot.architectural.service.RoleService;
import com.springboot.architectural.util.EmailUtil;
import com.springboot.architectural.util.OtpUtil;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
public class LoginServiceImp implements LoginService {
    @Autowired
    private MovieUserRepository movieUserRepository;
    @Autowired
    private RoleService roleService;

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private OtpUtil otpUtil;
    @Autowired
    private EmailUtil emailUtil;

    @Autowired
    ConsentOtpRedisRepository consentOtpRedisRepository;


    @Override
    public boolean addUser(SignUpRequest signUpRequest) {
        Movie_User account = new Movie_User();

        RoleDTO role = roleService.getById(signUpRequest.getRoleId());
        Optional<Movie_User> movieUser= movieUserRepository.findById(signUpRequest.getUsername());
        if (movieUser.isPresent()) return false;
        Optional<Movie_User> movieUseByEmail= movieUserRepository.findByEmail(signUpRequest.getEmail());
        if (movieUseByEmail.isPresent()) return false;
        if (role == null ) return false;
        String otp = otpUtil.generateOtp();
        try {
            emailUtil.sendOtpEmail(signUpRequest.getEmail(), otp,null, String.valueOf(signUpRequest.getRoleId()));
        } catch (MessagingException e) {
            throw new RuntimeException("Unable to send otp please try again");
        }
//        if (movieUser.isPresent() && !movieUser.get().getActive())
//        {
//            account.setUsername(movieUser.get().getUsername());
//            account.setEmail(signUpRequest.getEmail());
//            account.setOtp(otp);
//            account.setOtpGeneratedTime(LocalDateTime.now());
//            account.setPassword(passwordEncode);
//
//        }
        account.setRole(RoleMapper.INSTANCE.roleDtoToRole(role));
//        account.setAvatar(signUpRequest.get);
        account.setUsername(signUpRequest.getUsername());
        account.setEmail(signUpRequest.getEmail());
        String passwordEncode = passwordEncoder.encode(signUpRequest.getPassword());

        account.setPassword(passwordEncode);

        System.out.println(account.toString());
        try {
            movieUserRepository.save(account);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    @Override
    public Boolean addUserCustomer(SignUpRequest signUpRequest) {
        Movie_User account = new Movie_User();
        RoleDTO role = roleService.getById(signUpRequest.getRoleId());
        Optional<Movie_User> movieUser= movieUserRepository.findById(signUpRequest.getUsername());
        if (movieUser.isPresent()) return false;
        Optional<Movie_User> movieUseByEmail= movieUserRepository.findByEmail(signUpRequest.getEmail());
        if (movieUseByEmail.isPresent()) return false;
//        Optional<Movie_User> movieUserByEmail= movieUserRepository.findById(signUpRequest.getEmail());

        if (role == null ) return false;
        String otp = otpUtil.generateOtp();
        ConsentOtpRedis consentOtpRedis = new ConsentOtpRedis(signUpRequest.getUsername(),signUpRequest.getEmail(),signUpRequest.getPassword(),otp);

        System.out.println("consentOtpRedis" + consentOtpRedis);
        try {
            String deleteAccounts = consentOtpRedisRepository.deleteAllAccountRedis(signUpRequest.getEmail());
            consentOtpRedisRepository.save(consentOtpRedis);
            emailUtil.sendOtpEmail(signUpRequest.getEmail(), otp,null, String.valueOf(signUpRequest.getRoleId()));
        } catch (MessagingException e) {
            throw new RuntimeException("Unable to send otp please try again");
        }
//        if (movieUser.isPresent() && !movieUser.get().getActive())
//        {
//            account.setUsername(movieUser.get().getUsername());
//            account.setEmail(signUpRequest.getEmail());
//            account.setOtp(otp);
//            account.setOtpGeneratedTime(LocalDateTime.now());
//            account.setPassword(passwordEncode);
//
//        }
//        account.setRole(RoleMapper.INSTANCE.roleDtoToRole(role));
////        account.setAvatar(signUpRequest.get);
//        account.setUsername(signUpRequest.getUsername());
//        account.setEmail(signUpRequest.getEmail());
//        String passwordEncode = passwordEncoder.encode(signUpRequest.getPassword());
//
//        account.setPassword(passwordEncode);

//        System.out.println(account.toString());
//        try {
//            movieUserRepository.save(account);
//            return true;
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//            return false;
//        }
        return  true;
    }

    @Override
    public boolean checkLogin(String userName,String email, String password) {
        Optional<Movie_User> account = movieUserRepository.findByUsernameOrEmail(userName, email);
        if (account.isEmpty()) return false;
        return  passwordEncoder.matches(password, account.get().getPassword());
    }


    @Override
    public String login(String userName, String email, String password) {
        if (!email.isEmpty()) userName = movieUserRepository.findByEmail(email).get().getUsername();
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userName, password
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token =  jwtTokenProvider.generateToken(authentication);
        return token;
    }
    public Boolean changePassByOldPass (ChangePassRequest changePassRequest) {
        System.out.println(changePassRequest);
        Optional<Movie_User> account = movieUserRepository.findById(changePassRequest.getUsername());
        if (account.isEmpty()) return false;
        if (!passwordEncoder.matches(changePassRequest.getPassword(), account.get().getPassword())) return false;
        String newPasswordEncode = passwordEncoder.encode(changePassRequest.getNewPassword());
        account.get().setPassword(newPasswordEncode);
        movieUserRepository.save(account.get());
        return true;
    }
    public Boolean changePassByOTP (ChangePassRequest changePassRequest) {
        Optional<Movie_User> account = movieUserRepository.findById(changePassRequest.getUsername());
        if (account.isEmpty()) return false;
        if (!Objects.equals(changePassRequest.getEmail(), account.get().getEmail())) return false;
        String otp = otpUtil.generateOtp();
        try {
            ConsentOtpRedis consentOtpRedis = new ConsentOtpRedis(changePassRequest.getUsername(),changePassRequest.getEmail(),changePassRequest.getPassword(),otp);
            consentOtpRedisRepository.save(consentOtpRedis);
//            account.get().setOtp(otp);
//            account.get().setOtpGeneratedTime(LocalDateTime.now());
//            movieUserRepository.save(account.get());
            emailUtil.sendOtpEmail(changePassRequest.getEmail(), otp, changePassRequest.getNewPassword(), changePassRequest.getRoleId());
        } catch (MessagingException e) {
            throw new RuntimeException("Unable to send otp please try again");
        }


//        String passwordEncode = passwordEncoder.encode(changePassRequest.getPassword());
//        if (passwordEncode !=account.get().getPassword()) return false;
//        String newPasswordEncode = passwordEncoder.encode(changePassRequest.getNewPassword());
//        account.get().setPassword(newPasswordEncode);
//        movieUserRepository.save(account.get());
        return true;
    }
    public String regenerateOtp(String username, String email, String password, String roleId) {
        Optional<Movie_User> user = movieUserRepository.findByEmail(email);
//        String deleteAccountsRedis = consentOtpRedisRepository.deleteAllAccountRedis(email);
        String otp = otpUtil.generateOtp();
        ConsentOtpRedis consentOtpRedis = new ConsentOtpRedis(username,email,password,otp);
        try {
            emailUtil.sendOtpEmail(email, otp, null, roleId);
            consentOtpRedisRepository.save(consentOtpRedis);
        } catch (MessagingException e) {
            throw new RuntimeException("Unable to send otp please try again");
        }
        consentOtpRedisRepository.save(consentOtpRedis);
        return "Email sent... please verify account within 2 minute";
    }


    public String verifyAccount(String email, String otp, String newPass, String roleId) {
        ConsentOtpRedis consentOtpRedis = consentOtpRedisRepository.findConsentOtpRedisById(otp, email);
//        System.out.println(consentOtpRedis + "99999999999999999999999999999999999");
        if (consentOtpRedis == null) return "Please regenerate otp and try again";
        Optional<Movie_User> user = movieUserRepository.findByEmail(email);
        if (!newPass.isEmpty())
        {
            if (user.isEmpty() || !Objects.equals(user.get().getUsername(), consentOtpRedis.getUsername())) return "Email is not match";
        }
        else if (user.isPresent()) return "Email is used";
        Movie_User account = new Movie_User();
        account.setUsername(consentOtpRedis.getUsername());
        account.setEmail(consentOtpRedis.getEmail());
        if (consentOtpRedis.getPassword() != null) account.setPassword(passwordEncoder.encode(consentOtpRedis.getPassword()));
        if (!newPass.isEmpty()) account.setPassword(passwordEncoder.encode(newPass));
        if (roleId == null) return "Role not found";
        if (consentOtpRedis.getOtp().equals(otp)) {
            account.setRole(roleRepository.getById(Integer.valueOf(roleId)));
            movieUserRepository.save(account);
            return "OTP verified you can login";
        }
        return "Please regenerate otp and try again";
    }
}
