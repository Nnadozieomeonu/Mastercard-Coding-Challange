package com.mastercard;


import com.mastercard.codechallenge.enums.CouponCode;
import com.mastercard.codechallenge.enums.ProductName;
import com.mastercard.codechallenge.model.*;
import com.mastercard.codechallenge.services.CouponCodeService;

import java.util.Scanner;

public class StartApplication {

    private Cart shoppingCart;
    private Product productA;
    private Product productB;
    private Product productX;
    private Product productY;
    private Product productZ;
    private Product productP;
    private Product productQ;
    private Product productR;
    private double prices[]=new double[8];
    private CouponCodeService couponCodeService;


    /**
     * Main Method
     * @param args
     */
    public static void main(String[] args){
        StartApplication startApplication = new StartApplication();
        startApplication.initializeProgram();
    }


    private StartApplication() {
        shoppingCart = new Cart();
        for(int i=0; i<8;i++){
            this.prices[i] = Math.random() * (100 - 2 + 1) + 2;
        }
        productA = new Product(ProductName.A, this.prices[0]);
        productB = new Product(ProductName.B, this.prices[1]);
        productX = new Product(ProductName.X, this.prices[2]);
        productY = new Product(ProductName.Y, this.prices[3]);
        productZ = new Product(ProductName.Z, this.prices[4]);
        productP = new Product(ProductName.P, this.prices[5]);
        productQ = new Product(ProductName.Q, this.prices[6]);
        productR = new Product(ProductName.R, this.prices[7]);
        couponCodeService = new CouponCodeService(shoppingCart);
    }


    private void processCommand(String inputCommand){
        switch (inputCommand.toLowerCase()){
            case "1":
                shoppingCart.addToCart(productA);
                System.out.println("==================================== Product A has been added to cart successfully==================================== ");
                break;
            case "2":
                shoppingCart.addToCart(productB);
                System.out.println("==================================== Product B has been added to cart successfully==================================== ");
                break;
            case "3":
                shoppingCart.addToCart(productX);
                System.out.println("==================================== Product X has been added to cart successfully==================================== ");
                break;
            case "4":
                shoppingCart.addToCart(productY);
                System.out.println("==================================== Product Y has been added to cart successfully==================================== ");
                break;
            case "5":
                shoppingCart.addToCart(productZ);
                System.out.println("==================================== Product Z has been added to cart successfully==================================== ");
                break;
            case "6":
                shoppingCart.addToCart(productP);
                System.out.println("==================================== Product P has been added to cart successfully==================================== ");
                break;
            case "7":
                shoppingCart.addToCart(productQ);
                System.out.println("==================================== Product Q has been added to cart successfully==================================== ");
                break;
            case "8":
                shoppingCart.addToCart(productR);
                System.out.println("==================================== Product R has been added to cart successfully==================================== ");
                break;
            case "11":
                shoppingCart.removeFromCart(productA);
                System.out.println("==================================== Product A has been removed from  successfully==================================== ");
                break;
            case "22":
                shoppingCart.removeFromCart(productB);
                System.out.println("==================================== Product B has been removed from successfully==================================== ");
                break;
            case "33":
                shoppingCart.removeFromCart(productX);
                System.out.println("==================================== Product X has been removed from successfully==================================== ");
                break;
            case "44":
                shoppingCart.removeFromCart(productY);
                System.out.println("==================================== Product Y has been removed from successfully==================================== ");
                break;
            case "55":
                shoppingCart.removeFromCart(productZ);
                System.out.println("==================================== Product Z has been removed from successfully==================================== ");
                break;
            case "66":
                shoppingCart.removeFromCart(productP);
                System.out.println("==================================== Product P has been removed from successfully==================================== ");
                break;
            case "77":
                shoppingCart.removeFromCart(productQ);
                System.out.println("==================================== Product Q has been removed from successfully==================================== ");
                break;
            case "88":
                shoppingCart.removeFromCart(productR);
                System.out.println("==================================== Product R has been removed from successfully==================================== ");
                break;
            case "9":
                double totalPrice = shoppingCart.getTotalPrice();
                System.out.println("==================================== Total amount is $"+totalPrice+"==================================== ");
                break;
            case "0":
                int cartSize = shoppingCart.getCartSize();
                System.out.println("==================================== You have "+cartSize+" in your cart ==================================== ");
                break;
            case "m":
                printProgramInfoMessage();
                break;
            case "q":
                System.out.println("==================================== Redirecting you to our checckout!! ====================================");
                System.out.println("==================================== Press Enter a coupon code");
                Scanner scanner = new Scanner(System.in);
                inputCommand = scanner.nextLine();
                applyCoupon(inputCommand);
                System.exit(0);
            default:
                System.out.println("==================================== Incorrect selection see below menu options==================================== ");
                System.out.println("==================================== Press m to View menu");
        }
    }


    private void printProgramInfoMessage(){
        System.out.println("==================================== Application initialized successfully ====================================");
        System.out.println("==================================== Welcome to our Shopping Application ====================================");
        System.out.println("==================================== Menu Items ====================================");
        System.out.println("Product A = $"+this.prices[0]);
        System.out.println("Product B = $"+this.prices[1]);
        System.out.println("Product X = $"+this.prices[2]);
        System.out.println("Product Y = $"+this.prices[3]);
        System.out.println("Product Z = $"+this.prices[4]);
        System.out.println("Product P = $"+this.prices[5]);
        System.out.println("Product Q = $"+this.prices[6]);
        System.out.println("Product R = $"+this.prices[7]);
        System.out.println("==================================== Press 1 to add Product A to cart");
        System.out.println("==================================== Press 2 to add Product B to cart");
        System.out.println("==================================== Press 3 to add Product X to cart");
        System.out.println("==================================== Press 4 to add Product Y to cart");
        System.out.println("==================================== Press 5 to add Product Z to cart");
        System.out.println("==================================== Press 6 to add Product P to cart");
        System.out.println("==================================== Press 7 to add Product Q to cart");
        System.out.println("==================================== Press 8 to add Product R to cart");
        System.out.println("==================================== To remove and item from cart press the item number twice ie. 11 to " +
                "remove product 1 from cart ====================================");
        System.out.println("==================================== Press 9 view Total price");

        System.out.println("==================================== Press 0 to view total items in cart");

        System.out.println("==================================== Press m to View menu");

        System.out.println("==================================== Press q to exit to check out");
    }


    private void applyCoupon(String inputCommand){
        CouponCode couponCode = null;
        try{
            couponCode = CouponCode.valueOf(inputCommand.toUpperCase());
            couponCodeService.applyCouponCode(couponCode);
            System.out.println("==================================== Coupon Code Applied Successfully your new price is $"+shoppingCart.getTotalPrice());

        }catch (IllegalArgumentException e){
            System.out.println("==================================== Invalid Coupon code price is $"+shoppingCart.getTotalPrice());

        }
    }


    private void initializeProgram(){
        String inputCommand = "";
        Scanner scanner = new Scanner(System.in);
        printProgramInfoMessage();
        do{
            inputCommand = scanner.nextLine();
            processCommand(inputCommand);
        }
        while(inputCommand != "q");


    }


}
