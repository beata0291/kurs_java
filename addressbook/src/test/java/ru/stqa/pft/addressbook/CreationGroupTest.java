package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class CreationGroupTest extends TestBase {

    @Test
    public void testCreationGroup() {

        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("Polska", "małopolska", "Kraków"));
        app.getGroupHelper().submitGroup();
        app.getGroupHelper().returnToAllGroup();
    }

}
