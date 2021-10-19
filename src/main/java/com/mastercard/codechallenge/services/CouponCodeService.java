package com.mastercard.codechallenge.services;

import com.mastercard.codechallenge.customdata.CustomDataStructure;
import com.mastercard.codechallenge.model.Cart;
import com.mastercard.codechallenge.enums.CouponCode;
import com.mastercard.codechallenge.model.Product;
import com.mastercard.codechallenge.enums.ProductName;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

public class CouponCodeService {

    private Cart shoppingCart;

    /**
     *
     * @param shoppingCart
     */
    public CouponCodeService(Cart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    /**
     *
     * @param couponCode
     * @return
     */
    public double applyCouponCode(CouponCode couponCode)
    {
        double totalPrice;
        if(couponCode == CouponCode.GET_HALF_ON_BY_BUYING_A){
            totalPrice = proccessBuyAgetBForHalf(shoppingCart.getProducts());
        }
        else if(couponCode == CouponCode.BUY_ANY_THREE_AND_GET_CHEAPEST_ONE_OF_THE_CHEAPEST_FREE){
            totalPrice =proccessFromXYZPQAndGetCheapestFree(shoppingCart.getProducts());
        }
        else{
            totalPrice = shoppingCart.getTotalPrice();
        }
        return totalPrice;
    }

    /**
     *
     * @param productList
     * @return
     */
    private double proccessBuyAgetBForHalf(List<Product> productList){

        int productACount = 0;
        int productBCount = 0;
        double priceOfB = 0;
        //count the number of product A and B in cart
        for(Product product: productList){
            if(product.getProductName() == ProductName.A){
                productACount+=1;
            }
            else if(product.getProductName() == ProductName.B){
                productBCount+=1;
                priceOfB+=product.getPrice();
            }
        }
        //If none of product A and B was added return current price
        if((productACount == 0 && productBCount == 0) || (productACount == 0) || (productBCount == 0)){
            return  shoppingCart.getTotalPrice();
        }
        //If the number of product a is same with product B apply coupon
        if(productACount == productBCount || productACount > productBCount){
                priceOfB = priceOfB/2;
                shoppingCart.applyDiscountCoupon(priceOfB);
        }
        //If the number of product A is more than B then the user gets B for free
        else {
            //get a single product price
            double price = priceOfB/productBCount;
            double discount = 0;
            for(int i =0; i < productACount; i++){
                discount+= (price/2);
            }
            shoppingCart.applyDiscountCoupon(discount);
        }
        return  shoppingCart.getTotalPrice();
    }

    /**
     *
     * @param productList
     * @return
     */
    private CustomDataStructure isValidForSingleProductOff(List<Product> productList){
        CustomDataStructure customDataStructure = new CustomDataStructure();
        double cheapestPrice = 0;
        int count = 0;
        for(Product product: productList){
            if(product.getProductName() == ProductName.P
                    ||product.getProductName() == ProductName.Q ||
                    product.getProductName() == ProductName.X || product.getProductName() == ProductName.Y
                    || product.getProductName() == ProductName.Z
            ){
                if(count ==0){
                    cheapestPrice = product.getPrice();
                }
                if(count !=0){
                    if(product.getPrice() < cheapestPrice){
                        cheapestPrice = product.getPrice();
                    }
                }
                customDataStructure.setProductNameDoubleMap(product.getProductName(),product.getPrice());
                ++count;
            }
        }

        if(customDataStructure.getProductNameDoubleMap().size() < 3){
            customDataStructure.setaBoolean(false);
        }else{
            customDataStructure.setaBoolean(true);
            customDataStructure.setPrices(cheapestPrice);
        }
        return customDataStructure;
    }


    /**
     *
     * @param productList
     * @return
     */
    private double proccessFromXYZPQAndGetCheapestFree(List<Product> productList){
        double cheapestPrice = 0;
        int count = 0;
        CustomDataStructure customDataStructure = isValidForSingleProductOff(productList);
        if(customDataStructure.isaBoolean()){
            shoppingCart.applyDiscountCoupon(customDataStructure.getPrices());
        }

        return  shoppingCart.getTotalPrice();
    }

    //fib seri

    //fib n = fib n-1 + fi n-2
    //fib 0 =0
    //fib 1=1
    //fib 2= fib 1

    //assuming N is positive
    private  static HashMap<Integer, BigInteger> values =  new HashMap<>();
    public static BigInteger fib(Integer n){

        //base case if n =1
        if(n.equals(0)){
            return new BigInteger("0");
        }

        //Second base case if n is 1
        if(n.equals(1)){
            return new BigInteger("1");
        }

        if(values.containsKey(n)){
            return values.get(n);
        }

        BigInteger tempVariable = fib(n-1).add(fib(n-2));
        values.put(n,tempVariable);

        return tempVariable;

    }









}
