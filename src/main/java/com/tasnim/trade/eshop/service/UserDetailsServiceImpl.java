package com.tasnim.trade.eshop.service;

import com.tasnim.trade.eshop.dto.Principal;
import com.tasnim.trade.eshop.repository.UserRepository;
import com.tasnim.trade.eshop.to.User;
import com.tasnim.trade.eshop.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    UserRepository repository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info("Get user {} from database", username);
        User user = repository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException(username);
        LOGGER.info(JsonUtil.jsonObject(user));

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        return new Principal(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
