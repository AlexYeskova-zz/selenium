package com.kit.core;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class WebDriverTestBase {
    protected WebDriver webDriver;

    @BeforeSuite
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver",
               // "C:\\KIT\\ClassWorkSelenium\\Selenium\\src\\main\\resources\\chromedriver.exe");
        ChromeDriverManager.getInstance().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown() {
        //Closes a browser
        webDriver.close();
        //Closes a browser's tab
//        webDriver.quit();
    }
}
