package com.tasnim.trade.eshop.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuditMapper {

    AuditMapper MAPPER = Mappers.getMapper(AuditMapper.class);

    com.tasnim.trade.eshop.to.base.Audit toAudit(com.tasnim.trade.eshop.dto.base.Audit audit);

    @InheritInverseConfiguration
    com.tasnim.trade.eshop.dto.base.Audit fromAudit(com.tasnim.trade.eshop.to.base.Audit audit);
}
