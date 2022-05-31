package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class VerifyAddToCart extends Utils{
    public void addToCartProduct(){
        //Assertion to verify the shopping cart
        String expectedResult = "Shopping cart (1)";
        String actualResult = getTextFromElement(By.partialLinkText("Shopping cart"));
        System.out.println(actualResult);
        Assert.assertEquals(actualResult,expectedResult,"Invalid page");

    }
    public void correctProductVerification(){
       // Assertion to verify the correct product in the cart

        String expectedResult1 = "Build your own computer";
        String actualResult1 = getTextFromElement(By.partialLinkText("Build your own computer"));
        System.out.println(actualResult1);
        Assert.assertEquals(expectedResult1,actualResult1,"Invalid page");
  }

}
