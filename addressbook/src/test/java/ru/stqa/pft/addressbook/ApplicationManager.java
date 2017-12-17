package ru.stqa.pft.addressbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import sun.plugin2.util.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;

    private ContactHelper ContactHelper;

    private NavigationHelper navigationHelper;
    private groupHelper groupHelper;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    protected void init() {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        if (browser == org.openqa.selenium.remote.BrowserType.FIREFOX){
            wd= new FirefoxDriver (new FirefoxOptions().setLegacy(true));
        } else if (browser == org.openqa.selenium.remote.BrowserType.CHROME){
            wd= new ChromeDriver();
        } else if (browser == org.openqa.selenium.remote.BrowserType.IE) {
            wd= new InternetExplorerDriver();
        }

        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost:8080/addressbook/");
        groupHelper = new groupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        ContactHelper = new ContactHelper(wd);

        ContactHelper.login("admin", "secret");
    }



    protected void stop() {
        wd.quit();
    }

    public ru.stqa.pft.addressbook.groupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
