package ru.stqa.pft.addressbook.tests.Group;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;
import ru.stqa.pft.addressbook.models.Groups;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.Comparator;
import java.util.HashSet;

public class CreationGroupTest extends TestBase {

    @Test
    public void testCreationGroup() {

        app.getNavigationHelper().goToGroupPage();

        Groups before = app.getGroupsHelper().all();
        GroupData group = new GroupData().withName("Test");

            app.getGroupsHelper().createGroup(group);

        Groups after = app.getGroupsHelper().all();
        Assert.assertEquals(after.size(), before.size() + 1);


        group.setId(after.stream().max(Comparator.comparingInt(GroupData::getId)).get().getId());
            before.add(group);
                    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));




    }

}
