package ru.stqa.pft.addressbook;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class CreationAddress extends TestBase{


    @Test
    public void CreationAddress() {

        goToNewAddressPage();
        initAddressCreation();
        fillAddressForm(new GroupAdressData("Jan", "Kowalski", "Warszawa", "jan@wp.pl", "785456225455"));
        submitAddress();
        returnAllAddress();
    }

    private void returnAllAddress() {
        wd.findElement(By.linkText("home page")).click();
    }

    private void submitAddress() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    private void fillAddressForm(GroupAdressData groupAdressData) {
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
    }

    private void initAddressCreation() {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
    }

    private void goToNewAddressPage() {
        wd.findElement(By.linkText("add new")).click();
    }


}
