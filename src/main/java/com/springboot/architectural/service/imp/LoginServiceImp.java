package com.springboot.architectural.service.imp;

import com.springboot.architectural.dto.RoleDTO;
import com.springboot.architectural.entity.Movie_User;
import com.springboot.architectural.mapper.RoleMapper;
import com.springboot.architectural.payload.Request.SignUpRequest;
import com.springboot.architectural.repository.MovieUserRepository;
import com.springboot.architectural.security.JwtTokenProvider;
import com.springboot.architectural.service.LoginService;
import com.springboot.architectural.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImp implements LoginService {
    @Autowired
    private MovieUserRepository movieUserRepository;
    @Autowired
    private RoleService roleService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean addUser(SignUpRequest signUpRequest) {
        Movie_User account = new Movie_User();
        RoleDTO role = roleService.getById(signUpRequest.getRole_id());
        if (role == null) return false;
        account.setRole(RoleMapper.INSTANCE.roleDtoToRole(role));
//        account.setAvatar(signUpRequest.get);
        account.setUsername(signUpRequest.getUsername());
//        account.setFirstName(signUpRequest.getFirstName());
//        account.setLastName(signUpRequest.getLastName());
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
    public boolean checkLogin(String userName, String password) {
        Optional<Movie_User> account = movieUserRepository.findById(userName);
        return account.isPresent() && passwordEncoder.matches(password, account.get().getPassword());
    }

    @Override
    public String login(String userName, String password) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userName, password
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token =  jwtTokenProvider.generateToken(authentication);
        return token;
    }
}
