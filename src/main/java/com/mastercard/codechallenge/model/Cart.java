package com.mastercard.codechallenge.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Product> products;

    private float totalPrice;

    public Cart() {
        this.products = new ArrayList<>();
        totalPrice = 0;
    }

    public void addToCart(Product product){
        products.add(product);
        totalPrice+=product.getPrice();
    }

    public void removeFromCart(Product product){
        products.remove(product);
        totalPrice-=product.getPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getCartSize(){
        return products.size();
    }


    public List<Product> getProducts() {
        return products;
    }

    public void applyDiscountCoupon(double dicountedPrice){
        totalPrice-=dicountedPrice;
    }
}
