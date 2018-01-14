package ru.stqa.pft.addressbook.tests.Group;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.Set;

public class DeletionGroupTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondicions() {
        app.getNavigationHelper().goToGroupPage();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData().withName("Test1"));
        }
    }
    @Test
    public void testDeletionGroup() {

        Set<GroupData> before = app.getGroupHelper().all();
        GroupData deletedGroup = before.iterator().next();

        app.getGroupHelper().delete(deletedGroup);
        Set<GroupData> after = app.getGroupHelper().all();
        Assert.assertEquals(after.size(), before.size() -1);

        before.remove(deletedGroup);
        Assert.assertEquals(before, after);
        }

}
