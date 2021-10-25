package co.com.sofka.stepdefnitions.webui.systemusers;

import co.com.sofka.models.LoginPageModel;
import co.com.sofka.models.SystemUsersPageModel;
import co.com.sofka.questions.SystemUsersTable;
import co.com.sofka.questions.WelcomeMessage;
import co.com.sofka.tasks.Abrir;
import co.com.sofka.tasks.Buscar;
import co.com.sofka.tasks.HacerLogin;
import co.com.sofka.util.UserRole;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.containsString;

public class ViewUsersFilteredByRoleStepDefinition {
    LoginPageModel datosCorrectos;
    SystemUsersPageModel rolEspecifico;
    SystemUsersPageModel todosLosRoles;
    private static String USUARIO_CORRECTO = "Admin";
    private static String PASSWORD_CORRECTO = "admin123";
    @Before
    public void configuracionInicial(){
        setTheStage(new OnlineCast());
        datosCorrectos = new LoginPageModel();
        datosCorrectos.setUsername(USUARIO_CORRECTO);
        datosCorrectos.setPassword(PASSWORD_CORRECTO);
        rolEspecifico = new SystemUsersPageModel();
        rolEspecifico.setUserRole(UserRole.ESS);
        todosLosRoles = new SystemUsersPageModel();
        todosLosRoles.setUserRole(UserRole.All);

    }
    @Given("ingrese como usuario autenticado a la pagina de visualizacion de usuarios del sistema del aplicativo y en bd existen solo los roles Admin y ESS")
    public void ingrese_como_usuario_autenticado_a_la_pagina_de_visualizacion_de_usuarios_del_sistema_del_aplicativo_y_en_bd_existen_solo_los_roles_Admin_y_ESS() {
        theActorCalled("Cristian").wasAbleTo(Abrir.LoginPage());
        theActorInTheSpotlight().attemptsTo(HacerLogin.conLosDatos(datosCorrectos));
    }

    @When("selecciono un rol especifico y pulso search")
    public void selecciono_un_rol_especifico_y_pulso_search() {
        theActorInTheSpotlight().attemptsTo(Buscar.usuariosConRol(rolEspecifico));
    }

    @Then("el sistema deberia solo mostrar los usuarios con el rol seleccionado")
    public void el_sistema_deberia_solo_mostrar_los_usuarios_con_el_rol_seleccionado() {
        theActorInTheSpotlight().should(seeThat(SystemUsersTable.hassAllRoles()));
    }

    @When("selecciono la opcion All y pulso search")
    public void selecciono_la_opcion_All_y_pulso_search() {
        theActorInTheSpotlight().attemptsTo(Buscar.usuariosConRol(todosLosRoles));
    }

    @Then("el sistema deberia solo mostrar usuarios con los roles existentes")
    public void el_sistema_deberia_solo_mostrar_usuarios_con_los_roles_existentes() {
        theActorInTheSpotlight().should(seeThat(SystemUsersTable.hasOnlyASpecificRole()));
    }
}
