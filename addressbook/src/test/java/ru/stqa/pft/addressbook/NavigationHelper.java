package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends BaseHelper{

    public NavigationHelper(FirefoxDriver wd) {
        super(wd);
    }

    protected void goToGroupPage() {
        click(By.linkText("groups"));
    }
}
