package ru.stqa.pft.addressbook.tests.Group;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;
import ru.stqa.pft.addressbook.models.Groups;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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

        Groups before = app.getGroupHelper().all();
        GroupData deletedGroup = before.iterator().next();

        app.getGroupHelper().delete(deletedGroup);
        Groups after = app.getGroupHelper().all();
        assertEquals(after.size(), before.size() -1);

        before.remove(deletedGroup);
        assertEquals(before, after);

        assertEquals(after.size(), before.size() - 1);
        assertThat(after, equalTo(before.without(deletedGroup)));
        }

}
