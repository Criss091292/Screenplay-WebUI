package co.com.sofka.questions;

import co.com.sofka.userinterface.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class WelcomeMessage implements Question<String> {
    public static WelcomeMessage message(){
        return new WelcomeMessage();
    }
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(LoginPage.WELCOME_MESSAGE).viewedBy(actor).asString();
    }
}
