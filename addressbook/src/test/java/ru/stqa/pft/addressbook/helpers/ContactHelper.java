package ru.stqa.pft.addressbook.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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

    public void selectAddress(int id) {
        click(By.name("selected[]"));
    }

    public void submitAddress() {
        click(By.name("submit"));
    }

    public void fillAddressForm(GroupAdressData groupAdressData, boolean Creation) {
        type(By.name("firstname"), groupAdressData.getFirstName());
        type(By.name("lastname"), groupAdressData.getLastName());
        type(By.name("address"), groupAdressData.getAddress());
        type(By.name("email"), groupAdressData.getEmail());
        type(By.name("mobile"), groupAdressData.getMobile());


        if (Creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(groupAdressData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createContact(GroupAdressData contact) {
        initAddressCreation();
        fillAddressForm(contact, true);
        submitAddress();
    }

    public List<GroupAdressData> getContactList() {
        List<GroupAdressData> contacts = new ArrayList<GroupAdressData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            List<WebElement> cells = element.findElements(By.tagName("td"));
            String firtsName = cells.get(1).getText();
            String lastName = cells.get(2).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            GroupAdressData contact = new GroupAdressData(id, firtsName,lastName, null, null, null, null);
            contacts.add(contact);
        }

        return contacts;
    }
}