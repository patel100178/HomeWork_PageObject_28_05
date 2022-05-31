package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class RegistrationPage extends Utils{
    private By _genderFemale = By.id("gender-female");
    private By _firstName = By.xpath("//*[@name='FirstName']");
    String firstName = "Payal";
    private By _lastName = By.id("LastName");
    String lastName = "Patel";
    private By _Password = By.id("Password");
    private By _birthDay = By.name("DateOfBirthDay");
    String value = "5";
    private By _birthMonth = By.name("DateOfBirthMonth");
    String value1 = "5";
    private By _birthYear = By.name("DateOfBirthYear");
    String value2 = "2020";
//    private By _email = By.id("Email");
//    String name = "Payal";
//    String date = randomDate();
//   String email1 = "payal_jp22@yahoo.com";
    private By _password = By.id("Password");
    String password = "12345@";
    private By _confirmPassword = By.id("ConfirmPassword");
    String confirmPassword = "12345@";
    private By _registerButton = By.name("register-button");


    public void verifyUserShouldBeOnRegistrationPage(){
        driverWaitsUntilURLTobe( 20, "https://demo.nopcommerce.com/registerresult/1?returnUrl=/");
    }
    public void userEntersRegistrationDetails(){

        //select male and female
        //driver.findElement(By.id("gender-female")).click();
        clickElement(_genderFemale);

        // enter firstname
        typeText((_firstName), firstName);

        // enter lastname
        typeText((_lastName),lastName);

        //Select date of birth day
        //Select birthday = new Select(driver.findElement(By.name("DateOfBirthDay")));
        //birthday.selectByValue("5");
        selectDropdownValue((_birthDay),value);

        //select month
        //Select birthmonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        //birthmonth.selectByValue("5");
        selectDropdownValue((_birthMonth),value1);

        //select year
        //Select birthyear = new Select(driver.findElement(By.name("DateOfBirthYear")));
        //birthyear.selectByVisibleText("2020");
        selectDropdownValue((_birthYear), value2);

        // enter Email
        //String email = name + date + _email;
        //System.out.println(email);
        //typeText((_email),email1);
        String email = "Payal" + randomDate() + "payal_jp22@yahoo.com";
        System.out.println(email);
        typeText(By.id("Email"), email);

        // enter password
        typeText((_password),password);

        // enter confirm password
        typeText((_confirmPassword),confirmPassword);

        // click register button
        clickElement(_registerButton);
    }
    // assertion to verify
    public void userRegisteredSuccessfullyMessage(){
        String actual = getTextFromElement(By.xpath("//div[@class = \"result\"]"));
        String expected = "Your registration completed";
        Assert.assertEquals(actual,expected,"Registration is not successfull");
    }


}
