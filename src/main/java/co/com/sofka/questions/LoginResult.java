package co.com.sofka.questions;

import co.com.sofka.userinterface.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class LoginResult implements Question<String> {

    public static LoginResult message(){
        return new LoginResult();
    }
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(LoginPage.CREDENTIALS_MESSAGE).viewedBy(actor).asString();
    }
}
