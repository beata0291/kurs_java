package ru.stqa.pft.addressbook.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.models.Contacts;
import ru.stqa.pft.addressbook.models.GroupAdressData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    private Contacts contactCache = null;

    public void delete(GroupAdressData contact) {
        selectAddressById(contact.getId());
        clickToDeleteAddress();
        acceptToDeleteAddress();
        contactCache = null;

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

    public void create(GroupAdressData contact) {
        goToNewAddressPage();
        initAddressCreation();
        fillAddressForm(contact);
        submitAddress();
        contactCache = null;
    }


    public void modify(GroupAdressData contact) {
        selectAddressById(contact.getId());
        clickToEditAddress();
        fillAddressForm(contact);
        clickToUpdateAddress();
        contactCache = null;
    }



public Set<GroupAdressData> all() {
    Set<GroupAdressData> contacts = new HashSet<>();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
        List<WebElement> cells = row.findElements(By.tagName("td"));
        int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
        String firtsName = cells.get(2).getText();
        String lastName = cells.get(1).getText();
        String allPhones = cells.get(5).getText();

        contacts.add(new GroupAdressData().withId(id).withLastName(lastName).withFirstName(firtsName)
                .withAllPhones(allPhones));
    }
    return contacts;
}


    public GroupAdressData infoFromEditForm(GroupAdressData contact) {
           initContactModificationById(contact.getId());
           String firtsName = wd.findElement(By.name("firstname")).getAttribute("value");
           String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
           String home = wd.findElement(By.name("home")).getAttribute("value");
           String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
           String work = wd.findElement(By.name("work")).getAttribute("value");
           wd.navigate().back();
           return new GroupAdressData().withId(contact.getId()).withLastName(lastName).withFirstName(firtsName)
                           .withHomePhone(home).withMobile(mobile).withWorkPhone(work);
          }

           private void initContactModificationById(int id) {
          WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
           WebElement row = checkbox.findElement(By.xpath("./../.."));
           List<WebElement> cells = row.findElements(By.tagName("td"));
           cells.get(7).findElement(By.tagName("a")).click();
          }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

}