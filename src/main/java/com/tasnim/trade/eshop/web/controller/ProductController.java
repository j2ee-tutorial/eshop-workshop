package com.tasnim.trade.eshop.web.controller;

import com.tasnim.trade.eshop.service.ProductService;
import com.tasnim.trade.eshop.to.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/product")
@Controller
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService service;

    @GetMapping("/list")
    public String index(Model model) {
        LOGGER.info("Show all products");
        List<Product> products = service.findAll();
        model.addAttribute("products", products);
        return "product/index";
    }

    @GetMapping("/entry")
    public String entry(Model model) {
        model.addAttribute("product", new Product());
        return "product/insert";
    }

    @PostMapping("/save")
    public String save(Product product, Model model) {
        try {
            LOGGER.info("Saving product");
            service.save(product);
            LOGGER.info("Product saved successfully!");
            return "redirect:/product/list";
        } catch (Exception e) {
            LOGGER.error("Error during saving product", e);
            return null;
        }
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable Long id) {
        LOGGER.info("Remove entity id: {}", id);
        service.delete(id);
        return "redirect:/product/list";
    }

    @PostMapping("/remove")
    public String remove(@ModelAttribute(value = "selectedItem") Product product) {
        LOGGER.info("Remove entity entity-id: {}", product.getId());
        service.delete(product);
        return "redirect:/product/list";
    }
}
