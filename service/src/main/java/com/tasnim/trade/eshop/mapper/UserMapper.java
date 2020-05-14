package com.tasnim.trade.eshop.mapper;

import com.tasnim.trade.eshop.dto.UserDto;
import com.tasnim.trade.eshop.to.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserDto userDto);

    @InheritInverseConfiguration
    UserDto fromUser(User user);
}
