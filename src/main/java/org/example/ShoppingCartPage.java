package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static org.example.Utils.*;

public class ShoppingCartPage extends Utils {
    private By _shoppingCart = By.xpath("//span[@class=\"cart-label\"]");

    public void userShouldAbleToSeeShoppingCartWithProduct() {
        // click on shopping cart button
        clickElement(_shoppingCart);

    }

    }

