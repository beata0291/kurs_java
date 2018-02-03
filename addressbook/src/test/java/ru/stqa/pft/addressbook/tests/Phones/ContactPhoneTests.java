package ru.stqa.pft.addressbook.tests.Phones;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupAdressData;
import ru.stqa.pft.addressbook.tests.TestBase;

public class ContactPhoneTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.goTo().contactPage();
            app.contact().create(new GroupAdressData().withLastName("test_first_name").withFirstName("test_last_name").withMobile("test_mobile").withEmail("test_email").withGroup("test1"));
        }
    }

    @Test
    public void testContactPhones() {
        app.goTo().homePage();
        GroupAdressData contact = app.contact().all().iterator().next();
        GroupAdressData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    }
}