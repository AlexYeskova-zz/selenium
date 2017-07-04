package com.kit.core;

import java.util.concurrent.TimeUnit;

import com.kit.util.PropertiesCache;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.apache.commons.lang3.EnumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


@Listeners({com.kit.core.TestListener.class})

public class WebDriverTestBase {
    protected WebDriver webDriver;
    //how to pass System variable to Selenium Framework
    //mvn -Dbrowser=CHROME or -Dbrowser=FF clean test - to run tests on diff browsers
    long implicitWait = Long.parseLong(PropertiesCache.getProperty("wait.implicit"));
    long pageLoadTimeout = Long.parseLong(PropertiesCache.getProperty("wait.pageLoad"));
    long scriptTimeout = Long.parseLong(PropertiesCache.getProperty("wait.scriptTimeout"));

    private String browser = System.getProperty("browser");

    @BeforeClass
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver",
        // "C:\\KIT\\ClassWorkSelenium\\Selenium\\src\\main\\resources\\chromedriver.exe");
        setBrowser();
        setWebDriverSettings();

    }

    private void setWebDriverSettings() {
        //webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(scriptTimeout, TimeUnit.SECONDS);
    }

    public void setBrowser() {

        Browser runBrowser = EnumUtils.isValidEnum(Browser.class, browser) ? Browser.valueOf(browser.toUpperCase()) : Browser.CHROME;
        //null, lowerCase, if not chrome RUN CHROME are covered
        switch (runBrowser) {
            case CHROME:
                ChromeDriverManager.getInstance().setup();
                webDriver = new ChromeDriver();
                break;
            case FF:
                FirefoxDriverManager.getInstance().setup();
                webDriver = new FirefoxDriver();
                break;
        }
    }

    @AfterClass
    public void tearDown() {
        //Closes a browser
//        webDriver.close();
        //Closes a browser's tab
        webDriver.quit();
//    }
    }
}
