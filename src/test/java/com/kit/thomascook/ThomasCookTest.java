package com.kit.thomascook;

import com.kit.core.WebDriverTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


import static org.testng.Assert.assertTrue;

/**
 * Created by Alex on 6/30/17.
 */
public class ThomasCookTest extends WebDriverTestBase {

    private String mainPage = "https://www.thomascook.com";

    @Test
    public void searchTest() {

        String howLongStay = "14 Nights";

        webDriver.get(mainPage);

        WebElement selElem = webDriver.findElement(By.id("SearchbarForm-duration"));

        Select selectObject = new Select(selElem);

        selectObject.selectByVisibleText(howLongStay);

        assertTrue(howLongStay.equals(selectObject.getFirstSelectedOption().getText()));

    }

}
