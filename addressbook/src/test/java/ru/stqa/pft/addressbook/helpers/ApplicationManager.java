package ru.stqa.pft.addressbook.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public WebDriver wd;

    private ru.stqa.pft.addressbook.helpers.ContactHelper ContactHelper;

    private NavigationHelper navigationHelper;
    private ru.stqa.pft.addressbook.helpers.groupHelper groupHelper;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() {
        if (browser.equals(org.openqa.selenium.remote.BrowserType.FIREFOX)){
            wd= new FirefoxDriver (new FirefoxOptions().setLegacy(true));
        } else if (browser.equals(org.openqa.selenium.remote.BrowserType.CHROME)){
            wd= new ChromeDriver();
        } else if (browser.equals(org.openqa.selenium.remote.BrowserType.IE)) {
            wd= new InternetExplorerDriver();
        }

        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost:8080/addressbook/");
        groupHelper = new groupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        ContactHelper = new ContactHelper(wd);

        ContactHelper.login("admin", "secret");
    }



    public void stop() {
        wd.quit();
    }

    public ru.stqa.pft.addressbook.helpers.groupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
