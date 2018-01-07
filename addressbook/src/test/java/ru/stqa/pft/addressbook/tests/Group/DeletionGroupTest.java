package ru.stqa.pft.addressbook.tests.Group;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;
import ru.stqa.pft.addressbook.tests.TestBase;

public class DeletionGroupTest extends TestBase {

    @Test
    public void testDeletionGroup() {

        app.getNavigationHelper().goToGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
            }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().clickDeleteGroup();
        app.getGroupHelper().returnToAllGroup();
    }

}
