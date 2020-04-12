package ebay.automation.screenplay.step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ebay.automation.screenplay.questions.ValidateThatTheResult;
import ebay.automation.screenplay.tasks.Filter;
import ebay.automation.screenplay.tasks.Navigate;
import ebay.automation.screenplay.tasks.Search;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.StringContains.containsStringIgnoringCase;

public class EbayStepDefinitions {

    @Given("^(.*) ingresa a ebay$")
    public void davidIngresaAEbay(String actor) {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled(actor).wasAbleTo(Navigate.toEbayMainPage());
    }


    @When("^David busca por (.*)$")
    public void davidBuscaPorComputadores(String busqueda) {
        theActorInTheSpotlight().attemptsTo(
                Search.forItem(busqueda)
        );

    }

    @When("^David filtra por (.*) y (.*)$")
    public void davidFiltraPorNuevoYAmericaDelNorte(String filtro1, String filtro2) {
        theActorInTheSpotlight().attemptsTo(
                Filter.byState(filtro1).andByLocation(filtro2)
        );

    }

    @Then("^David valida los resultados$")
    public void davidValidaLosResultados() {

        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("los resultados deben estar relacionados con la busqueda", ValidateThatTheResult.isRelatedToTheSearch(),containsStringIgnoringCase("computadora")));
    }
}
