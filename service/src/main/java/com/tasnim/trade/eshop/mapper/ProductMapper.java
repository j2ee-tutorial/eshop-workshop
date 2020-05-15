package com.tasnim.trade.eshop.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {AuditMapper.class})
public interface ProductMapper {

    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

    com.tasnim.trade.eshop.to.Product toProduct(com.tasnim.trade.eshop.dto.Product product);

    @InheritInverseConfiguration
    com.tasnim.trade.eshop.dto.Product fromProduct(com.tasnim.trade.eshop.to.Product product);
}
