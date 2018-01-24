package ru.stqa.pft.addressbook.tests.Address;

import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.models.GroupAdressData;
import ru.stqa.pft.addressbook.tests.TestBase;

public class EditAddress extends TestBase {

    @Test
    public void testEditAddress() {
        app.getNavigationHelper().goToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new GroupAdressData("test_first_name", "test_last_name", "test_address", "test_email", "test_mobile", "Test1"));
        }
            app.getContactHelper().selectAddress();
            app.getContactHelper().clickToEditAddress();
            app.getContactHelper().fillAddressForm(new GroupAdressData("test_first_name", "test_last_name", "test_address", "test_email", "test_mobile", "Test1"), false);
            app.getContactHelper().clickToUpdateAddress();
            app.getNavigationHelper().goToHomePage();
        }


    }

