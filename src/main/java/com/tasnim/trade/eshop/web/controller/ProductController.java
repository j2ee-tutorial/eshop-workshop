package com.tasnim.trade.eshop.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/product")
@Controller
public class ProductController {

    @GetMapping("/list")
    public String index() {
        return "/product/index";
    }

    @GetMapping("/entry")
    public String entry() {
        return "/product/insert";
    }

    public String save() {
        return "/product/index";
    }
}
