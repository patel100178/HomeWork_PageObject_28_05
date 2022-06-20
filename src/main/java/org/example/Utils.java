package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

 //you forgot to extndes Utils with BasepAge

public class Utils  extends BasePage{
    public static void driverWaitsUntilURLTobe(int time, String url) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public static void typeText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public static void clickElement(By by) {
        driver.findElement(by).click();
    }

    public static String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public static void selectDropdownText(By by, String textValue) {
        Select dropdown1 = new Select(driver.findElement(by));
        dropdown1.selectByVisibleText(textValue);
    }

    public static void selectDropdownIndex(By by, int index) {
        Select dropdown2 = new Select(driver.findElement(by));
        dropdown2.selectByIndex(index);
    }

    public static void selectDropdownValue(By by, String value) {
        Select dropdown3 = new Select(driver.findElement(by));
        dropdown3.selectByValue(value);
    }

    public static String randomDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyymmss");
        return formatter.format(date);
    }

    public static void driverClickable(int time, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public static void driverSelected(int time, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void driverTitleContains(int time, String title) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.titleContains(title));
    }

    public static void driverInvisibility(int time, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void driverAlertIsPresent(int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.alertIsPresent());
    }



    public static void driverTextToBe(int time, By by, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.textToBe(by, value));
    }

    public static void driverInvisibilityOf(int time, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void driverAttributeToBe(int time, By by, String attribute, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.attributeToBe(by, attribute, value));
    }

    public static void driverAttributeToBeNotEmpty(int time, WebElement element, String attribute) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));
    }

    public static void driverElementToBeSelected(int time, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeSelected(by));
    }

    public static void takeSnapShot(String a) {
        // Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) driver);

        //Call getScreenshot as method to create image file
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

        //Copy file at destination

        try {
            FileUtils.copyFile(srcFile, new File("Screenshots\\" + a + randomDate() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        public static void driverElementToBeClickable(int time, By by) {
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(time));
            wait1.until(ExpectedConditions.elementToBeClickable(by)).click();
        }
        public static void verifyCategory_url(String url){
        driver.getCurrentUrl().equals(url);
        }



    }




