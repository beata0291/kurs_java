package ru.stqa.pft.addressbook.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.models.Contacts;
import ru.stqa.pft.addressbook.models.GroupAdressData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends BaseHelper {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }


    public void initAddressCreation() {
        click(By.name("firstname"));

    }

    public void goToNewAddressPage() {
        click(By.linkText("add new"));
    }

    public void clickToUpdateAddress() {
        click(By.name("update"));
    }

    public void clickToEditAddress() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }


    public void clickToDeleteAddress() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void acceptToDeleteAddress() {
        wd.switchTo().alert().accept();
    }


    public void selectAddressById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void submitAddress() {
        click(By.name("submit"));
    }

    public void delete(GroupAdressData contact) {
        selectAddressById(contact.getId());
        clickToDeleteAddress();
        acceptToDeleteAddress();

    }

    public void fillAddressForm(GroupAdressData groupAdressData) {
        type(By.name("lastname"), groupAdressData.getLastName());
        type(By.name("firstname"), groupAdressData.getFirstName());
        type(By.name("address"), groupAdressData.getAddress());
        type(By.name("email"), groupAdressData.getEmail());
        type(By.name("mobile"), groupAdressData.getMobile());

/*
        if (Creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(groupAdressData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
*/
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createContact(GroupAdressData contact) {
        goToNewAddressPage();
        initAddressCreation();
        fillAddressForm(contact);
        submitAddress();
    }


    public void modify(GroupAdressData contact) {
        selectAddressById(contact.getId());
        clickToEditAddress();
        fillAddressForm(contact);
        clickToUpdateAddress();
    }


    public List<GroupAdressData> getContactList() {
        List<GroupAdressData> contacts = new ArrayList<GroupAdressData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            List<WebElement> cells = element.findElements(By.tagName("td"));
            String lastName = cells.get(2).getText();
            String firstName = cells.get(3).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new GroupAdressData().withId(id).withLastName(lastName).withFirstName(firstName));
        }

        return contacts;
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            List<WebElement> cells = element.findElements(By.tagName("td"));
            String lastName = cells.get(2).getText();
            String firstName = cells.get(3).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new GroupAdressData().withId(id).withLastName(lastName).withFirstName(firstName));
        }

        return contacts;
    }
}