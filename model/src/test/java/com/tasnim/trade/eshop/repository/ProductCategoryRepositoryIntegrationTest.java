package com.tasnim.trade.eshop.repository;

import com.tasnim.trade.eshop.to.ProductCategory;
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

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.ANY;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = ANY)
public class ProductCategoryRepositoryIntegrationTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductCategoryRepositoryIntegrationTest.class);

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void whenItemsSaveUnderGel_thenGelShouldConsistAllThatItems() {
        // given
        ProductCategory gel = new ProductCategory("Gel");
        gel.getSubCategories().add(new ProductCategory("Gel1"));
        gel.getSubCategories().add(new ProductCategory("Gel2"));
        entityManager.persist(gel);
        entityManager.flush();

        // when
        /*
        List<ProductCategory> found = productCategoryRepository.findByName(gel.getName());

        found.forEach(category -> {
            LOGGER.info(category.getName());
            if (category.getSubCategories() != null) {
                category.getSubCategories().forEach(pc -> LOGGER.info(pc.getName()));
            }
        });
        */

        ProductCategory found = productCategoryRepository.findByName(gel.getName());

        LOGGER.info(found.getName());
        if (found.getSubCategories() != null) {
            found.getSubCategories().forEach(productCategory -> LOGGER.info(productCategory.getName()));
        }

        // then
//        assertThat(found.getName())
//                .isEqualTo(needle.getName());
    }
}