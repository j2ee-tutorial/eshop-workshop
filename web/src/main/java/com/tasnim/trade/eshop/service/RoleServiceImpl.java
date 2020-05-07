package com.tasnim.trade.eshop.service;

import com.tasnim.trade.eshop.api.RoleService;
import com.tasnim.trade.eshop.api.UserService;
import com.tasnim.trade.eshop.repository.RoleRepository;
import com.tasnim.trade.eshop.repository.UserRepository;
import com.tasnim.trade.eshop.to.Role;
import com.tasnim.trade.eshop.to.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends ServiceImplBase<Role> implements RoleService {

    public static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    RoleRepository repository;

    protected RoleServiceImpl() {
        super(Role.class);
    }

    @Override
    JpaRepository getRepository() {
        return repository;
    }
}
