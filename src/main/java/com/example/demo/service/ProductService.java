package com.example.demo.service;

import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

  private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
       this.productRepository = productRepository;

    }

    public Product createProduct(Product product ) {
      return productRepository.save(product);

    }

    public List<Product> getAllProducts() {
      return productRepository.findAll();
    }

    public Product getProductById(Long id) {
      return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product Not Found with id: "+ id ));
    }

    public Product updateProduct(Long id, Product updatedProduct ) {
      Optional<Product> productToBeUpdated = productRepository.findById(id);
      if(productToBeUpdated.isPresent()){
          Product existingProduct = productToBeUpdated.get();

          existingProduct.setName(updatedProduct.getName());
          existingProduct.setQuantity(updatedProduct.getQuantity());
          existingProduct.setPrice(updatedProduct.getPrice());
          return productRepository.save(existingProduct);


      }
      throw new RuntimeException("Product not found");

    }


    public String deleteProduct(Long id) {
      if(productRepository.existsById(id)) {
          productRepository.deleteById(id);
          return "Product Deleted Successfully";
      }
      return "User not found";

    }


}
