package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public WebDriver wd;

    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;

    }

    public void init() {
        if (browser.equals(org.openqa.selenium.remote.BrowserType.FIREFOX)) {
            wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        } else if (browser.equals(org.openqa.selenium.remote.BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(org.openqa.selenium.remote.BrowserType.IE)) {
            wd = new InternetExplorerDriver();
        }

        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wd.get("http://localhost:8080/addressbook/group.php");
    }

    public void stop() {
        wd.quit();
    }



}
