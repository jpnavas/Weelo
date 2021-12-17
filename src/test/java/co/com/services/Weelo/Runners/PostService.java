package co.com.services.Weelo.Runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/Features/Post.feature",
        glue = "co.com.services.Weelo.StepDefinitions",
        //tags = "@UrlFail",
        snippets = SnippetType.CAMELCASE)
public class PostService {

}
