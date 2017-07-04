package com.kit.google;

import com.kit.core.WebDriverTestBase;
import com.kit.pages.google.GoogleSearchPage;
import com.kit.pages.google.GoogleSearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

@Features("GoogleSearch")
@Stories("Web-777")

public class GoogleSearchTest extends WebDriverTestBase{
    public String googleSearch = "https://www.google.com.ua/";
    public String searchText = "Selenium";

    @Title("Google search test - positive scenario")
    @Test
    public void searchTest() {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(webDriver);
        //GoogleSearchPage googleSearchPage = PageFactory.initElements(webDriver, GoogleSearchPage.class);
        googleSearchPage.open(googleSearch);
        googleSearchPage.fillAndSubmitSearchData(searchText);
        GoogleSearchResultPage googleSearchResultPage = new GoogleSearchResultPage(webDriver);
        //GoogleSearchResultPage googleSearchResultPage = PageFactory.initElements(webDriver, GoogleSearchResultPage.class);
        //assertTrue(googleSearchResultPage.getLinkText().contains(searchText));


    }
}
