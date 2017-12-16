package ru.stqa.pft.addressbook;

public class GroupAdressData {
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String email;
    private final String phones;

    public GroupAdressData(String firstName, String lastName, String address, String email, String phones) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phones = phones;
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
}
