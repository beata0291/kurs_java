package ru.stqa.pft.addressbook;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class CreationGroupTest extends TestBase {

    @Test
    public void testCreationGroup() {

        goToGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("Polska", "małopolska", "Kraków"));
        submitGroup();
        returnToAllGroup();
    }

}
