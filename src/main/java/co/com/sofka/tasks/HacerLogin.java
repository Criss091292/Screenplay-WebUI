package co.com.sofka.tasks;
import co.com.sofka.models.LoginPageModel;
import co.com.sofka.userinterface.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;


    public class HacerLogin  implements Task {
        private LoginPageModel datos;

        public HacerLogin() {
        }

        public HacerLogin HacerLogin() {
            return this;
        }

        public static HacerLogin conLosDatos(LoginPageModel datos) {
            return Tasks.instrumented(HacerLogin.class);
        }

        @Override
        public <T extends Actor> void performAs(T actor) {


            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            actor.attemptsTo(
                    WaitUntil.the(LoginPage.BTN_LOGIN, WebElementStateMatchers.isVisible()),
                    Enter.theValue(datos.getUsername()).into(LoginPage.TEXT_USERNAME),
                    Enter.theValue(datos.getPassword()).into(LoginPage.TEXT_PASSWORD),
                    Click.on(LoginPage.BTN_LOGIN)
            );

        }
}
