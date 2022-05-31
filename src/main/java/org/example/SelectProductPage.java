package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

import static org.example.Utils.clickElement;
import static org.example.Utils.typeText;

public class SelectProductPage extends Utils {
    private By _continueButton = By.xpath("//div[2]/a[@class=\"button-1 register-continue-button\"]");
    private By _computer1 = By.xpath("//div[@class=\"master-wrapper-page\"]/div[2]/ul[1]/li[1]/a[@href=\"/computers\"]");
    private By _desktops1 = By.xpath("//ul[@class=\"sublist\"]/li[1]/a[@href=\"/desktops\"]");
    private By _product = By.xpath("//h2/a[@href=\"/lenovo-ideacentre-600-all-in-one-pc\"]");
    private By _emailAFriend = By.xpath("//button[@class=\"button-2 email-a-friend-button\"]");
    public void userShouldAbleToReferProduct(){

        //click on CONTINUE button
        clickElement((_continueButton));

        //click on computer
        clickElement(_computer1);

        //click on Desktops
        clickElement(_desktops1);

        //click Lenovo IdeaCentre 600 All-in-one PC
        clickElement(_product);

        //click on Email a Friend
        clickElement(_emailAFriend);


    }
}
