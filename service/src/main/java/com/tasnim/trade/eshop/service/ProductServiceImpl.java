package com.tasnim.trade.eshop.service;

import com.tasnim.trade.eshop.api.ProductService;
import com.tasnim.trade.eshop.dto.ProductDto;
import com.tasnim.trade.eshop.mapper.ProductMapper;
import com.tasnim.trade.eshop.repository.ProductRepository;
import com.tasnim.trade.eshop.to.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductMapper mapper;

    @Autowired
    ProductRepository repository;

    @Override
    public ProductDto save(ProductDto product) {
        LOGGER.info("Saving product");
        Product product1 = repository.save(mapper.toProduct(product));
        return mapper.fromProduct(product1);
    }

    @Override
    public List<ProductDto> findAll() {
        return repository.findAll().stream().map(mapper::fromProduct).collect(Collectors.toList());
    }

    @Override
    public Page<ProductDto> findAll(Pageable pageable) {
        Page<Product> page = repository.findAll(pageable);
        Converter<Product, ProductDto> converter = product -> mapper.fromProduct(product);
        return page.map(converter::convert);
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("Deleting product {}", id);
        repository.deleteById(id);
    }

    @Override
    public void delete(ProductDto product) {
        repository.delete(mapper.toProduct(product));
    }

    @Override
    public List<ProductDto> getTopProducts() {
        List<Product> products = repository.findAll();
        LOGGER.info("Number of products: {}", products.size());
        return products.stream().map(mapper::fromProduct).collect(Collectors.toList());
    }
}
