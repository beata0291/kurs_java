package ru.stqa.pft.addressbook.tests.Contact;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.Contacts;
import ru.stqa.pft.addressbook.models.GroupAdressData;
import ru.stqa.pft.addressbook.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class EditContact extends TestBase {

    @BeforeMethod
    public void ensurePrecondicions() {
        if (app.db().contacts().size() == 0) {
                  app.goTo().homePage();
            app.goTo().contactPage();
            app.contact().create(new GroupAdressData().withLastName("test_last_name").withFirstName("test_first_name").withMobile("test_mobile").withEmail("test_email").withGroup("test1"));
        }
    }

    @Test
    public void testEditContact() {

        Contacts before = app.db().contacts();
        GroupAdressData modifiedContact = before.iterator().next();

        GroupAdressData contact = new GroupAdressData()
                .withId(modifiedContact.getId()).withLastName("test_last_name").withFirstName("test_first_name").withMobile("test_mobile").withEmail("test_email").withGroup("test1");
        app.goTo().homePage();
        app.contact().modify(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();

        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

        }

}

