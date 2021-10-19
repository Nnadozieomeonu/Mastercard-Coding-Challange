package com.mastercard.codechallenge.customdata;

import com.mastercard.codechallenge.enums.ProductName;

import java.util.*;

public class CustomDataStructure {
    private boolean aBoolean;
    private double prices;
    private Map<ProductName, Double> productNameDoubleMap = new HashMap<>();

    public Map<ProductName, Double> getProductNameDoubleMap() {
        return productNameDoubleMap;
    }

    public void setProductNameDoubleMap(ProductName productName, double prices) {
        productNameDoubleMap.put(productName,prices);
    }

    public boolean isaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    public double getPrices() {
        return prices;
    }

    public void setPrices(double prices) {
        this.prices = prices;
    }
}
