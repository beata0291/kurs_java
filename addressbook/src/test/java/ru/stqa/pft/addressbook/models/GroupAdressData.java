package ru.stqa.pft.addressbook.models;

public class GroupAdressData {


    private int id = Integer.MAX_VALUE;
    private String lastName;
    private String firstName;
    private String address;
    private String email;
    private String mobile;
    private String group;
    private String homePhone;
    private String workPhone;
    public String allPhones;
    private String addressResidence;
    private String email2;
  private String email3;
   private String allEmails;

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public GroupAdressData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public String getGroup() {

        return group;
    }

    public String getAllPhones() {
        return allPhones;
    }


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

    public String getAddressResidence() {
        return addressResidence;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getHomePhone() {
        return homePhone;
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

    public GroupAdressData withAddressResidence(String addressResidence) {
        this.addressResidence = addressResidence;
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

    public GroupAdressData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public GroupAdressData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public GroupAdressData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public GroupAdressData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public GroupAdressData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;


    }
}