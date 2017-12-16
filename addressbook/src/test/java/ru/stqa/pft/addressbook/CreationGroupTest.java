package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class CreationGroupTest extends TestBase {

    @Test
    public void testCreationGroup() {

        app.goToGroupPage();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("Polska", "małopolska", "Kraków"));
        app.submitGroup();
        app.returnToAllGroup();
    }

}
