package com.tasnim.trade.eshop.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    com.tasnim.trade.eshop.to.User toUser(com.tasnim.trade.eshop.dto.User user);

    @InheritInverseConfiguration
    com.tasnim.trade.eshop.dto.User fromUser(com.tasnim.trade.eshop.to.User user);
}
