package com.tasnim.trade.eshop.api;

import com.tasnim.trade.eshop.dto.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    User findByUsername(String username);

    User save(User user);

    boolean exists(User user);

    List<User> findAll();

    Page<User> findAll(Pageable pageable);
}
