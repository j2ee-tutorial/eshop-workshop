package com.tasnim.trade.eshop.service;

import com.tasnim.trade.eshop.dto.Principal;
import com.tasnim.trade.eshop.repository.UserRepository;
import com.tasnim.trade.eshop.to.Role;
import com.tasnim.trade.eshop.to.User;
import com.tasnim.trade.eshop.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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
        Set<GrantedAuthority> grantedAuthorities = user.getRoles()
                .stream().map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());
        LOGGER.info(JsonUtil.jsonObject(grantedAuthorities));
        return new Principal(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
