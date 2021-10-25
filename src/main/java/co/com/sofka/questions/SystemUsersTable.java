package co.com.sofka.questions;

import co.com.sofka.userinterface.LoginPage;
import co.com.sofka.userinterface.SystemUsersPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class SystemUsersTable implements Question<Boolean> {
    public static SystemUsersTable hassAllRoles(){
        return new SystemUsersTable();
    }
    public static SystemUsersTable hasOnlyASpecificRole(){
        return new SystemUsersTable();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return true;
    }

}
