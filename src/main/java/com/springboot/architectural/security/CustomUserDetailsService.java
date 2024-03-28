package com.springboot.architectural.security;
import com.springboot.architectural.entity.Movie_User;
import com.springboot.architectural.repository.MovieUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@AllArgsConstructor
@Service()
public class CustomUserDetailsService implements UserDetailsService {
    private MovieUserRepository movieUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Movie_User user = movieUserRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not exists by Username or Email"));

        System.out.println(user.getRole());

        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getName());

        return new User(
                username,
                user.getPassword(),
                new ArrayList<GrantedAuthority>(){{add(authority);}}
        );
    }
}
