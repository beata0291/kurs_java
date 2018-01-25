package ru.stqa.pft.addressbook.tests.Address;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupAdressData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class CreationAddress extends TestBase {


    @Test
    public void CreationAddress() {
        app.getNavigationHelper().goToHomePage();

        List<GroupAdressData> before = app.getContactHelper().getContactList();
        app.getContactHelper().goToNewAddressPage();
        app.getContactHelper().initAddressCreation();
        GroupAdressData contact = new GroupAdressData(before.get(0).getId(),"test_first_name", "test_last_name", "test_address", "test_email", "test_mobile", "Test1");
        app.getContactHelper().fillAddressForm(contact, true);
        app.getContactHelper().submitAddress();
        app.getNavigationHelper().goToHomePage();

        List<GroupAdressData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size()+1);


        contact.setId(after.stream().max(Comparator.comparingInt(GroupAdressData::getId)).get().getId());
            before.add(contact);
           Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

}
