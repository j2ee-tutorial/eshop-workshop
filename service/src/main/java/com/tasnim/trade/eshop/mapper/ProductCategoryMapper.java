package com.tasnim.trade.eshop.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mapper(componentModel = "spring", uses = {AuditMapper.class})
public interface ProductCategoryMapper {

    ProductCategoryMapper MAPPER = Mappers.getMapper(ProductCategoryMapper.class);

    Logger LOGGER = LoggerFactory.getLogger(ProductCategoryMapper.class);

//    @Mappings({
//            @Mapping(target = "masterCategory", ignore = true)
//    })
    com.tasnim.trade.eshop.dto.ProductCategory fromProductCategory(com.tasnim.trade.eshop.to.ProductCategory productCategory, @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    com.tasnim.trade.eshop.to.ProductCategory toProductCategory(com.tasnim.trade.eshop.dto.ProductCategory productCategory, @Context CycleAvoidingMappingContext context);

    // @AfterMapping
    default void addBackReference(@MappingTarget com.tasnim.trade.eshop.dto.ProductCategory target) {
        for (com.tasnim.trade.eshop.dto.ProductCategory productCategory : target.getSubCategories()) {
            productCategory.setMasterCategory(target);
        }
    }
}

