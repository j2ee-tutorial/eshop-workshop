package com.tasnim.trade.eshop.web.service;

import com.tasnim.trade.eshop.api.ProductService;
import com.tasnim.trade.eshop.dto.ProductDto;
import com.tasnim.trade.eshop.dto.Response;
import com.tasnim.trade.eshop.dto.SuccessfulResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/api/v1/products")
@RestController
public class ProductRestfulService {

    private final ProductService service;

    public ProductRestfulService(ProductService service) {
        this.service = service;
    }

    @GetMapping("/top")
    public ResponseEntity<Response> getTopProducts() {
        List<ProductDto> products = service.getTopProducts();
        return new ResponseEntity<>(new SuccessfulResponse<>(products), HttpStatus.OK);
    }

    @GetMapping("/festival")
    public ResponseEntity<Response> getFestivalProducts() {
        List<ProductDto> products = service.getTopProducts();
        return new ResponseEntity<>(new SuccessfulResponse<>(products), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> save(@RequestBody ProductDto product) {
        ProductDto product1 = service.save(product);
        return ResponseEntity.ok(new SuccessfulResponse<>(product1));
    }
}
