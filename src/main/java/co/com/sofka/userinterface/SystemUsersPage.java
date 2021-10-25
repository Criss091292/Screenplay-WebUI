package co.com.sofka.userinterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers")
public class SystemUsersPage extends PageObject {
        public static final Target WELCOME_MESSAGE = Target.the("Welcome message")
                .located(By.id("welcome"));
        public static final Target USERNAME = Target.the("Username")
                .located(By.id("searchSystemUser_userName"));
        public static final Target USER_ROLE = Target.the("User Role")
                .located(By.id("searchSystemUser_userType"));
        public static final Target EMPLOYEE_NAME = Target.the("Employee Name")
                .located(By.id("searchSystemUser_employeeName_empName"));
        public static final Target STATUS = Target.the("Status")
                .located(By.id("searchSystemUser_status"));
        public static final Target SEARCH_BTN = Target.the("Search")
                .located(By.id("searchBtn"));
        public static final Target RESULT_TABLE = Target.the("Table")
                .located(By.id("resultTable"));
}
