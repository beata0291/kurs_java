package ru.stqa.pft.addressbook.tests.Address;

import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.models.GroupAdressData;
import ru.stqa.pft.addressbook.tests.TestBase;

public class CreationAddress extends TestBase {


    @Test
    public void CreationAddress() {

        goToNewAddressPage();
        initAddressCreation();
        fillAddressForm(new GroupAdressData("Jan", "Kowalski", "Warszawa", "jan@wp.pl", "785456225455", "Polska"));
        submitAddress();
        returnToHomePage();
    }

}
