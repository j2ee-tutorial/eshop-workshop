package com.tasnim.trade.eshop.service;

import com.tasnim.trade.eshop.api.UserService;
import com.tasnim.trade.eshop.repository.UserRepository;
import com.tasnim.trade.eshop.to.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImplBase<User> implements UserService {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserServiceImpl() {
        super(User.class);
    }

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public User save(User user) {
        String username = user.getUsername();
        user.setUsername(username.toLowerCase());

        if (repository.existsById(user.getUsername())) {
            LOGGER.warn("User {} already exists", user.getUsername());
        }

        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));

        return repository.save(user);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }


    @Override
    JpaRepository getRepository() {
        return repository;
    }
}
