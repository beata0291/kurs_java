package ru.stqa.pft.addressbook.tests.Group;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;
import ru.stqa.pft.addressbook.models.Groups;
import ru.stqa.pft.addressbook.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreationGroupTest extends TestBase {

    @Test
    public void testCreationGroup() {

        app.goTo().groupPage();

        Groups before = app.Group().all();
        GroupData group = new GroupData().withName("Test");

            app.Group().create(group);

        Groups after = app.Group().all();
        Assert.assertEquals(after.size(), before.size() + 1);


        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));


    }

}
