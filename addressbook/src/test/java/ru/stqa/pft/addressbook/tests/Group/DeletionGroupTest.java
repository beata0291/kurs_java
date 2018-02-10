package ru.stqa.pft.addressbook.tests.Group;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;
import ru.stqa.pft.addressbook.models.Groups;
import ru.stqa.pft.addressbook.tests.TestBase;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeletionGroupTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondicions() {
        app.goTo().groupPage();
        if (app.db().groups().size() == 0) {
                  app.goTo().groupPage();
        }
    }
    @Test
    public void testDeletionGroup() {

        Groups before = app.db().groups();
        GroupData deletedGroup = before.iterator().next();

        app.goTo().groupPage();
        assertThat(app.group().count(), equalTo(before.size() - 1));
        Groups after = app.db().groups();


        assertThat(after, equalTo(before.without(deletedGroup)));
        }


}
