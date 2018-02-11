package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationHelper extends HelperBase {

    private WebDriver wd;

    public RegistrationHelper(ApplicationManager app) {
        super(app);

    }
        public void start (String username, String email) throws InterruptedException, ClassNotFoundException {

            wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
            Thread.sleep(9000);
            type(By.name("username"), username);
            type(By.name("email"), email);
            click(By.cssSelector("input[value='Signup']"));
        }


        public void finish (String confirmationLink, String password) throws ClassNotFoundException {
            wd.get(confirmationLink);
            type(By.name("password"), password);
            type(By.name("password_confirm"), password);
            click(By.cssSelector("input[value='Update User']"));
        }


}
