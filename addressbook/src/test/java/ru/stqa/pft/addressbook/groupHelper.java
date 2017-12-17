package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class groupHelper extends BaseHelper {



    public groupHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void returnToAllGroup() {
        click(By.linkText("group page"));
    }

    public void submitGroup() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
        click(By.name("group_name"));
        wd.findElement(By.name("group_name")).clear();
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void clickEditGroup() {
        click(By.name("edit"));
    }

    public void submitModificationGroup() {
        click(By.name("update"));
    }
}