package com.ms.catalog.web.controllers;

import com.ms.catalog.domain.PagedResult;
import com.ms.catalog.domain.Product;
import com.ms.catalog.domain.ProductNotFoundException;
import com.ms.catalog.domain.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
class ProductController {

    @Autowired
    private ProductService productService;

    //    ProductController(ProductService productService) {
    //        this.productService = productService;
    //    }

    @GetMapping
    PagedResult<Product> getProducts(@RequestParam(name = "page", defaultValue = "1") int pageNo) {
        return productService.getAllProducts(pageNo);
    }

    @GetMapping("/{code}")
    ResponseEntity<Product> getProduuctByCode(@PathVariable String code) {
        // sleep(6000);
        return productService
                .getProductByCode(code)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> ProductNotFoundException.forCode(code));
    }

    void sleep(long seconds) {
        try {
            Thread.sleep(seconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
