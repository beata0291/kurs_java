package ru.stqa.pft.addressbook.tests.Group;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;
import ru.stqa.pft.addressbook.tests.TestBase;

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
