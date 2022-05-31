package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.BasePage.driver;

public class HomePage extends Utils{
    private By _clickElement = By.className("ico-register");
    private By _clickElement1 = By.xpath("//div[@class=\"master-wrapper-page\"]/div[2]/ul[1]/li[1]/a[@href=\"/computers\"]");
    private By _clickElement2 = By.xpath("//ul[@class=\"sublist\"]/li[1]/a[@href=\"/desktops\"]");
    private By _clickElement3 = By.xpath("//input[@id=\"pollanswers-2\"]");
    private By _clickElement4 = By.xpath("//button[@id=\"vote-poll-1\"]");


    public static void driverWaitsUntilURLTobe(int time, String url) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlToBe(url));
    }
    public void clickRegisterButton(){

        clickElement(_clickElement);
    }
    public void clickOnComputer(){
        //click on computer
        clickElement(_clickElement1);
    }
    public void clickOnDeskTops() {
        //click on Desktops
        clickElement(_clickElement2);
    }
    public void clickVote(){

        //click on vote radio button
        clickElement(_clickElement3);

        //click on vote button
        clickElement(_clickElement4);
    }
}
