package ru.stqa.pft.addressbook.tests.Address;

import org.testng.annotations.Test;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.models.GroupAdressData;
import ru.stqa.pft.addressbook.tests.TestBase;

public class EditAddress extends TestBase {

    @Test
    public void testEditAddress() {
        selectAddress();
        clickToEditAddress();
        fillAddressForm(new GroupAdressData("Jan", "Kowalski", "Warszawa", "jan@wp.pl", "785456225455", null));
        clickToUpdateAddress();
        returnToHomePage();
    }


}
