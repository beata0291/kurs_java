package ru.stqa.pft.addressbook.tests.Address;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.Contacts;
import ru.stqa.pft.addressbook.models.GroupAdressData;
import ru.stqa.pft.addressbook.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeletionAddress extends TestBase{

    @BeforeMethod
    public void ensurePrecondicions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.goTo().contactPage();
            app.contact().create(new GroupAdressData().withLastName("test_last_name").withFirstName("test_first_name").withMobile("test_mobile").withEmail("test_email").withGroup("test1"));
        }
    }

    @Test
    public void testDeletionAddress() {

        Contacts before = (Contacts) app.contact().all();
        GroupAdressData deletedGroup = before.iterator().next();
        app.contact().delete(deletedGroup);
        app.goTo().homePage();
        assertThat(app.contact().count(),  equalTo(before.size() - 1));

        Contacts after = (Contacts) app.contact().all();

        assertThat(after, equalTo(before.without(deletedGroup)));

        }



}

