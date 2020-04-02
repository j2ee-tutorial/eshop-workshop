package com.tasnim.trade.eshop.api;

import com.tasnim.trade.eshop.to.User;

public interface UserService {
    User findByUsername(String username);

    User save(User user);

}
