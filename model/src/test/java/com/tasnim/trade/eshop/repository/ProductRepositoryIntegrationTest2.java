package com.tasnim.trade.eshop.repository;

import com.tasnim.trade.eshop.to.Product;
import com.tasnim.trade.eshop.to.Role;
import com.tasnim.trade.eshop.to.User;
import com.tasnim.trade.eshop.to.base.Printable;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
class ProductRepositoryIntegrationTest2 {

    public static final Logger LOGGER = LoggerFactory.getLogger(ProductRepositoryIntegrationTest.class);

    @Autowired
    ProductRepository productRepository;

    @Test
    void listAllProducts() {
        Product product1 = new Product();
        product1.setName("Test01");
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("Test01");
        productRepository.save(product2);

        LOGGER.info("----------------------------------------");
        List<Product> products = productRepository.findAll();
        products.stream().map(Printable::format).forEach(LOGGER::info);

        LOGGER.info("----------------------------------------");
        productRepository.remove(product1);
        products = productRepository.findAll();
        products.stream().map(Printable::format).forEach(LOGGER::info);
    }

    /*
    @Test
    void saveUserWithRoles() {
        User admin = new User("John");
        admin.getRoles().add(new Role("USER"));
        userRepository.save(admin);

        // when
        User user = userRepository.findByUsername("John");

        // then
        Assertions.assertThat(user.getRoles()).isNotEmpty();
        Assertions.assertThat(user.getRoles()).extracting(Role::getName).contains("USER");
    }
    */
}