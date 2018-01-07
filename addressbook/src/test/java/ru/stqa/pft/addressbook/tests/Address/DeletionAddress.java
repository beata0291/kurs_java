package ru.stqa.pft.addressbook.tests.Address;

import org.testng.annotations.Test;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.models.GroupAdressData;
import ru.stqa.pft.addressbook.tests.TestBase;

public class DeletionAddress extends TestBase{

    
    @Test
    public void testDeletionAddress() {
        app.getContactHelper().selectAddress();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new GroupAdressData("Jan", "Kowalski", "Warszawa", "jan@wp.pl", "785456225455", null));
        }

        app.getContactHelper().clickToDeleteAddress();
        app.getContactHelper().acceptToDeleteAddress();

    }


}

