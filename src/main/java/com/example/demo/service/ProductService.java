package com.example.demo.service;

import com.example.demo.dto.CreateProductRequest;
import com.example.demo.dto.ProductResponse;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;



@Service
public class ProductService {


  private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
       this.productRepository = productRepository;

    }

  public List<ProductResponse> getAllProducts() {
    return productRepository.findAll().stream().map(this::toResponse).toList();
  }

  public ProductResponse getProductById(Long id) {
     Product product = productRepository.findById(id).orElseThrow( () -> new ProductNotFoundException("Product not found with id: "+ id) );
 return toResponse(product);
  }

    public  ProductResponse createProduct(CreateProductRequest request ) {
      Product product = new Product();
      product.setName(request.getName());
      product.setQuantity(request.getQuantity());
      product.setPrice(request.getPrice());
      return toResponse(productRepository.save(product));

    }



    public ProductResponse updateProduct(@PathVariable Long id, @Valid @RequestBody Product updatedProduct) {
      Product existingProduct = productRepository.findById(id).orElseThrow( () -> new ProductNotFoundException("Product not found with id: "+ id) );
      existingProduct.setName(updatedProduct.getName());
      existingProduct.setQuantity(updatedProduct.getQuantity());
      existingProduct.setPrice(updatedProduct.getPrice());
      return  toResponse( productRepository.save(existingProduct));

    }


    public String deleteProduct(@PathVariable Long id) {
      if(productRepository.existsById(id)) {
          productRepository.deleteById(id);
          return "Product Deleted Successfully";
      }
      return "Product not found";
    }

    private ProductResponse toResponse(Product product) {
      return new ProductResponse(
              product.getId(),
              product.getName(),
              product.getPrice(),
              product.getQuantity()
      );
    }


}
