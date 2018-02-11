package ru.stqa.pft.addressbook.tests.ComponentContact;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupAdressData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDetailsTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.goTo().contactPage();
            app.contact().create(new GroupAdressData().withLastName("test_last_name").withFirstName("test_first_name").withMobile("test_mobile").withEmail("test_email"));
        }
    }

    @Test
    public void testContactDetails() {
        GroupAdressData contacts = app.contact().all().iterator().next();
        GroupAdressData contactInfoFromEditForm = app.contact().infoFromEditForm(contacts);
        String detailsData = app.contact().infoFromDetailsPage(contacts);

        String cleanEditFormData = mergeDetails(CreateFormatted(contactInfoFromEditForm));
        String cleanedDataDetailsForm = cleaned(detailsData);

        assertThat(cleanedDataDetailsForm, equalTo(cleanEditFormData));
        verifyContactListinUI();
    }

    private String mergeDetails(GroupAdressData contact) {
        return Arrays.asList(contact.getFirstName(),contact.getMiddlename(),contact.getLastName(),contact.getNickname(),contact.getTitle(),
                            contact.getCompany(),contact.getAddressResidence(),contact.getHomePhone(),contact.getMobile(),contact.getWorkPhone(),contact.getFax(),
                            contact.getEmail(),contact.getEmail2(),contact.getEmail3(),contact.getHomepage(), contact.getBirthday(),contact.getAnniversary(),
                            contact.getSecondaryAddress(),contact.getSecondaryHomePhone(),contact.getNotes())
                .stream().filter((s) -> s != null && !s.equals("")).map(ContactDetailsTests::cleaned).collect(Collectors.joining());

    }

    public static String cleaned(String data) {
        return data.replaceAll("\n", "").replace(" ", "")
                .replace(".", "").replace("-", "");
    }

    public GroupAdressData CreateFormatted(GroupAdressData source) {
        GroupAdressData result = new GroupAdressData();
        if (source.getHomePhone() != null && source.getHomePhone().length() > 0) {
            result.withHomePhone("H:" + source.getHomePhone());
        } else {
            result.withHomePhone(source.getHomePhone());
        }
        if (source.getMobile() != null && source.getMobile().length() > 0) {
            result.withMobile("M:" + source.getMobile());
        } else {
            result.withMobile(source.getMobile());
        }
        if (source.getWorkPhone() != null && source.getWorkPhone().length() > 0) {
            result.withWorkPhone("W:" + source.getWorkPhone());
        } else {
            result.withWorkPhone(source.getWorkPhone());
        }
        if (source.getFax() != null && source.getFax().length() > 0) {
            result.withFax("F:" + source.getFax());
        } else {
            result.withFax(source.getFax());
        }
        if (source.getHomepage() != null && source.getHomepage().length() > 0) {
            result.withHomepage("Homepage:" + source.getHomepage());
        } else {
            result.withHomepage(source.getHomepage());
        }
        if (source.getSecondaryHomePhone() != null && source.getSecondaryHomePhone().length() > 0) {
            result.withSecondaryHomePhone("P:" + source.getSecondaryHomePhone());
        } else {
            result.withSecondaryHomePhone(source.getSecondaryHomePhone());
        }
        if (source.getBirthday() != null && source.getBirthday().length() > 0 && !source.getBirthday().equals("--")) {
            result.withBirthday("Birthday" + source.getBirthday());
        } else {
            result.withBirthday(source.getBirthday());
        }
        if (source.getAnniversary() != null && source.getAnniversary().length() > 0 && !source.getAnniversary().equals("--")) {
            result.withAnniversary("Anniversary" + source.getAnniversary());
        } else {
            result.withAnniversary(source.getAnniversary());
        }

        result.withEmail(source.getEmail()).withEmail2(source.getEmail2()).withEmail3(source.getEmail3())
                            .withFirstName(source.getFirstName()).withLastName(source.getLastName()).withMiddlename(source.getMiddlename())
                            .withNickname(source.getNickname()).withTitle(source.getTitle()).withAddressResidence(source.getAddressResidence())
                            .withCompany(source.getCompany()).withSecondaryAddress(source.getSecondaryAddress()).withNotes(source.getNotes());

        return result;
    }
}