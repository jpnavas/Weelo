package co.com.services.Weelo.Runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/Features/Get.feature",
        glue = "co.com.services.Weelo.StepDefinitions",
        tags = "@GetTwoValues",
        snippets = SnippetType.CAMELCASE)
public class GetServices {
}
