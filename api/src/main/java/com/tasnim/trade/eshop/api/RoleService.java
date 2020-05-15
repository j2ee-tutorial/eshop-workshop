package com.tasnim.trade.eshop.api;

import com.tasnim.trade.eshop.dto.Role;

public interface RoleService {
    Role findByName(String name);

    boolean exists(String name);
}
