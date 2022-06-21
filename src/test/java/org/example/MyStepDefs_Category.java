package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepDefs_Category {
    HomePage homePage = new HomePage();
    @Given("I am on Homepage")
    public void i_am_on_homepage() {
        // Write code here that turns the phrase above into concrete actions
        homePage.VerifyCurrentUrl("Url");
    }
    @When("I click on {string} lin k from top menu header")
    public void i_click_on_lin_k_from_top_menu_header(String category_name) {
        // Write code here that turns the phrase above into concrete actions
        homePage.clickOnCategoryList(category_name);
    }
    @Then("I should able to successfully navigate to related {string} category page successfully")
    public void i_should_able_to_successfully_navigate_to_related_category_page_successfully(String category_url) {
        // Write code here that turns the phrase above into concrete actions
        Utils.verifyCategory_url("category_url");

    }

}
