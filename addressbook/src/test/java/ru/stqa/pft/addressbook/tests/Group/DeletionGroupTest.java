package ru.stqa.pft.addressbook.tests.Group;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;
import ru.stqa.pft.addressbook.tests.TestBase;

public class DeletionGroupTest extends TestBase {

    @Test
    public void testDeletionGroup() {

        app.getNavigationHelper().goToGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
            }
        app.getGroupHelper().selectGroup(before -1);
        app.getGroupHelper().clickDeleteGroup();
        app.getGroupHelper().returnToAllGroup();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before -1);
    }

}
