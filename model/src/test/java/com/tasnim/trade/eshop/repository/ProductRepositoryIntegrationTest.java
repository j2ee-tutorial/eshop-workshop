package com.tasnim.trade.eshop.repository;

import com.tasnim.trade.eshop.to.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.ANY;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = ANY)
public class ProductRepositoryIntegrationTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductRepositoryIntegrationTest.class);

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
        Product needle = new Product();
        needle.setProductName("Needle");
        entityManager.persist(needle);
        entityManager.flush();

        // when
        Product found = productRepository.findByProductName(needle.getProductName());

        // then
        assertThat(found.getProductName())
                .isEqualTo(needle.getProductName());
    }

    @Test
    public void saveMicroCannula() {
        Product microCannula = new Product();
        microCannula.setProductName("Micro Cannula");
        entityManager.persist(microCannula);
        entityManager.flush();

        // when
        Product found = productRepository.findByProductName(microCannula.getProductName());
        LOGGER.info(">>>> {} {}", found.getId(), found.getProductName());
    }

    @Test
    public void allProducts() {
        List<Product> products = productRepository.findAll();
        LOGGER.info(">>>> Products count: {}", products.size());
    }
}