package ru.stqa.pft.addressbook.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private final Properties properties;
    public WebDriver wd;

    public ContactHelper ContactHelper;
    public NavigationHelper NavigationHelper;
    public GroupsHelper GroupsHelper;
    public String browser;
    private DbHelper dbHelper;


    public ApplicationManager(String property, String browser) {
        this.browser = browser;
        properties = new Properties();
    }


    public void init() throws IOException {
            String target = System.getProperty("target", "local");
            properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        if (browser.equals(org.openqa.selenium.remote.BrowserType.FIREFOX)){
            wd= new FirefoxDriver (new FirefoxOptions().setLegacy(true));
        } else if (browser.equals(org.openqa.selenium.remote.BrowserType.CHROME)){
            wd= new ChromeDriver();
        } else if (browser.equals(org.openqa.selenium.remote.BrowserType.IE)) {
            wd= new InternetExplorerDriver();
        }

        dbHelper = new DbHelper();

        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wd.get(properties.getProperty("web.baseUrl"));
        GroupsHelper = new GroupsHelper(wd);
        NavigationHelper = new NavigationHelper(wd);
        ContactHelper = new ContactHelper(wd);
        ContactHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));


    }


    public void stop() {
        wd.quit();
    }

    public GroupsHelper group() {
        return GroupsHelper;
    }

    public NavigationHelper goTo() {
        return NavigationHelper;
    }

    public ContactHelper contact() {
        return ContactHelper;
    }

    public DbHelper db() {
        return dbHelper;
    }

    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }


}
