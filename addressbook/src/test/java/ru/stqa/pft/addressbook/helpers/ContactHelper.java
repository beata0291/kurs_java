package ru.stqa.pft.addressbook.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.models.GroupAdressData;

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
        click(By.name("edit"));
    }



    public void clickToDeleteAddress() {
        click(By.name("delete"));
    }

    public void acceptToDeleteAddress() {
        wd.switchTo().alert().accept();
    }

    public void selectAddress() {
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
        type(By.name("phones"), groupAdressData.getPhones());
        type(By.name("group"), groupAdressData.getGroup());


        if (Creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(groupAdressData.getGroup());
        }
        else {
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
}
