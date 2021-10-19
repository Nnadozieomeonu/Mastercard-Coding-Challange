# Solution
# Installation Steps

The solution was build using Java 8 and Maven build. To install maven run the below command on mac

```ssh 
brew install maven
```

To confirm that Maven has been installed on your computer run the below command

```ssh 
mvn –-version 
```

Cone the coding challenge repository or download the zip source code and extract navigate into the root directory

**Building the Program**

The program can simply be executed by entering the below command;

```ssh 
mvn compile 
mvn package
java -cp target/ShoppingApp-1.0-SNAPSHOT.jar com.mastercard.StartApplication
```

The product prices on the StartApplicaiton is dynamic and changes. However the product prices in the test cases are static.

**Sample console Program**

```ssh

==================================== Application initialized successfully ====================================
==================================== Welcome to our Shopping Application ====================================
==================================== Menu Items ====================================
Product A = $72.95545982184605
Product B = $43.330176409167606
Product X = $54.3749305460259
Product Y = $89.54920040421096
Product Z = $51.40895507404702
Product P = $35.34595320040233
Product Q = $40.19843148108768
Product R = $20.28511296946704
==================================== Press 1 to add Product A to cart
==================================== Press 2 to add Product B to cart
==================================== Press 3 to add Product X to cart
==================================== Press 4 to add Product Y to cart
==================================== Press 5 to add Product Z to cart
==================================== Press 6 to add Product P to cart
==================================== Press 7 to add Product Q to cart
==================================== Press 8 to add Product R to cart
==================================== To remove and item from cart press the item number twice ie. 11 to remove product 1 from cart ====================================
==================================== Press 9 view Total price
==================================== Press 0 to view total items in cart
==================================== Press m to View menu
==================================== Press q to exit to check out
1
==================================== Product A has been added to cart successfully==================================== 
2
==================================== Product B has been added to cart successfully==================================== 
3
==================================== Product X has been added to cart successfully==================================== 
4
==================================== Product Y has been added to cart successfully==================================== 
5
==================================== Product Z has been added to cart successfully==================================== 
m
==================================== Application initialized successfully ====================================
==================================== Welcome to our Shopping Application ====================================
==================================== Menu Items ====================================
Product A = $72.95545982184605
Product B = $43.330176409167606
Product X = $54.3749305460259
Product Y = $89.54920040421096
Product Z = $51.40895507404702
Product P = $35.34595320040233
Product Q = $40.19843148108768
Product R = $20.28511296946704
==================================== Press 1 to add Product A to cart
==================================== Press 2 to add Product B to cart
==================================== Press 3 to add Product X to cart
==================================== Press 4 to add Product Y to cart
==================================== Press 5 to add Product Z to cart
==================================== Press 6 to add Product P to cart
==================================== Press 7 to add Product Q to cart
==================================== Press 8 to add Product R to cart
==================================== To remove and item from cart press the item number twice ie. 11 to remove product 1 from cart ====================================
==================================== Press 9 view Total price
==================================== Press 0 to view total items in cart
==================================== Press m to View menu
==================================== Press q to exit to check out
9
==================================== Total amount is $311.6187438964844==================================== 
q
==================================== Redirecting you to our checckout!! ====================================

==================================== Press Enter a coupon code
==================================== Invalid Coupon code price is $311.6187438964844

```


When the console application requests for a coupon code you can copy one of the discount codes below to test

GET_HALF_ON_BY_BUYING_A

BUY_ANY_THREE_AND_GET_CHEAPEST_ONE_OF_THE_CHEAPEST_FREE



# Code Challenge

## Problem Statement
You have a shopping Cart that has some items. Write a method that returns the total price of items in the cart.
The merchant may offer various types of promotions at any point in time. The customers may buy any number of items in any combination regardless of whether the items are part of a promotion or not. 

We want your price calculation to take into account the promotions below that are active at the same time:

- Buy A and get B for half price. Half price is applied to B items based on the number of A items.
- Buy any 3 items from a set of products {X, Y, Z, P & Q} and get the cheapest one for free.

### Requirement
Provide a way to calculate the final price. The products and prices should be configurable.

### Notes
Please create such promotions in your code with any item prices of your choice and calculate the total cart price based on those.
You can safely assume that the merchant will not set up the same item to be part of different promotions at the same time.
You do not need to provide any input interface e.g cli or file-based.

## Example 1

Products:

- A = $10.00
- B = $9.00

Cart has A (1 item) and B (2 item)

Output:
Total = 23.50

Explanation:

Half price is only applied to 1 B because there is only 1 A, the other B is full price.

Price = 10.00 + (9.00 / 2) + 9.00 = 23.50

## Example 2

Products:

- X = $10.00
- Y = $5.00
- Z = $4.00
- P = $3.00
- Q = $8.00
- R = $2.00

Cart has X (1 item), Y (1 item), Z (1 item) and R (1 item)

Output:
Total = 17.00

Explanation:

We have 4 items in the cart. R is not part of promotion.
Cheapest based on promotion products is Z so it will be free.

Price = 10.00 + 5.00 + 0.00 + 2.00 = 17.00

## Rules
1. You have 3 hours to complete the exercise. Please time yourself and try to limit coding to the specified time
2. We are really interested in your object oriented or functional design skills so please write your best code possible
3. Your solution should have good quality as any mature project including good directory structure, build (make, gradle, mvn etc) and a README.md
4. Please do not use any external libraries, except for testing if required
5. Please write extensive unit tests. The tests **should** cover different combinations and quantity of products that are part of the promotions and not. Covering only the simple examples above is not sufficient.
6. We would like to see the commits
7. Please write your solution in Java (8 or above)
8. Please do not make this problem statement and your solution public
