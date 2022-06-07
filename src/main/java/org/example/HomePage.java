package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.example.BasePage.driver;

public class HomePage extends Utils{
    private By _clickElement = By.className("ico-register");
    private By _clickElement1 = By.xpath("//div[@class=\"master-wrapper-page\"]/div[2]/ul[1]/li[1]/a[@href=\"/computers\"]");
    private By _clickElement2 = By.xpath("//ul[@class=\"sublist\"]/li[1]/a[@href=\"/desktops\"]");
    private By _clickElement3 = By.xpath("//input[@id=\"pollanswers-2\"]");
    private By _clickElement4 = By.xpath("//button[@id=\"vote-poll-1\"]");
    private By _clickElement5 = By.xpath("//a[@href=\"http://www.facebook.com/nopCommerce\"]");
    private By _clickElement6 = By.xpath("//button[@id=\"vote-poll-1\"]");
    private By _typeText = By.xpath("//input[@id=\"small-searchterms\"]");
    private By _clickElement7 = By.xpath("//button[@class=\"button-1 search-box-button\"]");
    private By _checkProduct = By.xpath("//h2[@class=\"product-title\"]");
    private By _getProduct = By.xpath("//div[contains(@class,'product-grid')]//div[@class='item-box']//h2");
    private By _clickElement8 = By.xpath("//div[3]/a[@href=\"/nopcommerce-new-release\"]");
    private By _typeText1 = By.xpath("//input[@class=\"enter-comment-title\"]");
    private By _typeText2 = By.xpath("//textarea[@class=\"enter-comment-text\"]");
    private By _clickElement9 = By.xpath("//button[@name=\"add-comment\"]");
    private By _findElement = By.xpath("//div[@class=\"result\"]");
    private By _findElement1 = By.xpath("//div[@class=\"comment-title\"]");
    LoadProp loadProp = new LoadProp();


    public static void driverWaitsUntilURLTobe(int time, String url) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlToBe(url));
    }
    public void getProductTitles(){
        List<WebElement> productTitles = driver.findElements(_getProduct);
        for (WebElement e: productTitles){
            System.out.println(e.getText());
        }
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
    public void selectVote(){
      //check Alert PopUp window
      clickElement(_clickElement6);
      String text = loadProp.getProperty("Text");
      String alertMassage = driver.switchTo().alert().getText();
      Assert.assertEquals(alertMassage,text,loadProp.getProperty("TextMessage"));

      //System.out.println(alertMassage);
      driver.switchTo().alert().accept();


    }
    public void facebookPage(){
        //get url for HomePage
        String parent = driver.getWindowHandle();
        System.out.println("parent window - "+parent);
        //select facebook
        driver.findElement(_clickElement5).click();
        Set<String> handles = driver.getWindowHandles();
        // verify the windows
        int count = handles.size();
        System.out.println("Total window "+count);
        for (String child : handles) {
            if (!parent.equalsIgnoreCase(child)) {
            driver.switchTo().window(child);
            System.out.println("child window url " + driver.getCurrentUrl());
            String actualPageTitle = driver.getCurrentUrl();
            try {
            Thread.sleep(3000);
            } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals( actualPageTitle,"https://www.facebook.com/nopCommerce", "Page not found");
        driver.close();
        }
        }
        //switch to parent window
        driver.switchTo().window(parent);
        System.out.println("parent window url is "+driver.getCurrentUrl());
    }
    public void productSelect(String product){
        //type product in search bar
        typeText(_typeText,product);
        //click on search
        clickElement(_clickElement7);
        // check all products
        List<WebElement> productTitles = driver.findElements(_checkProduct);
        for (WebElement e : productTitles) {
            System.out.println(e.getText());
            Assert.assertTrue(e.getText().contains(product));
        }
    }

    public void newRelease(){
        //click on newRelease Details
        clickElement(_clickElement8);
        String actualPageTitle = driver.getCurrentUrl();
        String expectedPageTitle = "https://demo.nopcommerce.com/nopcommerce-new-release";
        Assert.assertEquals(actualPageTitle,expectedPageTitle,"Page title is wrong");
        //type Text
        String title ="payal";
        typeText(_typeText1,title);
        //type comment
        typeText(_typeText2,"my automation");
        //click on new comment
        clickElement(_clickElement9);
        String expectedMessage="News comment is successfully added.";
        String actualMessage = getTextFromElement(_findElement);
        Assert.assertEquals(actualMessage,"News comment is successfully added.","your comment is not added");
        //check comments
        List<WebElement>comments=driver.findElements(_findElement1);
        List<String>listOfComments=new ArrayList<>();
        for (WebElement e : comments) {
            listOfComments.add(e.getText());
        }
         Assert.assertTrue(listOfComments.contains(title));
        //last comment verification
        String lastComment = listOfComments.get(listOfComments.size()-1);
        System.out.println(lastComment);
        Assert.assertEquals(lastComment,title,"Comment is not in order");



    }
}
