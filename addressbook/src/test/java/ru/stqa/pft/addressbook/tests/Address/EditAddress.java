package ru.stqa.pft.addressbook.tests.Address;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupAdressData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.HashSet;
import java.util.List;

public class EditAddress extends TestBase {

    @Test
    public void testEditAddress() {
        app.getNavigationHelper().goToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new GroupAdressData("test_last_name", "test_first_name", "test_address", "test_email", "test_mobile", "Test1"));
        }
        List<GroupAdressData> before = app.getContactHelper().getContactList();

            app.getContactHelper().selectAddress(0);
            app.getContactHelper().clickToEditAddress();
            GroupAdressData contact = new GroupAdressData(before.get(0).getId(),"test_last_name", "test_first_name", "test_address", "test_email", "test_mobile", "Test1");
            app.getContactHelper().fillAddressForm(contact, false);
            app.getContactHelper().clickToUpdateAddress();
            app.getNavigationHelper().goToHomePage();

        List<GroupAdressData> after = app.getContactHelper().getContactList();
            Assert.assertEquals(after.size(), before.size());

            before.remove(0);
            before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

        }


    }

