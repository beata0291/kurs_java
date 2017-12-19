package ru.stqa.pft.addressbook.tests.Group;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;
import ru.stqa.pft.addressbook.tests.TestBase;

public class GroupModificationTests extends TestBase {

    @Test
        public void testGroupModification(){
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().clickEditGroup();
        app.getGroupHelper().fillGroupForm(new GroupData("Polska", "małopolska", "Kraków"));
        app.getGroupHelper().submitModificationGroup();
        app.getGroupHelper().returnToAllGroup();


        }

}
