package com.tasnim.trade.eshop.configuration.security;

import com.tasnim.trade.eshop.api.RoleService;
import com.tasnim.trade.eshop.api.UserService;
import com.tasnim.trade.eshop.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:security.properties")
public class SecurityInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger(SecurityInitializer.class);

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Value("${admin.password}")
    private String adminPassword;

    @EventListener
    public void addAdminUser(ApplicationReadyEvent event) {
        UserDto admin = new UserDto("admin");
//        admin.getRoles().add(new Role("ADMIN"));
//        admin.getRoles().add(new Role("USER"));
        admin.setPassword(adminPassword);
        userService.save(admin);
    }
}
