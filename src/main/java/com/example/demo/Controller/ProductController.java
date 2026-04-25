package com.example.demo.Controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
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
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id ) {
        return productService.getProductById(id);

    }

    @PostMapping
    public Product createProduct(@RequestBody Product createdProduct) {
        return productService.createProduct(createdProduct);

    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        return productService.updateProduct(id, updatedProduct);

    }

    @DeleteMapping("/{id}")
     public String deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }


}

