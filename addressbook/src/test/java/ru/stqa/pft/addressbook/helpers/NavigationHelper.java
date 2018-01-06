package ru.stqa.pft.addressbook.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.helpers.BaseHelper;

public class NavigationHelper extends BaseHelper {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void goToGroupPage() {


    if (isElementPresent(new By.ByTagName("H1"))
            && wd.findElement(new By.ByTagName("H1")).getText().equals("Groups")
        && isElementPresent(new By.ByTagName("new"))){
        return;
        }
        click(By.linkText("groups"));
}
    //przenieść do NavigationTest - funkcja if sprawcza czy na stronie znajduje się tabela//
    public void returnToHomePage() {
        if (isElementPresent(By.id("maintable"))){
            return;}
        click(By.linkText("home"));
    }
}