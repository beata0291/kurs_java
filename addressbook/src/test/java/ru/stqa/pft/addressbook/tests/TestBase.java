package ru.stqa.pft.addressbook.tests;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.helpers.ApplicationManager;
import ru.stqa.pft.addressbook.models.GroupAdressData;

public class TestBase extends AddressHelpeer {

    protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);FirefoxDriver wd;

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

    protected void clickToUpdateAddress() {
        wd.findElement(By.xpath("//div[@id='content']/form[1]/input[22]")).click();
    }

    protected void clickToEditAddress() {
        wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img")).click();
    }

    public void acceptToDeleteAddress() {
        wd.findElement(By.cssSelector("div.msgbox")).click();
    }

    public void clickToDeleteAddress() {
        wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
    }

    public void selectAddress() {
        if (!wd.findElement(By.id("17")).isSelected()) {
            wd.findElement(By.id("17")).click();
        }
    }
}
