package ru.stqa.pft.addressbook.tests.Address;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.Contacts;
import ru.stqa.pft.addressbook.models.GroupAdressData;
import ru.stqa.pft.addressbook.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class EditAddress extends TestBase {

    @BeforeMethod
    public void ensurePrecondicions() {
        app.goTo().goToHomePage();
        if (!app.Contact().isThereAContact()) {
            app.Contact().createContact(new GroupAdressData().withLastName("test_last_name").withFirstName("test_first_name").withMobile("test_mobile").withEmail("test_email").withGroup("test1"));
        }
    }

    @Test
    public void testEditAddress() {

        Contacts before = app.Contact().all();
        GroupAdressData modifiedContact = before.iterator().next();

        GroupAdressData contact = new GroupAdressData()
                .withId(modifiedContact.getId()).withLastName("test_last_name").withFirstName("test_first_name").withMobile("test_mobile").withEmail("test_email").withGroup("test1");
        app.Contact().modify(contact);
            app.goTo().goToHomePage();

        Contacts after = app.Contact().all();
            Assert.assertEquals(after.size(), before.size());

        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

        }

}

