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
        needle.setName("Needle");
        entityManager.persist(needle);
        entityManager.flush();

        // when
        Product found = productRepository.findByName(needle.getName());

        // then
        assertThat(found.getName())
                .isEqualTo(needle.getName());
    }

    @Test
    public void saveMicroCannula() {
        Product microCannula = new Product();
        microCannula.setName("Micro Cannula");
        entityManager.persist(microCannula);
        entityManager.flush();

        // when
        Product found = productRepository.findByName(microCannula.getName());
        LOGGER.info(">>>> {} {}", found.getId(), found.getName());
    }

    @Test
    public void allProducts() {
        List<Product> products = productRepository.findAll();
        LOGGER.info(">>>> Products count: {}", products.size());
    }
}