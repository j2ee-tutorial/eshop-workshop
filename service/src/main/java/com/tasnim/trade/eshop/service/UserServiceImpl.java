package com.tasnim.trade.eshop.service;

import com.tasnim.trade.eshop.api.UserService;
import com.tasnim.trade.eshop.dto.UserDto;
import com.tasnim.trade.eshop.mapper.UserMapper;
import com.tasnim.trade.eshop.repository.UserRepository;
import com.tasnim.trade.eshop.to.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends ServiceImplBase<User> implements UserService {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper mapper;

    @Autowired
    UserRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserServiceImpl() {
        super(User.class);
    }

    @Override
    public UserDto findByUsername(String username) {
        User user = repository.findByUsername(username);
        return mapper.fromUser(user);
    }

    @Override
    public UserDto save(UserDto user) {
        String username = user.getUsername();
        user.setUsername(username.toLowerCase());

        if (repository.existsById(user.getUsername())) {
            LOGGER.warn("User {} already exists", user.getUsername());
        }

        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));

        User user1 = repository.save(mapper.toUser(user));
        return mapper.fromUser(user1);
    }

    @Override
    public List<UserDto> findAll() {
        return repository.findAll().stream().map(mapper::fromUser).collect(Collectors.toList());
    }

    @Override
    JpaRepository getRepository() {
        return repository;
    }
}
