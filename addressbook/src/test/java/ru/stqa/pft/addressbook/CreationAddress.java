package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

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
        app.wd.findElement(By.linkText("home page")).click();
    }

    private void submitAddress() {
        app.wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    private void fillAddressForm(GroupAdressData groupAdressData) {
        app.wd.findElement(By.name("firstname")).sendKeys(groupAdressData.getFirstName());
        app.wd.findElement(By.name("lastname")).click();
        app.wd.findElement(By.name("lastname")).clear();
        app.wd.findElement(By.name("lastname")).sendKeys(groupAdressData.getLastName());
        app.wd.findElement(By.name("address")).click();
        app.wd.findElement(By.name("address")).clear();
        app.wd.findElement(By.name("address")).sendKeys(groupAdressData.getAddress());
        app.wd.findElement(By.name("email")).click();
        app.wd.findElement(By.name("email")).clear();
        app.wd.findElement(By.name("email")).sendKeys(groupAdressData.getEmail());
        app.wd.findElement(By.name("mobile")).click();
        app.wd.findElement(By.name("mobile")).clear();
        app.wd.findElement(By.name("mobile")).sendKeys(groupAdressData.getPhones());
    }

    private void initAddressCreation() {
        app.wd.findElement(By.name("firstname")).click();
        app.wd.findElement(By.name("firstname")).clear();
    }

    private void goToNewAddressPage() {
        app.wd.findElement(By.linkText("add new")).click();
    }


}
