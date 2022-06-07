package org.example;

import org.openqa.selenium.By;

import static org.example.Utils.*;

public class BuildYourOwnProduct extends Utils{
    //private By _cartButton = (By.xpath("//button[@id=\"add-to-cart-button-1\"]"));
    private By _processorDropdown = By.xpath("//select[@name=\"product_attribute_1\"]");
    String value3 = "1";
    private By _ram = By.xpath("//select[@name=\"product_attribute_2\"]");
    String value4 = "3";
    private By _hddRadioButton = By.xpath("//input[@name=\"product_attribute_3\"and@id=\"product_attribute_3_6\"]");
    private By _osButton = By.xpath("//input[@id=\"product_attribute_4_9\"and@name =\"product_attribute_4\"]");
    private By _software1 = By.xpath("//*[@id=\"product_attribute_5_10\"]");
    private By _software2 = By.xpath("//*[@id=\"product_attribute_5_11\"]");
    private By _software3 = By.xpath("//*[@id=\"product_attribute_5_12\"]");
    private By _addToCart = By.xpath("//button[normalize-space()='Add to cart']");

    public void userShouldAbleToBuiltOwnComputer() {

        //click on Add to cart button
        //clickElement(_cartButton);

        // select from processor dropdown
        selectDropdownValue((_processorDropdown), value3);

        // select RAM
        selectDropdownValue((_ram), value4);

        // click on HDD radioButton
        clickElement(_hddRadioButton);

        //click on OS radiobutton
        clickElement(_osButton);

        // select  software checkbox all
        clickElement(_software1);
        clickElement(_software2);
        clickElement(_software3);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        driverClickable(10,_addToCart);
        // click on  Add to cart button
        //clickElement(_addToCart);
    }
}


