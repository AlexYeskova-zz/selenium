package com.kit.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertTrue;

/**
 * Created by Alex on 6/2/17.
 */
public class GoogleSearchOldTest {

    private String googleSearch;
    private WebDriver webDriver;


    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/Alex/IdeaProjects/selenium/src/main/resources/chromedriver");
        webDriver = new ChromeDriver();
        googleSearch = "https://www.google.com.ua";
        webDriver.get(googleSearch);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void searchTest(){
        String searchText = "Selenium";
        By searchLocator = By.id("lst-ib");
        WebElement searchField = webDriver.findElement(searchLocator);
        searchField.sendKeys(searchText);
        searchField.submit();
        By linkLocator = By.xpath(".//*[@id='rso']/div[2]/div/div[1]/div/div/h3/a");
        WebElement link = webDriver.findElement(linkLocator);
        assertTrue(link.getText().contains(searchText));
    }



}
