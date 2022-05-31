package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class VerifyEmailMessage extends Utils{
    public void emailMessage(){
        // Assertion to verify for email has sent
        String actual = getTextFromElement(By.xpath("//div[@class=\"result\"]"));
        String expected = "Your message has been sent.";
        Assert.assertEquals(actual,expected,"Email has not sent successfully");
    }
}
