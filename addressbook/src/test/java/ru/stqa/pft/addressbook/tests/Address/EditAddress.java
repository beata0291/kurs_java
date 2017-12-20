package ru.stqa.pft.addressbook.tests.Address;

import org.testng.annotations.Test;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.tests.TestBase;

public class EditAddress extends TestBase {

    @Test
    public void testEditAddress() {
        //select address//
        clickToEditAddress();
        //fillAddress//
        clickToUpdateAddress();
        //przejscie do strony//
    }


}
