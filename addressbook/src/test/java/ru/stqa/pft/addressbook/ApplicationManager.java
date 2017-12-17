package ru.stqa.pft.addressbook;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    FirefoxDriver wd;

    private ContactHelper ContactHelper;

    private NavigationHelper navigationHelper;
    private groupHelper groupHelper;


    protected void init() {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
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
