package org.yuanding.springbootauth.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.yuanding.springbootauth.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("aaaaaaa");
        org.yuanding.springbootauth.model.User myUser = userRepository.findByUserName(username);

        return User.withUsername(myUser.getUserName())
                .password(myUser.getPassword())
                .roles(myUser.getRole().toString())
                .build();
    }
}
