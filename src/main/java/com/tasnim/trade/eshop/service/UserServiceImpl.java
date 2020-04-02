package com.tasnim.trade.eshop.service;

import com.tasnim.trade.eshop.api.UserService;
import com.tasnim.trade.eshop.repository.UserRepository;
import com.tasnim.trade.eshop.to.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (repository.existsById(user.getUsername()))
            LOGGER.warn("User {} already exists", user.getUsername());
        return repository.save(user);
    }
}
