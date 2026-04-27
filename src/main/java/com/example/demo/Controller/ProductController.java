package com.example.demo.Controller;

import com.example.demo.dto.CreateProductRequest;
import com.example.demo.dto.ProductResponse;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public  ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return   productService.getAllProducts();

    }

    @GetMapping("/{id}")
    public ProductResponse getProduct(@PathVariable Long id ) {
        return productService.getProductById(id);

    }

    @PostMapping
    public ProductResponse createProduct(@Valid @RequestBody CreateProductRequest createdProduct) {
        return productService.createProduct(createdProduct);


    }

    @PatchMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
       return   productService.updateProduct(id, updatedProduct);


    }

    @DeleteMapping("/{id}")
     public String deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }


}

