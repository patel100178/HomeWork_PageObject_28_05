package org.example;

import org.openqa.selenium.By;

public class RegisterResultPage extends Utils {
    private By _continueButton = By.xpath("//div[2]/a[@class=\"button-1 register-continue-button\"]");
    public void regisrationResult(){
        //click on CONTINUE button
        clickElement(_continueButton);

    }
}
