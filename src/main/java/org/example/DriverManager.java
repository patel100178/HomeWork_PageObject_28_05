package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;


public class DriverManager extends Utils{
    LoadProp loadProp = new LoadProp();
    DesiredCapabilities caps = new DesiredCapabilities();
    public final String USERNAME = loadProp.getProperty("BSUserName");
    public final String AUTOMATE_KEY = loadProp.getProperty("BSUserPassword");
    public final String BrowseStackURL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    boolean cloud = Boolean.parseBoolean(System.getProperty("cloud"));
    //boolean cloud = true;
    String browserName= "Chrome";
   // String browserName=System.getProperty("browser");

    public void openBrowser() {
            if(cloud){
                System.out.println("Running in cloud");
                //applying conditional loop for web-browser selection
                if (browserName.equalsIgnoreCase("Chrome")){
                    caps.setCapability("os", "Windows");
                    caps.setCapability("os_version", "11");
                    caps.setCapability("browser", "Chrome");
                    caps.setCapability("browser_version", "latest");
                    caps.setCapability("browserstack.local", "false");
                    caps.setCapability("browserstack.selenium_version", "4.0.0");

                } else if (browserName.equalsIgnoreCase("safari")) {
                    caps.setCapability("os", "Windows");
                    caps.setCapability("os_version", "10");
                    caps.setCapability("browser", "Edge");
                    caps.setCapability("browser_version", "101.0");
                    caps.setCapability("browserstack.local", "false");
                    caps.setCapability("browserstack.selenium_version", "4.0.0");

                } else if (browserName.equalsIgnoreCase("firefox")) {
                    caps.setCapability("os", "Windows");
                    caps.setCapability("os_version", "10");
                    caps.setCapability("browser", "Firefox");
                    caps.setCapability("browser_version", "latest");
                    caps.setCapability("browserstack.local", "false");
                    caps.setCapability("browserstack.selenium_version", "4.0.0");

                }else{
                    System.out.println("Your Browser name is wrong");
                }
                try {
                    driver = new RemoteWebDriver(new URL(BrowseStackURL),caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

            }else {
                System.out.println("Running Locally...");
       }

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
