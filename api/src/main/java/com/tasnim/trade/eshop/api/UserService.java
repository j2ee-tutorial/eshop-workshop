package com.tasnim.trade.eshop.api;

import com.tasnim.trade.eshop.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    UserDto findByUsername(String username);

    UserDto save(UserDto user);

    List<UserDto> findAll();

    Page<UserDto> findAll(Pageable pageable);
}
