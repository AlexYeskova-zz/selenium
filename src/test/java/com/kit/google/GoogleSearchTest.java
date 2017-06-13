package com.kit.google;

import com.kit.core.WebDriverTestBase;
import com.kit.pages.google.GoogleSearchPage;
import com.kit.pages.google.GoogleSearchResultPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class GoogleSearchTest extends WebDriverTestBase{
    public String googleSearch = "https://www.google.com.ua/";
    public String searchText = "Selenium";
    @Test
    public void searchTest() {
        GoogleSearchPage googleSearchPage = PageFactory.initElements(webDriver, GoogleSearchPage.class);
        googleSearchPage.open(googleSearch);
        googleSearchPage.fillAndSubmitSearchData(searchText);
        //GoogleSearchResultPage googleSearchResultPage = new GoogleSearchResultPage(webDriver);
        GoogleSearchResultPage googleSearchResultPage = PageFactory.initElements(webDriver, GoogleSearchResultPage.class);
        assertTrue(googleSearchResultPage.getLinkText().contains(searchText));
    }
}
