package com.tasnim.trade.eshop.web.service;

import com.tasnim.trade.eshop.api.ProductCategoryService;
import com.tasnim.trade.eshop.api.ProductService;
import com.tasnim.trade.eshop.dto.Product;
import com.tasnim.trade.eshop.dto.ProductCategory;
import com.tasnim.trade.eshop.dto.Response;
import com.tasnim.trade.eshop.dto.SuccessfulResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequestMapping("/api/v1/products")
@RestController
public class ProductRestfulService {

    private final ProductService service;

    @Autowired
    private ProductCategoryService productCategoryService;

    public ProductRestfulService(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Response> index(@RequestParam("productCategoryName") Optional<String> productCategoryName) {
        List<Product> products = Collections.emptyList();
        if (productCategoryName.isPresent()) {
            Optional<ProductCategory> productCategory = productCategoryService.findByName(productCategoryName.get());
            if (productCategory.isPresent()) {
                products = service.findAllByCategory(productCategory.get());
            }
        }
        return new ResponseEntity<>(new SuccessfulResponse<>(products), HttpStatus.OK);
    }

    @GetMapping("/top")
    public ResponseEntity<Response> getTopProducts() {
        List<Product> products = service.getTopProducts();
        return new ResponseEntity<>(new SuccessfulResponse<>(products), HttpStatus.OK);
    }

    @GetMapping("/festival")
    public ResponseEntity<Response> getFestivalProducts() {
        List<Product> products = service.getTopProducts();
        return new ResponseEntity<>(new SuccessfulResponse<>(products), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> save(@RequestBody Product product) {
        Product product1 = service.save(product);
        return ResponseEntity.ok(new SuccessfulResponse<>(product1));
    }
}
