package ru.stqa.pft.addressbook.tests.Group;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.List;

public class DeletionGroupTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondicions() {
        app.getNavigationHelper().goToGroupPage();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
    }
    @Test
    public void testDeletionGroup() {

        app.getNavigationHelper().goToGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
            }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() -1);
        app.getGroupHelper().clickDeleteGroup();
        app.getGroupHelper().returnToAllGroup();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() -1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

        }


}
