package com.springboot.architectural.service.imp;

import com.springboot.architectural.dto.RoleDTO;
import com.springboot.architectural.entity.Movie_User;
import com.springboot.architectural.entity.Role;
import com.springboot.architectural.mapper.RoleMapper;
import com.springboot.architectural.payload.Request.SignUpRequest;
import com.springboot.architectural.repository.Movie_UserRepository;
import com.springboot.architectural.service.Movie_UserService;
import com.springboot.architectural.service.RoleService;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class Movie_UserServiceImp implements Movie_UserService {
    @Autowired
    private Movie_UserRepository accountRepository;
    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean addUser(SignUpRequest signUpRequest) {
        Movie_User account = new Movie_User();
        RoleDTO role = roleService.getById(signUpRequest.getRole_id());
        if (role == null) return false;
        account.setRole(RoleMapper.INSTANCE.roleDtoToRole(role));
        account.setUsername(signUpRequest.getUsername());
        String passwordEncode = passwordEncoder.encode(signUpRequest.getPassword());
        account.setPassword(passwordEncode);
        try {
            accountRepository.save(account);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean checkLogin(String userName, String password) {
        Optional<Movie_User> account = accountRepository.findById(userName);
        return account.isPresent() && passwordEncoder.matches(password, account.get().getPassword());
    }
}
