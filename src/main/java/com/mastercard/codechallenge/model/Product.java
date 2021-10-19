package com.mastercard.codechallenge.model;

import com.mastercard.codechallenge.enums.ProductName;

public class Product {

    private ProductName productName;
    private double price;


    public Product(ProductName productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    public ProductName getProductName() {
        return productName;
    }

    public void setProductName(ProductName productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
