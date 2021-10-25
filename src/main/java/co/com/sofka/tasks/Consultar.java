package co.com.sofka.tasks;

import co.com.sofka.userinterface.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.type.TypeValueIntoElement;
import net.serenitybdd.screenplay.actions.type.TypeValueIntoTarget;

public class Consultar implements Task {
    public Consultar() {
        super();
    }

    public static Consultar elCodigo() {
        return Tasks.instrumented(Consultar.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

       actor.attemptsTo(new TypeValueIntoTarget(LoginPage.TEXT_USERNAME,"texto"));

    }
}
