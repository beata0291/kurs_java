package ru.stqa.pft.addressbook.tests.Group;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.hamcrest.core.IsEqual;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;
import ru.stqa.pft.addressbook.models.Groups;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class CreationGroupTest extends TestBase {

    @Test
    public void testCreationGroup() {

        app.getNavigationHelper().goToGroupPage();

        Groups before = app.getGroupHelper().all();
        app.getGroupHelper().initGroupCreation();
        GroupData group = new GroupData().withName("Test1");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroup();
        app.getGroupHelper().returnToAllGroup();
        Groups after = app.getGroupHelper().all();

        assertThat(after.size(),equalTo(before.size() +1));
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));


    }

}
