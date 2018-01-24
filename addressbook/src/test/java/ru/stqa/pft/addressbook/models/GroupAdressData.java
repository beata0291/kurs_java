package ru.stqa.pft.addressbook.models;

public class GroupAdressData {
    private  String firstName;
    private  String lastName;
    private  String address;
    private  String email;
    private  String phones;
    private  String group;

    public GroupAdressData(String firstName, String lastName, String address, String email, String phones, String group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phones = phones;
        this.group = group;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhones() {
        return phones;
    }

    public String getGroup() {
        return group;
    }
}
