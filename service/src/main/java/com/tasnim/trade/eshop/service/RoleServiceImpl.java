package com.tasnim.trade.eshop.service;

import com.tasnim.trade.eshop.api.RoleService;
import com.tasnim.trade.eshop.dto.Role;
import com.tasnim.trade.eshop.mapper.RoleMapper;
import com.tasnim.trade.eshop.repository.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ServiceImplBase<com.tasnim.trade.eshop.to.Role> implements RoleService {

    public static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleMapper mapper;

    @Autowired
    RoleRepository repository;

    protected RoleServiceImpl() {
        super(com.tasnim.trade.eshop.to.Role.class);
    }

    @Override
    JpaRepository getRepository() {
        return repository;
    }

    @Override
    public Role findByName(String name) {
        return mapper.fromRole(repository.findByName(name));
    }

    @Override
    public boolean exists(String name){
        return repository.existsByName(name);
    }
}
