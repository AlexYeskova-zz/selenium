package com.kit.pages.google;

import com.kit.util.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;

public class GoogleSearchPage extends GoogleBasePage {

    By searchLocator = By.name("q");
    //@FindBy(name = "q")
    private WebElement searchField;


    public GoogleSearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Fills a search text {0} and presses the enter")
    public void fillAndSubmitSearchData(String searchText) {
        webDriverUtil.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(searchLocator));
        searchField = webDriver.findElement(searchLocator);
        searchField.sendKeys(searchText);
        //webDriverUtil.jsClick("gb_70", "id");
       searchField.submit();
    }
}
