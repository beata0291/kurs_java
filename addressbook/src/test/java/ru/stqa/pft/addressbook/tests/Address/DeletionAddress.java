package ru.stqa.pft.addressbook.tests.Address;

import org.testng.annotations.Test;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.tests.TestBase;

public class DeletionAddress extends TestBase{

    
    @Test
    public void testDeletionAddress() {
        app.getContactHelper().selectAddress();
        app.getContactHelper().clickToDeleteAddress();
        app.getContactHelper().acceptToDeleteAddress();
    }


}

