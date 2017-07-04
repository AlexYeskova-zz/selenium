package com.kit.pages.google;

import com.kit.util.WebDriverUtil;
import org.openqa.selenium.WebDriver;

/**
 * Created by Alex on 6/16/17.
 */
public class GoogleBasePage {

    protected WebDriver webDriver;

    protected WebDriverUtil webDriverUtil;

    public GoogleBasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverUtil = new WebDriverUtil(webDriver);

    }

    public void open(String url) {
        webDriver.get(url);
    }

}
