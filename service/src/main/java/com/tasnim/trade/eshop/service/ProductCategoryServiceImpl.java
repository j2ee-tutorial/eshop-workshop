package com.tasnim.trade.eshop.service;

import com.tasnim.trade.eshop.api.ProductCategoryService;
import com.tasnim.trade.eshop.dto.ProductCategory;
import com.tasnim.trade.eshop.exception.MyDataIntegrityViolationException;
import com.tasnim.trade.eshop.mapper.CycleAvoidingMappingContext;
import com.tasnim.trade.eshop.mapper.ProductCategoryIgnoreParentMapper;
import com.tasnim.trade.eshop.mapper.ProductCategoryMapper;
import com.tasnim.trade.eshop.repository.ProductCategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.tasnim.trade.eshop.specification.ProductCategorySpecifications.nameStartsWith;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductCategoryServiceImpl.class);

    @Autowired
    private ProductCategoryMapper mapper;

    @Autowired
    private ProductCategoryIgnoreParentMapper productCategoryIgnoreParentMapper;

    @Autowired
    ProductCategoryRepository repository;

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        LOGGER.info("Saving product category");
        CycleAvoidingMappingContext mappingContext = new CycleAvoidingMappingContext();
        return mapper.fromProductCategory(
                repository.save(mapper.toProductCategory(productCategory, mappingContext)), mappingContext
        );
    }

    @Override
    public List<ProductCategory> findAll() {
        CycleAvoidingMappingContext mappingContext = new CycleAvoidingMappingContext();
        return repository.findAll()
                .stream().map(p -> mapper.fromProductCategory(p, mappingContext))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductCategory> findRoot() {
        return repository.findAllRootCategories()
                .stream().map(productCategoryIgnoreParentMapper::fromProductCategory)
                .collect(Collectors.toList());
    }

    @Override
    public Page<ProductCategory> findAll(Pageable pageable) {
        CycleAvoidingMappingContext mappingContext = new CycleAvoidingMappingContext();
        Converter<com.tasnim.trade.eshop.to.ProductCategory, com.tasnim.trade.eshop.dto.ProductCategory> converter = productCategory -> mapper.fromProductCategory(productCategory, mappingContext);
        return repository.findAll(pageable).map(converter::convert);
    }

    @Override
    public void delete(Long id) {
        try {
            LOGGER.info("Deleting product category {}", id);
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            // LOGGER.error(e.getMessage(), e);
            throw new MyDataIntegrityViolationException(e);
        }
    }

    private void print(Throwable e) {
        LOGGER.error("{} -> {}", e.getClass().getSimpleName(), e.getMessage());
        if (e.getCause() != null)
            print(e.getCause());
    }

    @Override
    public void delete(ProductCategory productCategory) {
        CycleAvoidingMappingContext mappingContext = new CycleAvoidingMappingContext();
        repository.delete(mapper.toProductCategory(productCategory, mappingContext));
    }

    @Override
    public Optional<ProductCategory> findById(Long id) {
        CycleAvoidingMappingContext mappingContext = new CycleAvoidingMappingContext();
        return repository.findById(id).map(p -> mapper.fromProductCategory(p, mappingContext));
    }

    @Override
    public Optional<ProductCategory> findByName(String name) {
        CycleAvoidingMappingContext mappingContext = new CycleAvoidingMappingContext();
        return repository.findByName(name).map(p -> mapper.fromProductCategory(p, mappingContext));
    }


    /*
    public List<com.tasnim.trade.eshop.to.ProductCategory> findByNameContains(String phrase) {
        return repository.findAll(nameContains(phrase).or(nameStartsWith(phrase)));
    }

     */
}
