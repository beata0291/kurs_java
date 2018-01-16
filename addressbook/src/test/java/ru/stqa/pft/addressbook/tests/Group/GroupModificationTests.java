package ru.stqa.pft.addressbook.tests.Group;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;
import ru.stqa.pft.addressbook.models.Groups;
import ru.stqa.pft.addressbook.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondicions() {
        app.getNavigationHelper().goToGroupPage();
        if (!app.getGroupsHelper().isThereAGroup()) {
            app.getGroupsHelper().createGroup(new GroupData().withName("Test1"));
        }
    }

    @Test
    public void testGroupModification() {

        Groups before = app.getGroupsHelper().all();
        GroupData modifiedGroup = before.iterator().next();

        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("Test1").withHeader("Test2").withFooter("Test3");

        app.getGroupsHelper().modifyGroup(group);
        Groups after = app.getGroupsHelper().all();
        
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));



        }


}

