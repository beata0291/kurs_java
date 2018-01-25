package ru.stqa.pft.addressbook.tests.Address;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupAdressData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.List;

public class DeletionAddress extends TestBase{

    
    @Test
    public void testDeletionAddress() {
        app.getNavigationHelper().goToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new GroupAdressData("test_first_name", "test_last_name", "test_address", "test_email", "test_mobile", "Test1"));
        }
        List<GroupAdressData> before = app.getContactHelper().getContactList();
           app.getContactHelper().selectAddress(before.size() - 1);

            app.getContactHelper().clickToDeleteAddress();
            app.getContactHelper().acceptToDeleteAddress();
            app.getNavigationHelper().goToHomePage();

        List<GroupAdressData> after = app.getContactHelper().getContactList();
            Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() -1);
            Assert.assertEquals(before, after);
        }

    }

