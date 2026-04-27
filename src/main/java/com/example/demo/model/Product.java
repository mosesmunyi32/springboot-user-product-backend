package com.example.demo.model;
import jakarta.persistence.*;
import jakarta.validation.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;


@Entity
//@Table(name = "products")
    public class Product {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;


        @NotBlank(message = "name cannot be blank")
        private String name;

        @Min(value = 0, message = "Quantity cannot be negative")
        private int quantity;

        @Positive(message = "Price must be greater than zero")
        private BigDecimal price;

        public  Product() {

        }



        public Product(Long id, String name, BigDecimal price, int quantity) {
            this.id = id;
            this.name= name;
            this.price=price;
            this.quantity = quantity;
        }


        public Long  getId () {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
             this.name = name;
        }

        public  int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity= quantity;
        }


        public BigDecimal getPrice(){
            return price;
        }

        public void setPrice(BigDecimal price ) {
             this.price = price;
        }



}
