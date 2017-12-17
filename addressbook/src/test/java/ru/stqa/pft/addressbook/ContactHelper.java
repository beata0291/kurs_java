package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends BaseHelper{

    public ContactHelper(WebDriver wd) {
        super(wd);
    }
    public void login(String username, String password) {
        type(By.name("user"),username );
        type (By.name("pass"),password );
        click(By.xpath("//form[@id='LoginForm']/input[3]"));
    }
}
