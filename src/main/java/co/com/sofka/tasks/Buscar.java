package co.com.sofka.tasks;

import co.com.sofka.models.LoginPageModel;
import co.com.sofka.models.SystemUsersPageModel;
import co.com.sofka.userinterface.LoginPage;
import co.com.sofka.userinterface.SystemUsersPage;
import co.com.sofka.util.UserRole;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.type.TypeValueIntoTarget;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class Buscar implements Task {

    private static SystemUsersPageModel datos;

    public Buscar() {
        super();
    }

    public Buscar Buscar() {
        return this;
    }

    public static Buscar usuariosConRol(SystemUsersPageModel dato) {
        datos = dato;
        return Tasks.instrumented(Buscar.class);
    }



    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectFromOptions.byVisibleText(datos.getUserRole().toString()).from(SystemUsersPage.USER_ROLE),
                Click.on(SystemUsersPage.SEARCH_BTN)
        );
    }
}
