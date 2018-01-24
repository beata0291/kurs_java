package ru.stqa.pft.addressbook.tests.Address;

import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.models.GroupAdressData;
import ru.stqa.pft.addressbook.tests.TestBase;

public class CreationAddress extends TestBase {


    @Test
    public void CreationAddress() {
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().goToNewAddressPage();
        app.getContactHelper().initAddressCreation();
        app.getContactHelper().fillAddressForm(new GroupAdressData("Jan", "Kowalski", "Warszawa", "jan@wp.pl", "785456225455", "Polska"), true);/*działą gdy mamy dodaną grupę "Polska*/
        app.getContactHelper().submitAddress();
        app.getNavigationHelper().goToHomePage();
    }

}
