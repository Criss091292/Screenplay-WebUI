package co.com.sofka.stepdefnitions.webui.login;

import co.com.sofka.models.LoginPageModel;
import co.com.sofka.questions.LoginResult;
import co.com.sofka.tasks.Abrir;
import co.com.sofka.tasks.HacerLogin;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.equalTo;

public class LoginWithCucumberStepDefinition {

    LoginPageModel usuarioCorrectoPasswordIncorrecto;
    LoginPageModel usuarioIncorrectoPasswordCorrecto;
    LoginPageModel datosCorrectos;
    LoginPageModel usuarioVacioYPasswordCualquiera;
    LoginPageModel usuarioCualquieraYPasswordVacio;

    @Before
    public void configuracionInicial(){
        setTheStage(new OnlineCast());
        usuarioCorrectoPasswordIncorrecto = new LoginPageModel();
        usuarioCorrectoPasswordIncorrecto.setUsername("Admin");
        usuarioCorrectoPasswordIncorrecto.setPassword("adssads");

        usuarioIncorrectoPasswordCorrecto = new LoginPageModel();
        usuarioIncorrectoPasswordCorrecto.setUsername("dsada5");
        usuarioIncorrectoPasswordCorrecto.setPassword("admin123");

        datosCorrectos = new LoginPageModel();
        datosCorrectos.setUsername("Admin");
        datosCorrectos.setPassword("admin123");

        usuarioVacioYPasswordCualquiera = new LoginPageModel();
        usuarioVacioYPasswordCualquiera.setUsername("");
        usuarioVacioYPasswordCualquiera.setPassword("admin123");

        usuarioCualquieraYPasswordVacio = new LoginPageModel();
        usuarioCualquieraYPasswordVacio.setUsername("Admin");
        usuarioCualquieraYPasswordVacio.setPassword("");
    }

    @Given("ingreso directamente a la url correspondiente a la ruta admin -user management - users del aplicativo sin haberme autenticado")
    public void ingresoDirectamenteALaUrlCorrespondienteALaRutaAdminUserManagementUsersDelAplicativoSinHabermeAutenticado() {
        theActorCalled("Cristian").wasAbleTo(Abrir.LoginPage());
    }

    @When("Escribo usuario correcto y contrasena incorrecta y pulso el boton submit.")
    public void escriboUsuarioCorrectoYContrasenaIncorrectaYPulsoElBotonSubmit() {
        theActorInTheSpotlight().attemptsTo(HacerLogin.conLosDatos(usuarioCorrectoPasswordIncorrecto));

    }
    @Then("deberia visualizar un mensaje de credenciales invalidas")
    public void deberiaVisualizarUnMensajeDeCredencialesInvalidas() {
        theActorInTheSpotlight().should(seeThat(LoginResult.message(), equalTo("Invalid credentials")));
    }

    @When("Escribo usuario incorrecto y contrasena correcta y pulso el boton submit")
    public void escriboUsuarioIncorrectoYContrasenaCorrectaYPulsoElBotonSubmit() {
        theActorInTheSpotlight().attemptsTo(HacerLogin.conLosDatos(usuarioIncorrectoPasswordCorrecto));
    }

    @When("Escribo usuario y contrasena correctos y pulso el boton submit")
    public void escriboUsuarioYContrasenaCorrectosYPulsoElBotonSubmit() {
        theActorInTheSpotlight().attemptsTo(HacerLogin.conLosDatos(datosCorrectos));
    }

    @Then("el sistema debera mostrar la pagina de usuarios.")
    public void elSistemaDeberaMostrarLaPaginaDeUsuarios() {
        theActorInTheSpotlight().should(seeThat(LoginResult.message(), equalTo("Welcome Tony")));

    }

    @When("dejo el usuario en blanco, escribo cualquier password y pulso submit")
    public void dejoElUsuarioEnBlancoEscriboCualquierPasswordYPulsoSubmit() {
        theActorInTheSpotlight().attemptsTo(HacerLogin.conLosDatos(usuarioVacioYPasswordCualquiera));
    }

    @Then("el sistema debera mostrar mensaje de error indicando que el usuario no debe ser vacio")
    public void elSistemaDeberaMostrarMensajeDeErrorIndicandoQueElUsuarioNoDebeSerVacio() {
        theActorInTheSpotlight().should(seeThat(LoginResult.message(), equalTo("Username cannot be empty")));

    }

    @When("dejo el password en blanco, escribo cualquier usuario y pulso submit")
    public void dejoElPasswordEnBlancoEscriboCualquierUsuarioYPulsoSubmit() {
        theActorInTheSpotlight().attemptsTo(HacerLogin.conLosDatos(usuarioCualquieraYPasswordVacio));
    }

    @Then("el sistema debera mostrar mensaje de error indicando que el password no debe ser vacio")
    public void elSistemaDeberaMostrarMensajeDeErrorIndicandoQueElPasswordNoDebeSerVacio() {
        theActorInTheSpotlight().should(seeThat(LoginResult.message(), equalTo("Password cannot be empty")));
    }

}
