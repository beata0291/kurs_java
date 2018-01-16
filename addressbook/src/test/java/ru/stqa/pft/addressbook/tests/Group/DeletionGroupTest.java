package ru.stqa.pft.addressbook.tests.Group;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;
import ru.stqa.pft.addressbook.models.Groups;
import ru.stqa.pft.addressbook.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class DeletionGroupTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondicions() {
        app.getNavigationHelper().goToGroupPage();
        if (!app.getGroupsHelper().isThereAGroup()) {
            app.getGroupsHelper().createGroup(new GroupData().withName("Test1"));
        }
    }
    @Test
    public void testDeletionGroup() {

        Groups before = app.getGroupsHelper().all();
        GroupData deletedGroup = before.iterator().next();

        app.getGroupsHelper().delete(deletedGroup);
        Groups after = app.getGroupsHelper().all();

        assertEquals(after.size(), before.size() -1);
        assertThat(after, equalTo(before.without(deletedGroup)));
        }


}
