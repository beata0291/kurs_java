package ru.stqa.pft.addressbook.tests.Address;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.Contacts;
import ru.stqa.pft.addressbook.models.GroupAdressData;
import ru.stqa.pft.addressbook.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreationAddress extends TestBase {


    @Test
    public void CreationAddress() {
        app.goTo().goToHomePage();

        Contacts before = app.Contact().all();
        GroupAdressData contact = new GroupAdressData().withLastName("test_last_name").withFirstName("test_first_name").withMobile("test_mobile").withEmail("test_email").withGroup("test1");
        app.Contact().createContact(contact);
        app.goTo().goToHomePage();


        Contacts after = app.Contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);


        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

}


