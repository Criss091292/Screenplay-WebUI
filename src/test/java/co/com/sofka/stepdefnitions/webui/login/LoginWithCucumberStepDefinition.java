package co.com.sofka.stepdefnitions.webui.login;

import co.com.sofka.models.LoginPageModel;
import co.com.sofka.tasks.Abrir;
import co.com.sofka.tasks.HacerLogin;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class LoginWithCucumberStepDefinition {
    LoginPageModel loginPageModel;

    @Before
    public void configuracionInicial(){
        setTheStage(new OnlineCast());
        loginPageModel = new LoginPageModel();
        loginPageModel.setUsername("admin");
        loginPageModel.setPassword("admin123");

    }

    @Given("el usuario esta en la pagina de login sin haberse autenticado")
    public void elUsuarioEstaEnLaPaginaDeLoginSinHaberseAutenticado() {
        theActorCalled("Luis").wasAbleTo(Abrir.LoginPage());
    }

    @When("diligencia los datos correctos")
    public void diligenciaLosDatosCorrectos() {

        theActorInTheSpotlight().attemptsTo(HacerLogin.conLosDatos(loginPageModel));
    }

    @Then("deberia visualizar la pagina de usuarios del sistema")
    public void deberiaVisualizarLaPaginaDeUsuariosDelSistema() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("el usuario realiza la peticion")
    public void elUsuarioRealizaLaPeticion() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("deberia visualizar un mensaje de credenciales invalidas")
    public void deberiaVisualizarUnMensajeDeCredencialesInvalidas() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
