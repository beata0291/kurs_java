package ru.stqa.pft.addressbook.tests.Contact;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.Contacts;
import ru.stqa.pft.addressbook.models.GroupAdressData;
import ru.stqa.pft.addressbook.models.GroupData;
import ru.stqa.pft.addressbook.models.Groups;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreationContact extends TestBase {

    @BeforeMethod

          public void ensurePreconditions(){
            if (app.db().groups().size()==0){
                  app.goTo().groupPage();
                  app.group().create(new GroupData().withName("test1"));
                }
          }

    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))) {
                  String xml = "";
                  String line = reader.readLine();
                  while (line != null) {
                        xml += line;
                        line = reader.readLine();
                      }
                  XStream xstream = new XStream();
                  xstream.processAnnotations(GroupAdressData.class);
                  List<GroupAdressData> contacts = (List<GroupAdressData>) xstream.fromXML(xml);
                  return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
                }

          }


    @Test(dataProvider = "validContacts")
   public void testContactCreation(GroupAdressData contact) {
        Groups groups=app.db().groups();
        app.goTo().homePage();

        Contacts before = app.db().contacts();
        File photo=new File("src/test/resources/.gift.jpeg");
        contact.withPhoto(photo).inGroup(groups.iterator().next());
        app.contact().create(contact);
        app.goTo().homePage();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.db().contacts();

        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
        verifyContactListinUI();
    }

}


