package co.com.services.Weelo.StepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.util.EnvironmentVariables;

import static jxl.biff.FormatRecord.logger;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class WeeloStepDefinitions {

    private EnvironmentVariables environmentVariables;




    private Actor TheCandidate= Actor.named("Candidate");

    @When("^send a request$")
    public void sendARequest() {

        TheCandidate.whoCan(CallAnApi.at(environmentVariables.getProperty("UrlBase")));

        TheCandidate.attemptsTo(
                Post.to("/post").with(request -> request.header("Content-Type", "application/json")
                        .body("{\"name\": \"Juan Pablo\",\"email\": \"jpablo-na993@hotmail.com\",\"phone\":\"3152875280\"}")
                )
        );

        String code = SerenityRest.lastResponse().jsonPath().get("url");
        logger.info(code);



    }

    @Then("^validate status code 200 and the information$")
    public void validateStatusCode200AndTheInformation() {
        TheCandidate.should(
                seeThatResponse("Was successfully created",
                        response -> response.statusCode(200)
                                .body("url",equalTo("https://postman-echo.com/post"))

                )
        );
    }

    @When("^send a fail request$")
    public void sendAFailRequest() {
        TheCandidate.whoCan(CallAnApi.at(environmentVariables.getProperty("UrlBase")));

        TheCandidate.attemptsTo(
                Post.to("").with(request -> request.header("Content-Type", "application/json")
                        .body("{\"name\": \"Juan Pablo\",\"email\": \"jpablo-na993@hotmail.com\",\"phone\":\"3152875280\"}")
                )
        );
    }

    @Then("^Validate code error$")
    public void validateCodeError() {
        TheCandidate.should(
                seeThatResponse("Not Found",
                        response -> response.statusCode(404)
                )
        );
    }
    @When("^send a get request$")
    public void sendAGetRequest() {

        String Value= "?value=33";
        TheCandidate.whoCan(CallAnApi.at(environmentVariables.getProperty("UrlBase")));
        TheCandidate.attemptsTo(
                Get.resource("/get"+Value)
        );
        String url = SerenityRest.lastResponse().jsonPath().get("url");
        logger.info(url);
    }


    @Then("^validate the url and status 200$")
    public void validateTheUrlAndStatus200() {
        TheCandidate.should(
                seeThatResponse("ok",
                        response -> response.statusCode(200)
                                .body("url",equalTo("https://postman-echo.com/get?value=33"))
                )
        );
    }

    @When("^Send request with two values$")
    public void sendRequestWithTwoValues() {

        String Value1 = "?value=33";
        String Value2 = "&value2=2";
        TheCandidate.whoCan(CallAnApi.at(environmentVariables.getProperty("UrlBase")));
        TheCandidate.attemptsTo(
                Get.resource("/get"+Value1+Value2)
        );
        String url = SerenityRest.lastResponse().jsonPath().get("url");
        logger.info(url);
    }

    @Then("^Validate status 200 and URL$")
    public void validateStatus200AndURL() {
        TheCandidate.should(
                seeThatResponse("ok",
                        response -> response.statusCode(200)
                                .body("url",equalTo("https://postman-echo.com/get?value=33&value2=2"))
                )
        );

    }

}
