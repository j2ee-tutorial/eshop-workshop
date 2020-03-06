package com.tasnim.trade.eshop.web.controller;

import com.tasnim.trade.eshop.service.ProductService;
import com.tasnim.trade.eshop.to.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/product")
@Controller
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService service;

    @GetMapping("/list")
    public String index() {
        service.findAll();
        return "/product/index";
    }

    @GetMapping("/entry")
    public String entry(Model model) {
        model.addAttribute("product", new Product());
        return "/product/insert";
    }

    @PostMapping("/save")
    public String save(Product product) {
        try {
            LOGGER.info("Saving product");
            service.save(product);
            LOGGER.info("Product saved successfully!");
            return "/product/index";
        } catch (Exception e) {
            LOGGER.error("Error during saving product", e);
            return null;
        }
    }
}
