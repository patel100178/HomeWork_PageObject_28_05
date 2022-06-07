package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DesktopsPage extends Utils {
    private By _findElement3 = By.xpath("\"//h2[@class='product-title']/a\")");
    public void productSortBy() {
        //select sort by Z to A
        selectDropdownValue(By.xpath("//select[@id=\"products-orderby\"]"), "6");
        List<WebElement> productTitles = driver.findElements(By.xpath("//h2[@class=\"product-title\"]"));
        List<String> descendingProductTitles = new ArrayList<String>();
        for (WebElement e : productTitles) {
            descendingProductTitles.add(e.getText().substring(0, 1));
        }
        Collections.sort(descendingProductTitles, Collections.reverseOrder());
        System.out.println(descendingProductTitles);

        List<String> actualProductTitles = new ArrayList<String>();
        for (WebElement e : productTitles) {
            actualProductTitles.add(e.getText().substring(0, 1));
        }
        System.out.println(actualProductTitles);
        Assert.assertTrue(actualProductTitles.equals(descendingProductTitles));

//        //List of webElements
//        ArrayList<String> expectedObtainedList = new ArrayList<>();
//        List<WebElement> elementList = driver.findElements(_findElement3);
//        //List of actual Products
//        List<String> productName = new ArrayList<String>();
//        for (WebElement e : elementList) {
//            expectedObtainedList.add(e.getText());
//        }
//
//        ArrayList<String> descendingsortedList = new ArrayList<>();
//        for (String s : expectedObtainedList) {
//            descendingsortedList.add(s);
//        }
//        Collections.sort(descendingsortedList);
//        System.out.println("sorted---> "+descendingsortedList);
//        Collections.reverse(descendingsortedList);
//        System.out.println("Descending---> "+descendingsortedList);
//
//        Assert.assertTrue(descendingsortedList.equals(expectedObtainedList), "It is not in descending");
//
    }

    }
