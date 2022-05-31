package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class VerifyCommunityPollPage extends Utils {

    public void verifyForVoteErrorMessage(){
        //verification for vote
        String expectedResult = "Only registered users can vote.";
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            String actualResult = getTextFromElement(By.xpath("//div[@class='poll-vote-error']"));
            Assert.assertEquals(actualResult, expectedResult, "You are not registered user");
        }
    public void verifyForVoteMessageAfterRegistration(){
            //verification for vote
            String expectedMessage = "vote(s)";
            String actualMessage = getTextFromElement(By.xpath("//span[@class=\"poll-total-votes\"]"));
            Assert.assertTrue(actualMessage.contains(expectedMessage));

        }
    }

