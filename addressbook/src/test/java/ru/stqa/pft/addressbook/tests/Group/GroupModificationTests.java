package ru.stqa.pft.addressbook.tests.Group;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;
import ru.stqa.pft.addressbook.models.Groups;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondicions() {
        app.getNavigationHelper().goToGroupPage();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData().withName("Test1"));
        }
    }

    @Test
    public void testGroupModification() {

        Groups before = app.getGroupHelper().all();
        GroupData modifiedGroup = before.iterator().next();

        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("Test1").withHeader("Test2").withFooter("Test3");

        app.getGroupHelper().modifyGroup(group);
        Groups after = app.getGroupHelper().all();
        
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));

        }


}

