package co.com.sofka.userinterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers")
public class SystemUsersPage extends PageObject {
        public static final Target WELCOME_MESSAGE = Target.the("Welcome message")
                .located(By.id("welcome"));
}
