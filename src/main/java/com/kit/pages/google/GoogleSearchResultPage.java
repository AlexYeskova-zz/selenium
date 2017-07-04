package com.kit.pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleSearchResultPage extends GoogleBasePage {

    //@FindBy(xpath = ".//*[@id='rso']/div[2]/div/div[1]/div/div/h3/a")
    By linkLocator = By.xpath(".//*[@id='rso']/div[2]/div/div[1]/div/div/h3/a");
    private WebElement link;

    public GoogleSearchResultPage(WebDriver webDriver) {
        super(webDriver);

    }

    public String getLinkText(){
        link  = webDriverUtil.waitForExpectedCondition(
                ExpectedConditions.visibilityOfElementLocated(linkLocator));
        return link.getText();
    }

    public void clickLink(){

        webDriverUtil.jsClick("gb_70", "id");
    }
}
