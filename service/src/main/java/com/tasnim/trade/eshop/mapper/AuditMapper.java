package com.tasnim.trade.eshop.mapper;

import com.tasnim.trade.eshop.dto.AuditDto;
import com.tasnim.trade.eshop.to.base.Audit;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuditMapper {

    AuditMapper MAPPER = Mappers.getMapper(AuditMapper.class);

    Audit toAudit(AuditDto auditDto);

    @InheritInverseConfiguration
    AuditDto fromAudit(Audit audit);
}
