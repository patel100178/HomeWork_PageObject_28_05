package org.example;

import org.openqa.selenium.By;
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
    LoadProp loadProp = new LoadProp();


    public void verifyUserShouldBeOnRegistrationPage(){
        driverWaitsUntilURLTobe( 20, loadProp.getProperty("url"));
    }
    public void userEntersRegistrationDetails(){

        //select male and female
        //driver.findElement(By.id("gender-female")).click();
        clickElement(_genderFemale);

        // enter firstname
        typeText((_firstName), loadProp.getProperty("firstname"));

        // enter lastname
        typeText((_lastName),loadProp.getProperty("lastname"));

        //Select date of birth day
        //Select birthday = new Select(driver.findElement(By.name("DateOfBirthDay")));
        //birthday.selectByValue("5");
        selectDropdownValue((_birthDay),loadProp.getProperty("DateOfBirth"));

        //select month
        //Select birthmonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        //birthmonth.selectByValue("5");
        selectDropdownValue((_birthMonth),loadProp.getProperty("DateOfMonth"));

        //select year
        //Select birthyear = new Select(driver.findElement(By.name("DateOfBirthYear")));
        //birthyear.selectByVisibleText("2020");
        selectDropdownValue((_birthYear), loadProp.getProperty("DateOfYear"));

        // enter Email
        //String email = name + date + _email;
        //System.out.println(email);
        //typeText((_email),email1);
        String email = loadProp.getProperty("Email1") + randomDate() + loadProp.getProperty("Email2");
        System.out.println(email);
        typeText(By.id("Email"), email);

        // enter password
        typeText((_password),loadProp.getProperty("password"));

        // enter confirm password
        typeText((_confirmPassword),loadProp.getProperty("confirm-password"));

        // click register button
        clickElement(_registerButton);
    }
    // assertion to verify
    public void userRegisteredSuccessfullyMessage(){
        String actual = getTextFromElement(By.xpath("//div[@class = \"result\"]"));
        String expected = loadProp.getProperty("ExpectedRegisterSuccessfulMassage");
        Assert.assertEquals(actual,expected,"Registration is not successfull");
    }


}
