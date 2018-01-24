package ru.stqa.pft.addressbook.tests.Group;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;
import ru.stqa.pft.addressbook.models.Groups;
import ru.stqa.pft.addressbook.tests.TestBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CreationGroupTest extends TestBase {

    @Test
    public void testCreationGroup() {

        app.getNavigationHelper().goToGroupPage();

        Groups before = app.getGroupsHelper().all();
        app.getGroupsHelper().initGroupCreation();
        GroupData group = new GroupData().withName("Test1");
        app.getGroupsHelper().fillGroupForm(group);
        app.getGroupsHelper().submitGroup();
        app.getGroupsHelper().returnToAllGroup();
        Groups after = app.getGroupsHelper().all();

        assertThat(after.size(),equalTo(before.size() ));
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));


    }

}
