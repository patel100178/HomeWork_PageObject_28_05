package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;


public class DriverManager extends Utils{

    String browserName= "chrome";

    public void openBrowser() {

        if (browserName.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
            driver = new ChromeDriver();//open chromebrowser
        }
        else if(browserName.equalsIgnoreCase("firefox")){
            //WebDriverManager.firefoxdriver().setup();
            System.setProperty("webdriver.gecko.driver", "src/test/java/drivers/geckodriver.exe");
            driver = new FirefoxDriver();// open firefoxbrowser
        }
        else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();// open Edgebrowser
        }
        else {
            System.out.println("Either your browser name is wrong or not provided " +browserName);
        }

        //Duration for waiting
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        // Type URL
        driver.get("https://demo.nopcommerce.com/");

    }
    public void closeBrowser() {
        driver.quit();
    }
}
