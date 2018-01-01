package ru.stqa.pft.addressbook.tests;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.helpers.ApplicationManager;
import ru.stqa.pft.addressbook.helpers.BaseHelper;
import ru.stqa.pft.addressbook.models.GroupAdressData;

public class TestBase {


    public WebDriver wd;
    public ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }
//przenieść do NavigationTest - funkcja if sprawcza czy na stronie znajduje się tabela//
    public void returnToHomePage() {
        if (isElementPresent(By.id("maintable"))){
            return;}
        click(By.linkText("home"));
    }

    public void submitAddress() {
        app.wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void fillAddressForm(GroupAdressData groupAdressData, boolean Creation) {
        app.wd.findElement(By.name("firstname")).click();
        app.wd.findElement(By.name("firstname")).clear();
        app.wd.findElement(By.name("firstname")).sendKeys(groupAdressData.getFirstName());
        app.wd.findElement(By.name("lastname")).click();
        app.wd.findElement(By.name("lastname")).clear();
        app.wd.findElement(By.name("lastname")).sendKeys(groupAdressData.getLastName());
        app.wd.findElement(By.name("address")).click();
        app.wd.findElement(By.name("address")).clear();
        app.wd.findElement(By.name("address")).sendKeys(groupAdressData.getAddress());
        app.wd.findElement(By.name("email")).click();
        app.wd.findElement(By.name("email")).clear();
        app.wd.findElement(By.name("email")).sendKeys(groupAdressData.getEmail());
        app.wd.findElement(By.name("mobile")).click();
        app.wd.findElement(By.name("mobile")).clear();
        app.wd.findElement(By.name("mobile")).sendKeys(groupAdressData.getPhones());

        if (Creation) new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(GroupAdressData.getGroup());
        else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));

        }
    }
    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void initAddressCreation() {
        app.wd.findElement(By.name("firstname")).click();

    }

    public void goToNewAddressPage() {
        app.wd.findElement(By.linkText("add new")).click();
    }

    public void clickToUpdateAddress() {
        click(By.name("update"));
    }

    public void clickToEditAddress() {
        click(By.name("edit"));
    }

    public void acceptToDeleteAddress() {
        click(By.cssSelector("div.msgbox"));
    }

    public void clickToDeleteAddress() {
        click(By.name("delete"));
    }

    public void selectAddress() {
        click(By.name("selected[]"));
    }

    public void click(By locator) {
    }

}