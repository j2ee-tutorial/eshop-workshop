package com.tasnim.trade.eshop.api;

import com.tasnim.trade.eshop.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    ProductDto save(ProductDto product);

    List<ProductDto> findAll();

    Page<ProductDto> findAll(Pageable pageable);

    void delete(Long id);

    void delete(ProductDto product);

    List<ProductDto> getTopProducts();
}
