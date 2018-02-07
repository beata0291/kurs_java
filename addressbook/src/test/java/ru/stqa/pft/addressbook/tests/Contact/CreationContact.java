package ru.stqa.pft.addressbook.tests.Contact;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.Contacts;
import ru.stqa.pft.addressbook.models.GroupAdressData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreationContact extends TestBase {


    @Test
    public void testCreationContact() {
        app.goTo().homePage();

        Contacts before = app.contact().all();

        File photo = new File("src/test/resources/stru.png");
        GroupAdressData contact = new GroupAdressData().withLastName("test_last_name").withFirstName("test_first_name").withMobile("test_mobile").withEmail("test_email").withGroup("test1").withPhoto(photo);
        app.contact().create(contact);
        app.goTo().homePage();
        assertThat(app.contact().count(),  equalTo(before.size() + 1));

        Contacts after = (Contacts) app.contact().all();

        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

}


