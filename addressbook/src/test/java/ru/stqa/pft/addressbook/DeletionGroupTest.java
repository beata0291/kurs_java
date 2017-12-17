package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class DeletionGroupTest extends TestBase{

    @Test
    public void testDeletionGroup() {

        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().clickDeleteGroup();
        app.getGroupHelper().returnToAllGroup();
    }

}
