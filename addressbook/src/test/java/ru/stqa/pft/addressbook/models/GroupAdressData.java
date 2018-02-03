package ru.stqa.pft.addressbook.models;

public class GroupAdressData {


    private int id;
    private  String lastName;
    private  String firstName;
    private  String address;
    private  String email;
    private  String mobile;
    private  String group;


    public int getId() {
        return id;
    }

    public GroupAdressData(int id,  String lastName,String firstName, String address, String email, String mobile, String group) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.email = email;
        this.mobile = mobile;
        this.group = group;
    }


    public GroupAdressData(String lastName,String firstName, String address, String email, String mobile, String group) {
        this.id = 0;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.email = email;
        this.mobile = mobile;
        this.group = group;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupAdressData that = (GroupAdressData) o;

        if (id != that.id) return false;
        if (lastName != null ? lastName.equals(that.lastName) : that.lastName == null) return false;
        return firstName != null ? !firstName.equals(that.firstName) : that.firstName != null;



    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);


        return result;
    }
    @Override
    public String toString() {
        return "GroupAdressData{" +
                "id='" + id + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }
}
