package com.tasnim.trade.eshop.service;

import com.tasnim.trade.eshop.api.ProductCategoryService;
import com.tasnim.trade.eshop.dto.ProductCategory;
import com.tasnim.trade.eshop.mapper.ProductCategoryMapper;
import com.tasnim.trade.eshop.repository.ProductCategoryRepository;
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
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductCategoryServiceImpl.class);

    @Autowired
    private ProductCategoryMapper mapper;

    @Autowired
    ProductCategoryRepository repository;

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        LOGGER.info("Saving product category");
        return mapper.fromProductCategory(repository.save(mapper.toProductCategory(productCategory)));
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll().stream().map(mapper::fromProductCategory).collect(Collectors.toList());
    }

    @Override
    public Page<ProductCategory> findAll(Pageable pageable) {
        Converter<com.tasnim.trade.eshop.to.ProductCategory, com.tasnim.trade.eshop.dto.ProductCategory> converter = productCategory -> mapper.fromProductCategory(productCategory);
        return repository.findAll(pageable).map(converter::convert);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(ProductCategory productCategory) {

    }
}
