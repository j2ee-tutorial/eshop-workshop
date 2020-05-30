package com.tasnim.trade.eshop.web.controller;

import com.tasnim.trade.eshop.api.ProductCategoryService;
import com.tasnim.trade.eshop.dto.ProductCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/productCategory")
public class ProductCategoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductCategoryController.class);

    @Autowired
    ProductCategoryService service;

    @GetMapping("/list")
    public String index(Model model,
                        @RequestParam("page") Optional<Integer> page,
                        @RequestParam("size") Optional<Integer> size) {
        LOGGER.info("Show all product categories");

        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        Page<ProductCategory> productCategories = service.findAll(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("productCategories", productCategories);
        int totalPages = productCategories.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream
                    .rangeClosed(1, totalPages)
                    .boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "product-category/index";
    }

    @GetMapping("/entry")
    public String entry(Model model) {
        model.addAttribute("productCategory", new ProductCategory());
        return "product-category/insert";
    }

    @PostMapping("/save")
    public String save(ProductCategory productCategory) {
        try {
            LOGGER.info("Saving product category");
            ProductCategory product1 = service.save(productCategory);
            LOGGER.info("Product {} saved successfully!", product1.getId());
            return "redirect:/productCategory/list";
        } catch (Exception e) {
            LOGGER.error("Error during saving product", e);
            return null;
        }
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable Long id) {
        LOGGER.info("Remove entity id: {}", id);
        service.delete(id);
        return "redirect:/product-category/list";
    }
}
