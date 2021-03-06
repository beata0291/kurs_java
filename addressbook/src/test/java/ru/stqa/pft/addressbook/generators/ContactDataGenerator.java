package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.models.GroupAdressData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {


    @Parameter(names = "-c", description = "Contact count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;


    public static void main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<GroupAdressData> contacts = generateContacts(count);
        if (format.equals("csv")) {
            saveAsCsv(contacts, new File(file));
        } else if (format.equals("xml")) {
            saveAsXml(contacts, new File(file));
        } else {
            System.out.println("Format nierozpoznany" + format);
        }
    }

    private List<GroupAdressData> generateContacts(int count) {
        List<GroupAdressData> contacts = new ArrayList<GroupAdressData>();
        for (int i = 0; i < count; i++) {
            contacts.add(new GroupAdressData().withFirstName(String.format("test %s", i))
                    .withLastName(String.format("LastName %s", i)).withMobile(String.format("MobilePhone %s", i))
                    .withEmail(String.format("Email %s", i)));

        }
        return contacts;
    }

    private void saveAsXml(List<GroupAdressData> contacts, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(GroupAdressData.class);
        String xml = xstream.toXML(contacts);
        try (Writer writer = new FileWriter(file)) {
            writer.write(xml);
        }
    }

    private void saveAsCsv(List<GroupAdressData> contacts, File file) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        try (Writer writer = new FileWriter(file)) {
            for (GroupAdressData contact : contacts) {
                writer.write(String.format("%s;%s;%s\n", contact.getFirstName(), contact.getLastName(), contact.getAddress()));
            }
        }


        }
    }
