package org.example;

import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Utils {
    DriverManager driverManager = new DriverManager();
 @BeforeMethod
    public void Setup(){

     driverManager.openBrowser();
    }
 @AfterMethod
 public void tearDown(ITestResult result){
     if (!result.isSuccess()) {
         takeSnapShot(result.getName());
     }

     driverManager.closeBrowser();
 }

}
