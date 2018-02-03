package ru.stqa.pft.addressbook.models;

public class GroupAdressData {


    private int id = Integer.MAX_VALUE;
    private  String lastName;
    private  String firstName;
    private  String address;
    private  String email;
    private  String mobile;
    private  String group;
    private String homePhone;
   private String workPhone;


    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupAdressData that = (GroupAdressData) o;

        if (id != that.id) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        return firstName != null ? firstName.equals(that.firstName) : that.firstName == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        return result;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getGroup() {
        return group;
    }


    @Override
    public String toString() {
        return "GroupAdressData{" +
                "id='" + id + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +

                '}';
    }

    public GroupAdressData withId(int id) {
        this.id = id;
        return this;
    }

    public GroupAdressData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public GroupAdressData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public GroupAdressData withAddress(String address) {
        this.address = address;
        return this;
    }

    public GroupAdressData withEmail(String email) {
        this.email = email;
        return this;
    }

    public GroupAdressData withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public GroupAdressData withGroup(String group) {
        this.group = group;
        return this;
    }

    public GroupAdressData withHomePhone(String home) {
        this.homePhone = homePhone;
        return this;
    }

    public GroupAdressData withWorkPhone(String work) {
        this.workPhone = workPhone;
        return this;
    }
}
