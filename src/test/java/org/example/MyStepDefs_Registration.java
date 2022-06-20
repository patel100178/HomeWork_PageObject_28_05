package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepDefs_Registration {
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage= new RegistrationPage();
    RegisterSuccessfully registerSuccessfully = new RegisterSuccessfully();



    @Given("I am on registration page")
    public void i_am_on_registration_page() {
        // Write code here that turns the phrase above into concrete actions
      homePage.clickRegisterButton();
    }

    @When("I enter required registration details")
    public void i_enter_required_registration_details() {
        // Write code here that turns the phrase above into concrete actions
     registrationPage.userEntersRegistrationDetails();
    }

    @When("I click on register submit button")
    public void i_click_on_register_submit_button() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("I should able to registered successfully")
    public void i_should_able_to_registered_successfully() {
        // Write code here that turns the phrase above into concrete actions

    }


}
