package co.com.sofka.userinterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers")
public class LoginPage extends PageObject {
        public static final Target TEXT_USERNAME = Target.the("Text username")
                .located(By.id("txtUsername"));
        public static final Target TEXT_PASSWORD = Target.the("Text password")
                .located(By.id("txtPassword"));
        public static final Target BTN_LOGIN = Target.the("Login button")
                .located(By.id("btnLogin"));
        public static final Target LINK_FORGOT_YOUR_PASSWPRD = Target.the("Link forgot your password?")
                .located(By.id("forgotPasswordLink"));
        public static final Target CREDENTIALS_MESSAGE = Target.the("Login message")
                .located(By.id("spanMessage"));



}
