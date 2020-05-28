package com.tasnim.trade.eshop.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import javax.persistence.MappedSuperclass;

@Mapper(componentModel = "spring", uses = {AuditMapper.class})
public interface ProductMapper {

    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "name", target = "productName")
    @Mapping(source = "code", target = "productCode")
    com.tasnim.trade.eshop.dto.Product fromProduct(com.tasnim.trade.eshop.to.Product product);

    @InheritInverseConfiguration
    com.tasnim.trade.eshop.to.Product toProduct(com.tasnim.trade.eshop.dto.Product product);
}
