package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.helpers.ApplicationManager;
import ru.stqa.pft.addressbook.models.GroupAdressData;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

    protected void returnToHomePage() {
        app.wd.findElement(By.linkText("home page")).click();
    }

    protected void submitAddress() {
        app.wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    protected void fillAddressForm(GroupAdressData groupAdressData) {
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
    }

    protected void initAddressCreation() {
        app.wd.findElement(By.name("firstname")).click();
        app.wd.findElement(By.name("firstname")).clear();
    }

    protected void goToNewAddressPage() {
        app.wd.findElement(By.linkText("add new")).click();
    }
}
