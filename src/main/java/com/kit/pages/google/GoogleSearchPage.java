package com.kit.pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {
    public WebDriver webDriver;

   // By searchLocator = By.name("q");
    @FindBy(name = "q")
    private WebElement searchField;


    public GoogleSearchPage(WebDriver webDriver) {
        this.webDriver = webDriver;


    }

    public void open(String url) {
        webDriver.get(url);
    }

    public void fillAndSubmitSearchData(String searchText) {
       // searchField = webDriver.findElement(searchLocator);
        searchField.sendKeys(searchText);
        searchField.submit();
    }
}
