package co.com.sofka.runners.webui;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/webui/systemusers/viewUsersFilteredByRole.feature"},
        glue = {"co.com.sofka.stepdefnitions.webui.systemusers"})
public class ViewUsersFilteredByRoleCucumberTest {
}
