package com.tasnim.trade.eshop.api;


import com.tasnim.trade.eshop.dto.ProductDto;
import com.tasnim.trade.eshop.to.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {AuditMapper.class})
public interface ProductMapper {

    final ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

    Product toProduct(ProductDto productDto);

    @InheritInverseConfiguration
    ProductDto fromProduct(Product product);
}
