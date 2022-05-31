package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

import static org.example.BasePage.driver;

public class CurrencyVarification extends Utils{
    public void userShouldAbleToSeeCurrencyInEuro(){
        //currency check
        String price = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[1]/div/div[2]/div[3]/div[1]/span")).getText();
        System.out.println(price);
        String p = price.substring(0, 1);
        System.out.println(p);
        Assert.assertEquals(p, "€");

    }
}
