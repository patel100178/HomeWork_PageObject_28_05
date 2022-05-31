package org.example;

import org.openqa.selenium.By;

import static org.example.Utils.clickElement;
import static org.example.Utils.typeText;

public class EmailPage extends Utils{
    private By _friendEmail = By.xpath("//input[@name=\"FriendEmail\"]");
    String friend = "payal_jp22+01@gmail.com";
    private By _sendMsg = By.id("PersonalMessage");
    String msg = "This Product is very nice";
    private By _sendEmail = By.xpath("//button[@name=\"send-email\"]");

    public void userShouldAbleToEmailAFreind(){

        //Friend's Email
        typeText((_friendEmail), friend);

        //Type a massage
        typeText((_sendMsg),msg);

        //Click on Send Email
        clickElement(_sendEmail);
    }
}

