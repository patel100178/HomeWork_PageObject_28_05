package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static org.example.BasePage.driver;
import static org.example.Utils.clickElement;

public class CurrencyPage extends Utils {
    private By _currency = By.id("customerCurrency");
    private By _currencyEuro = By.id("customerCurrency");
    String value4 = "Euro";
    public void userShouldAbleToSeeCurrency(){
        //click Currency bar
        clickElement(_currency);

        //select currency
        Select currency = new Select(driver.findElement(By.id("customerCurrency")));
        currency.selectByVisibleText("Euro");
        selectDropdownText((_currencyEuro),"Euro");
    }

}
