package ru.stqa.pft.addressbook.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.models.GroupAdressData;

public class ContactHelper extends BaseHelper {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }


    public void initAddressCreation() {
        click(By.name("firstname"));

    }

    public void goToNewAddressPage() {
        click(By.linkText("add new"));
    }

    public void clickToUpdateAddress() {
        click(By.name("update"));
    }

    public void clickToEditAddress() {
        click(By.name("edit"));
    }

    public void acceptToDeleteAddress() {
        wd.switchTo().alert().accept();
    }

    public void clickToDeleteAddress() {
        click(By.xpath("//div[@id='content']/form[2]/input[2]"));
    }

    public void selectAddress() {
        click(By.name("selected[]"));
    }

    public void submitAddress() {
        click(By.name("submit"));
    }

    public void fillAddressForm(GroupAdressData groupAdressData, boolean Creation) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(groupAdressData.getFirstName());
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(groupAdressData.getLastName());
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(groupAdressData.getAddress());
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(groupAdressData.getEmail());
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(groupAdressData.getPhones());
/*
        if (Creation) new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(groupAdressData.getGroup());
        else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }*/
    }
}
