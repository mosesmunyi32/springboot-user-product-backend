package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.math.BigInteger;


public class CreateProductRequest {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Positive(message = "Price must be positive")
    private BigDecimal price;

    @NotBlank(message = "Quantity cannot be blank")
    private int quantity;


    public CreateProductRequest() {

    }

    public CreateProductRequest(String name, BigDecimal price, int quantity) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

   public void setPrice(BigDecimal price) {  this.price = price;   }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
