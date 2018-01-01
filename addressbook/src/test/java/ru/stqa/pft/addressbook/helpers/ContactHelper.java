package ru.stqa.pft.addressbook.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import ru.stqa.pft.addressbook.models.GroupAdressData;

public class ContactHelper extends BaseHelper {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }
    public void login(String username, String password) {
        type(By.name("user"),username );
        type (By.name("pass"),password );
        click(By.xpath("//form[@id='LoginForm']/input[3]"));
    }


}
