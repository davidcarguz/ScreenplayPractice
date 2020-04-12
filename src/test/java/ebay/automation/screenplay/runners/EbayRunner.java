package ebay.automation.screenplay.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features"
        ,glue = "ebay.automation.screenplay.step_definitions"
        ,tags = "@busqueda"
        ,snippets = SnippetType.CAMELCASE
)

public class EbayRunner {
}
