package ru.stqa.pft.addressbook.tests.Contact;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.Contacts;
import ru.stqa.pft.addressbook.models.GroupAdressData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreationContact extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
            List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
            String line = reader.readLine();
            while (line !=null) {
                  String[] split = line.split(";");
                  list.add(new Object[]{new GroupAdressData().withFirstName(split[0]).withLastName(split[1]).withMobile(split[2])
                                  .withEmail(split[3])});
                 line = reader.readLine();
                }
            return list.iterator();
          }


    @Test(dataProvider = "validContacts")
   public void testContactCreation(GroupAdressData contact) {
        app.goTo().homePage();

        Contacts before = app.contact().all();
        app.contact().create(contact);
        app.goTo().homePage();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after =  app.contact().all();

        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

}


