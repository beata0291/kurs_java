package ru.stqa.pft.addressbook.tests.Group;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;
import ru.stqa.pft.addressbook.models.Groups;
import ru.stqa.pft.addressbook.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class CreationGroupTest extends TestBase {

    @Test
    public void testCreationGroup() {

        app.getNavigationHelper().goToGroupPage();

        Groups before = app.getGroupsHelper().all();
        GroupData createGroup = before.iterator().next();

        GroupData group = new GroupData()
                .withId(createGroup.getId()).withName("Test1").withHeader("Test2").withFooter("Test3");

        app.getGroupsHelper().createGroup(group);
        Groups after = app.getGroupsHelper().all();

        assertEquals(after.size(), before.size()+1);
        assertThat(after, equalTo(before.without(createGroup).withAdded(group)));


    }

}
