package com.tasnim.trade.eshop.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    com.tasnim.trade.eshop.to.Role toRole(com.tasnim.trade.eshop.dto.Role role);

    @InheritInverseConfiguration
    com.tasnim.trade.eshop.dto.Role fromRole(com.tasnim.trade.eshop.to.Role role);
}
