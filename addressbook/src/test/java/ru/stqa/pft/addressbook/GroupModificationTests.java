package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

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
