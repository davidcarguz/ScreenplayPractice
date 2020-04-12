package ebay.automation.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class ValidateThatTheResult implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).findBy("(//h3[@class='s-item__title'])[1]").getText();
    }

    public static Question<String> isRelatedToTheSearch(){
        return new ValidateThatTheResult();
    }
}
