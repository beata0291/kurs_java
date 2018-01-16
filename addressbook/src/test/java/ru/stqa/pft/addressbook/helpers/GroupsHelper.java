package ru.stqa.pft.addressbook.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.models.GroupData;
import ru.stqa.pft.addressbook.models.Groups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupsHelper extends BaseHelper {


    public GroupsHelper(WebDriver wd) {
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


    public void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }
    public void clickEditGroup() {
        click(By.name("edit"));
    }

    public void submitModificationGroup() {
        click(By.name("update"));
    }

    public void clickDeleteGroup() {
        click(By.name("delete"));
    }

    public void createGroup(GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroup();
        returnToAllGroup();
    }

    public void modifyGroup(GroupData group) {
        selectGroupById(group.getId());
        clickEditGroup();
        fillGroupForm(group);
        submitModificationGroup();
        returnToAllGroup();
    }


    public void delete(GroupData group) {
        selectGroupById(group.getId());
        clickDeleteGroup();
        returnToAllGroup();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();
    }


    public Groups all() {
        Groups groups = new Groups();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groups.add(new GroupData().withId(id).withName(name));
        }
        return groups;
    }


}