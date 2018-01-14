package ru.stqa.pft.addressbook.tests.Group;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.Set;

public class CreationGroupTest extends TestBase {

    @Test
    public void testCreationGroup() {

        app.getNavigationHelper().goToGroupPage();

        Set<GroupData> before = app.getGroupHelper().all();
        app.getGroupHelper().initGroupCreation();
        GroupData group = new GroupData().withName("Test1");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroup();
        app.getGroupHelper().returnToAllGroup();
        Set<GroupData> after = app.getGroupHelper().all();
        Assert.assertEquals(after.size(), before.size() +1);


        group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
        before.add(group);
        Assert.assertEquals(before, after);

    }

}
