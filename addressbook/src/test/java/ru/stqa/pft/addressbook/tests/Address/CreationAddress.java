package ru.stqa.pft.addressbook.tests.Address;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.Contacts;
import ru.stqa.pft.addressbook.models.GroupAdressData;
import ru.stqa.pft.addressbook.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreationAddress extends TestBase {


    @Test
    public void CreationAddress() {
        app.goTo().homePage();

        Contacts before = (Contacts) app.contact().all();
        GroupAdressData contact = new GroupAdressData().withLastName("test_last_name").withFirstName("test_first_name").withMobile("test_mobile").withEmail("test_email").withGroup("test1");
        app.contact().create(contact);
        app.goTo().homePage();
        assertThat(app.contact().count(),  equalTo(before.size() + 1));

        Contacts after = (Contacts) app.contact().all();

        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

}


