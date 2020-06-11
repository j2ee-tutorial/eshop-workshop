package com.tasnim.trade.eshop.specification;

import com.tasnim.trade.eshop.to.Product;
import com.tasnim.trade.eshop.to.Product_;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.Assert;

public class ProductSpecifications {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductSpecifications.class);

    public static Specification<Product> priceIsBetween(Double min, Double max) {
        return (Specification<Product>) (product, query, builder) -> builder.between(product.get(Product_.amount), min, max);
    }

    public static Specification<Product> nameStartWith(String searchTerm) {
        return (Specification<Product>) (product, query, builder) -> builder.like(builder.lower(product.get(Product_.name)), startWithPattern(searchTerm));
    }

    private static String startWithPattern(final String searchTerm) {
        Assert.isTrue(searchTerm != null && !searchTerm.isEmpty(), () -> "Search term could not be empty");
        LOGGER.info((searchTerm + "%").toLowerCase());
        return (searchTerm + "%").toLowerCase();
    }
}
