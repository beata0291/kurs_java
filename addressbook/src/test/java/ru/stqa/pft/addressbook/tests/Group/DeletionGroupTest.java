package ru.stqa.pft.addressbook.tests.Group;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.tests.TestBase;

public class DeletionGroupTest extends TestBase {

    @Test
    public void testDeletionGroup() {

        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().clickDeleteGroup();
        app.getGroupHelper().returnToAllGroup();
    }

}
