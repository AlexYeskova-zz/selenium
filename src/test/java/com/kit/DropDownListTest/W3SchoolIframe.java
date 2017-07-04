package com.kit.DropDownListTest;

import com.kit.core.WebDriverTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by Alex on 6/30/17.
 */
public class W3SchoolIframe extends WebDriverTestBase {

    String mainPage = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select";

    @Test
    public void searchTest() {

        String car = "Opel";

        webDriver.get(mainPage);

        webDriver.switchTo().frame("iframeResult");

        WebElement selElem = webDriver.findElement(By.cssSelector("html>body>select"));

        Select selectObject = new Select(selElem);
        WebElement From = webDriver.findElement(By.xpath(".//*[@id='sample']/div[1]/span[1]/div/div[1]"));
        WebElement To = webDriver.findElement(By.xpath(".//*[@id='myDiagramDiv']/canvas"));
        Actions builder = new Actions(webDriver);
        builder.clickAndHold(From).moveToElement(To).release(To).build().perform();
        selectObject.selectByVisibleText(car);

        assertTrue(car.equals(selectObject.getFirstSelectedOption().getText()));

    }

}
