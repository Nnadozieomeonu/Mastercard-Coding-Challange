package com.mastercard;

import com.mastercard.codechallenge.enums.CouponCode;
import com.mastercard.codechallenge.enums.ProductName;
import com.mastercard.codechallenge.model.Cart;
import com.mastercard.codechallenge.model.Product;
import com.mastercard.codechallenge.services.CouponCodeService;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.math.BigInteger;

import static com.mastercard.codechallenge.services.CouponCodeService.fib;


/**
 * Unit test for simple App.
 */
public class StartApplicationTest
    extends TestCase
{
    private Product productA = new Product(
            ProductName.A,
            10
    );
    private Product productB = new Product(
            ProductName.B,
            9
    );;
    private Product productX = new Product(
            ProductName.X,
            10
    );
    private Product productY = new Product(
            ProductName.Y,
            5
    );
    private Product productZ = new Product(
            ProductName.Z,
            4
    );
    private Product productP = new Product(
            ProductName.P,
            3
    );
    private Product productQ= new Product(
            ProductName.Q,
            8
    );
    private Product productR= new Product(
            ProductName.R,
            2
    );
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public StartApplicationTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( StartApplicationTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void test_is_half_the_price_is_applied_to_B()
    {

        double expectedValue = 23.50;
        Cart cart = new Cart();
        CouponCodeService couponCodeService = new CouponCodeService(cart);

        //Add one item of Product A
        cart.addToCart(productA);

        //Add two Item of Product B
        cart.addToCart(productB);
        cart.addToCart(productB);

        System.out.println("Total price "+cart.getTotalPrice());

        //apply discount to the Cart
        couponCodeService.applyCouponCode(CouponCode.GET_HALF_ON_BY_BUYING_A);

        assertTrue( cart.getTotalPrice() == expectedValue );
    }



    public void test_is_half_the_price_is_applied_to_B_and_a_isgreater_than_b()
    {

        //10+10+10+(9/2)+(9/2)+2
        double expectedValue = 41.0;
        Cart cart = new Cart();
        CouponCodeService couponCodeService = new CouponCodeService(cart);

        //Add one item of Product A
        cart.addToCart(productA);
        //Add one item of Product A
        cart.addToCart(productA);
        cart.addToCart(productA);

        //Add two Item of Product B
        cart.addToCart(productB);
        cart.addToCart(productB);

        cart.addToCart(productR);

        System.out.println("Total price "+cart.getTotalPrice());

        //apply discount to the Cart
        couponCodeService.applyCouponCode(CouponCode.GET_HALF_ON_BY_BUYING_A);

        assertTrue( cart.getTotalPrice() == expectedValue );
    }


    public void test_is_buy_any_three_and_get_cheapest_one_of_three_free()
    {

        double expectedValue = 17.00;
        Cart cart = new Cart();
        CouponCodeService couponCodeService = new CouponCodeService(cart);

        //Add one item of Product X
        cart.addToCart(productX);

        //Add two Item of Product Y
        cart.addToCart(productY);

        //Add two Item of Product Z
        cart.addToCart(productZ);

        //Add two Item of Product R
        cart.addToCart(productR);

        //apply discount to the Cart
        couponCodeService.applyCouponCode(CouponCode.BUY_ANY_THREE_AND_GET_CHEAPEST_ONE_OF_THE_CHEAPEST_FREE);

        assertTrue( cart.getTotalPrice() == expectedValue );
    }


    public void test_is_buy_any_three_and_get_cheapest_one_of_three_free_when_product_are_less()
    {

        double expectedValue = 17.00;
        Cart cart = new Cart();
        CouponCodeService couponCodeService = new CouponCodeService(cart);

        //Add one item of Product X
        cart.addToCart(productX);

        //Add two Item of Product Y
        cart.addToCart(productY);

        //Add two Item of Product R
        cart.addToCart(productR);

        //apply discount to the Cart
        couponCodeService.applyCouponCode(CouponCode.BUY_ANY_THREE_AND_GET_CHEAPEST_ONE_OF_THE_CHEAPEST_FREE);

        assertTrue( cart.getTotalPrice() == expectedValue );
    }


    public void test_applying_muliple_cupon_codes(){

        double expectedValue = 58.00;
        Cart cart = new Cart();
        CouponCodeService couponCodeService = new CouponCodeService(cart);

        //Add one item of Product X
        cart.addToCart(productX);

        //Add two Item of Product Y
        cart.addToCart(productY);

        //Add two Item of Product Z
        cart.addToCart(productZ);

        //Add two Item of Product R
        cart.addToCart(productR);

        cart.addToCart(productA);
        //Add one item of Product A
        cart.addToCart(productA);
        cart.addToCart(productA);

        //Add two Item of Product B
        cart.addToCart(productB);
        cart.addToCart(productB);

        cart.addToCart(productR);

        //apply discount to the Cart
        couponCodeService.applyCouponCode(CouponCode.BUY_ANY_THREE_AND_GET_CHEAPEST_ONE_OF_THE_CHEAPEST_FREE);
        //apply discount to the Cart
        couponCodeService.applyCouponCode(CouponCode.GET_HALF_ON_BY_BUYING_A);

        assertTrue( cart.getTotalPrice() == expectedValue );

    }


    public void test_fib_series(){
        assertEquals(new BigInteger("3"), fib(4));
        //test the base case of 0
        assertEquals(new BigInteger("0"),fib(0));
        //test the base cae of 1
        assertEquals(new BigInteger("1"),fib(1));
        //test for 100
        assertEquals(new BigInteger("354224848179261915075"),fib(100));
    }




}
