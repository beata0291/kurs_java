package ru.stqa.pft.addressbook.tests.ComponentContact;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupAdressData;
import ru.stqa.pft.addressbook.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.goTo().contactPage();
            app.contact().create(new GroupAdressData().withLastName("test_last_name").withFirstName("test_last_name").withMobile("test_mobile").withEmail("test_email").withAddressResidence("test1"));
        }
    }

    @Test
    public void testContactAddress() {
        GroupAdressData contact = app.contact().all().iterator().next();
        GroupAdressData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(cleaned(contact.getAddressResidence()), equalTo(cleaned(contactInfoFromEditForm.getAddressResidence())));

    }

    private String cleaned(String addressResidence) {
        return addressResidence.replaceAll("\\s", "");
    }
}