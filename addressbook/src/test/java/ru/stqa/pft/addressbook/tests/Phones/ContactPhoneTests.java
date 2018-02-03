package ru.stqa.pft.addressbook.tests.Phones;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupAdressData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {


    @Test
    public void testContactPhones() {
        app.goTo().homePage();
        GroupAdressData contact = app.contact().all().iterator().next();
        GroupAdressData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    }

    private String mergePhones(GroupAdressData contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobile(), contact.getWorkPhone())
                .stream().filter((s) -> !s.equals(""))
                .map(ContactPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));
    }    public static String cleaned (String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }


    }
