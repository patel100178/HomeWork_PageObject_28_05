package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSuit extends BaseTest{
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage= new RegistrationPage();
    RegisterSuccessfully registerSuccessfully = new RegisterSuccessfully();
    BuildYourOwnProduct buildYourOwnProduct = new BuildYourOwnProduct();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CurrencyVarification currencyVarification = new CurrencyVarification();
    CurrencyPage currencyPage = new CurrencyPage();
    EmailPage emailPage = new EmailPage();
    SelectProductPage selectProductPage = new SelectProductPage();
    VerifyCommunityPollPage verifyCommunityPollPage = new VerifyCommunityPollPage();
    RegisterResultPage registerResultPage = new RegisterResultPage();
    VerifyEmailMessage verifyEmailMessage = new VerifyEmailMessage();
    VerifyAddToCart verifyAddToCart = new VerifyAddToCart();
    AddToCart addToCart = new AddToCart();
    DesktopsPage
            desktopsPage = new DesktopsPage();

@Test
public void userShouldAbleToSeeCommentAddedSuccessfully(){
    homePage.newRelease();
}
@Test
public void userShouldAbleToSeeProductAsSelection(){
    homePage.productSelect("Nike");
}
@Test
public void userShouldAbleToClickOnAlertPopUp(){
    homePage.selectVote();
}
@Test
public void userShouldAbleToSortProduct(){
    homePage.clickOnComputer();
    homePage.clickOnDeskTops();
    desktopsPage.productSortBy();

}
@Test
public void userShouldAbleToHandleWindows(){
    homePage.facebookPage();
}

@Test(priority = 1)
public void userShouldAbleToRegisterSuccessfully(){
    //click on register button on homepage
    homePage.clickRegisterButton();
    //Registration details
    registrationPage.userEntersRegistrationDetails();
    //register successfully message
    registrationPage.userRegisteredSuccessfullyMessage();

}
@Test(priority = 5)
public void userShouldAbleToBuiltOwnProduct(){
    //click on register button on homepage
    homePage.clickRegisterButton();

    //Registration details
    registrationPage.userEntersRegistrationDetails();

    //register successfully message
   registrationPage.userRegisteredSuccessfullyMessage();

    //click on computer
    homePage.clickOnComputer();

    //click on desktops
    homePage.clickOnDeskTops();

    //click on add to cart
    addToCart.clickOnAddToCart();

    //select own computer configuration
    buildYourOwnProduct.userShouldAbleToBuiltOwnComputer();

    //select add to cart
    shoppingCartPage.userShouldAbleToSeeShoppingCartWithProduct();

    //check shopping cart
    verifyAddToCart.addToCartProduct();

    //check correct product verification
    verifyAddToCart.correctProductVerification();


}
@Test(priority = 2)
public void userShouldAbleToSeeProductCurrencyInEuro() {

     //select currency from header bar
    currencyPage.userShouldAbleToSeeCurrency();

    // currency verification massage
    currencyVarification.userShouldAbleToSeeCurrencyInEuro();

}
@Test(priority = 4)
public void userShouldAbleToReferProductToFriend(){

    //click on register button on homepage
    homePage.clickRegisterButton();

    //Registration details
    registrationPage.userEntersRegistrationDetails();

    //register successfully message
    registrationPage.userRegisteredSuccessfullyMessage();

    //Refer product to freind via Email
    selectProductPage.userShouldAbleToReferProduct();

    //email to  freind
    emailPage.userShouldAbleToEmailAFreind();

    //verification message
    verifyEmailMessage.emailMessage();


}
@Test(priority = 3)
public void communityPollVote(){
    //click on vote button on homepage
    homePage.clickVote();

    //verify error message
    verifyCommunityPollPage.verifyForVoteErrorMessage();

    //click on register button on homepage
    homePage.clickRegisterButton();

    //Registration details
    registrationPage.userEntersRegistrationDetails();

    //register successfully message
    registrationPage.userRegisteredSuccessfullyMessage();

    // click on cuntinue button
    registerResultPage.regisrationResult();

    //click on vote button on homepage
    homePage.clickVote();

    //verification message after registration
    verifyCommunityPollPage.verifyForVoteMessageAfterRegistration();

}

}
