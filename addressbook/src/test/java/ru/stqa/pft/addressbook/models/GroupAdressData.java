package ru.stqa.pft.addressbook.models;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;

@XStreamAlias("contact")
public class GroupAdressData {
    @XStreamOmitField


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
    private String middlename;
    private String nickname;
    private String title;
    private String fax;
    private String company;
    private String homepage;
    private String birthday;
    private String birthdayDay;
    private String birthdayMonth;
    private String birthdayYear;
    private String anniversary;
    private String anniversaryDay;
    private String anniversaryMonth;
    private String anniversaryYear;
    private String secondaryAddress;
    private String secondaryHomePhone;
    public File photo;

    public  File getPhoto() {
        return photo;
    }

    public GroupAdressData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    public String getBirthdayMonth() {
        return birthdayMonth;
    }

    public GroupAdressData withBirthdayMonth(String birthdayMonth) {
        this.birthdayMonth = birthdayMonth;
        return this;
    }

    public String getBirthdayYear() {
        return birthdayYear;
    }

    public GroupAdressData withBirthdayYear(String birthdayYear) {
        this.birthdayYear = birthdayYear;
        return this;
    }

    public String getAnniversary() {
        return anniversary;
    }

    public GroupAdressData withAnniversary(String anniversary) {
        this.anniversary = anniversary;
        return this;
    }

    public String getAnniversaryDay() {
        return anniversaryDay;
    }

    public GroupAdressData withAnniversaryDay(String anniversaryDay) {
        this.anniversaryDay = anniversaryDay;
        return this;
    }

    public String getAnniversaryMonth() {
        return anniversaryMonth;
    }

    public GroupAdressData withAnniversaryMonth(String anniversaryMonth) {
        this.anniversaryMonth = anniversaryMonth;
        return this;
    }

    public String getAnniversaryYear() {
        return anniversaryYear;
    }

    public GroupAdressData withAnniversaryYear(String anniversaryYear) {
        this.anniversaryYear = anniversaryYear;
        return this;
    }

    public String getSecondaryAddress() {
        return secondaryAddress;
    }

    public GroupAdressData withSecondaryAddress(String secondaryAddress) {
        this.secondaryAddress = secondaryAddress;
        return this;
    }

    public String getSecondaryHomePhone() {
        return secondaryHomePhone;
    }

    public GroupAdressData withSecondaryHomePhone(String secondaryHomePhone) {
        this.secondaryHomePhone = secondaryHomePhone;
        return this;
    }

    public String getNotes() {
        return notes;
    }

    public GroupAdressData withNotes(String notes) {
        this.notes = notes;
        return this;
    }


    public String getMiddlename() {
        return middlename;
    }

    public GroupAdressData withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public GroupAdressData withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public GroupAdressData withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getFax() {
        return fax;
    }

    public GroupAdressData withFax(String fax) {
        this.fax = fax;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public GroupAdressData withCompany(String company) {
        this.company = company;
        return this;
    }

    public String getHomepage() {
        return homepage;
    }

    public GroupAdressData withHomepage(String homepage) {
        this.homepage = homepage;
        return this;
    }

    public String getBirthday() {
        return birthday;
    }

    public GroupAdressData withBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getBirthdayDay() {
        return birthdayDay;
    }

    public GroupAdressData withBirthdayDay(String birthdayDay) {
        this.birthdayDay = birthdayDay;
        return this;
    }

    private String notes;

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