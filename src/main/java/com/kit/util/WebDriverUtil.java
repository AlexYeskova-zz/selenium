package com.kit.util;

import java.io.File;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Attachment;
import static com.google.common.io.Files.toByteArray;

/**
 * Created by Alex on 6/16/17.
 */
public class WebDriverUtil {


    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    long timeOut = Long.parseLong(PropertiesCache.getProperty("wait.timeOut"));
    public JavascriptExecutor executor;

    public WebDriverUtil(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, timeOut);
    }


    public WebElement waitForExpectedCondition(ExpectedCondition expectedCondition) {
        return  (WebElement)webDriverWait.until(expectedCondition);
    }

    public void jsClick(String locator, String type) {
        executor = (JavascriptExecutor) webDriver;
        switch(type) {
            case "id":
                executor.executeScript("document.getElementById(\"" + locator + "\").click()");
                break;
            case "name":
                executor.executeScript("document.getElementsByName(\"" + locator + "\").click()");
                break;
        }
    }

    @Attachment(value = "{0}")
    public byte[] saveScreenshot(String attachName) {
        try {
            File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
            return toByteArray(scrFile);
        } catch (Exception e) {
            System.out.println("Is not saved screenshot" + e);
        }
        return new byte[0];
}}
