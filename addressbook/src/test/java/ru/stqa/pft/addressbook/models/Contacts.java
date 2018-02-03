package ru.stqa.pft.addressbook.models;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Contacts extends ForwardingSet<GroupAdressData> {

    private Set<GroupAdressData> delegate;

           public Contacts(Contacts contacts) {
            this.delegate = new HashSet<GroupAdressData>(contacts.delegate);
          }

           public Contacts() {
            this.delegate = new HashSet<GroupAdressData>();

                  }


           @Override
   protected Set<GroupAdressData> delegate() {
           return delegate;
          }

           public Contacts withAdded(GroupAdressData contact) {
            Contacts contacts = new Contacts(this);
            contacts.add(contact);
            return contacts;
          }

           public Contacts without(GroupAdressData contact) {
            Contacts contacts = new Contacts(this);
            contacts.remove(contact);
            return contacts;
          }
 }

