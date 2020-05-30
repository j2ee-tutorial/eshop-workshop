package com.tasnim.trade.eshop.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {AuditMapper.class})
public interface ProductCategoryMapper {

    ProductCategoryMapper MAPPER = Mappers.getMapper(ProductCategoryMapper.class);

    @Mapping(target = "subCategories", ignore = true)
    com.tasnim.trade.eshop.dto.ProductCategory fromProductCategory(com.tasnim.trade.eshop.to.ProductCategory product);

    @InheritInverseConfiguration
    com.tasnim.trade.eshop.to.ProductCategory toProductCategory(com.tasnim.trade.eshop.dto.ProductCategory product);
}
