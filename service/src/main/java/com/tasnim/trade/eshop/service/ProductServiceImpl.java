package com.tasnim.trade.eshop.service;

import com.tasnim.trade.eshop.api.ProductService;
import com.tasnim.trade.eshop.dto.Product;
import com.tasnim.trade.eshop.dto.ProductCategory;
import com.tasnim.trade.eshop.mapper.CycleAvoidingMappingContext;
import com.tasnim.trade.eshop.mapper.ProductCategoryMapper;
import com.tasnim.trade.eshop.mapper.ProductMapper;
import com.tasnim.trade.eshop.repository.ProductRepository;
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
    private ProductCategoryMapper productCategoryMapper;

    @Autowired
    ProductRepository repository;

    @Override
    public Product save(Product product) {
        LOGGER.info("Saving product");
        return mapper.fromProduct(repository.save(mapper.toProduct(product)));
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(mapper::fromProduct).collect(Collectors.toList());
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        Converter<com.tasnim.trade.eshop.to.Product, com.tasnim.trade.eshop.dto.Product> converter = product -> mapper.fromProduct(product);
        return repository.findAll(pageable).map(converter::convert);
    }

    @Override
    public Page<Product> findAllByCategory(ProductCategory productCategory, Pageable pageable) {
        Converter<com.tasnim.trade.eshop.to.Product, com.tasnim.trade.eshop.dto.Product> converter = product -> mapper.fromProduct(product);
        return repository.findAllByCategory(productCategoryMapper.toProductCategory(productCategory, new CycleAvoidingMappingContext()), pageable).map(converter::convert);
    }

    @Override
    public List<Product> findAllByCategory(ProductCategory productCategory) {
        Converter<com.tasnim.trade.eshop.to.Product, com.tasnim.trade.eshop.dto.Product> converter = product -> mapper.fromProduct(product);
        return repository.findAllByCategory(productCategoryMapper.toProductCategory(productCategory, new CycleAvoidingMappingContext()))
                .stream().map(converter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("Deleting product {}", id);
        repository.deleteById(id);
    }

    @Override
    public void delete(Product product) {
        repository.delete(mapper.toProduct(product));
    }

    @Override
    public List<Product> getTopProducts() {
        List<com.tasnim.trade.eshop.to.Product> products = repository.findAll();
        LOGGER.info("Number of products: {}", products.size());
        return products.stream().map(mapper::fromProduct).collect(Collectors.toList());
    }
}
