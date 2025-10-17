package org.yuanding.springbootauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.yuanding.springbootauth.controller.dto.CreateUserDto;
import org.yuanding.springbootauth.model.User;
import org.yuanding.springbootauth.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody CreateUserDto userVo) {
        User user=new User();
        user.setUserName(userVo.getUserName());
        user.setEmail(userVo.getEmail());
        user.setNickName(userVo.getNickName());
        user.setPassword(passwordEncoder.encode(userVo.getPassword()));
        user.setRegTime(LocalDateTime.now());
        userRepository.save(user);
        return user;
    }



    @GetMapping("/getUserByName")
    public User getUserByName(@RequestParam String userName) {
        return userRepository.findByUserName(userName);
    }

    @GetMapping("/getUserByEmail")
    public User getUserByEmail(@RequestParam String email) {
        return userRepository.findByEmail(email);
    }
}