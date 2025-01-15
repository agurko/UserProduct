package com.example.UserProduct;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final List<UserDetails> users = new ArrayList<>();
    public UserDetailsServiceImpl() {
        users.add(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build());
        users.add(User.withDefaultPasswordEncoder().username("admin").password("admin").roles("ADMIN").build());
    }
    @Override
    public UserDetails loadUser ByUsername(String username) throws UsernameNotFoundException {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("User  not found"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}

