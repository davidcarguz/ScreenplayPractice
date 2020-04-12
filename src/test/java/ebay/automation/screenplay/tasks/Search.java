package ebay.automation.screenplay.tasks;

import ebay.automation.screenplay.user_interface.EbayUserInterface;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class Search {

    public static Performable forItem(String item) {
        return Task.where("Buscamos por el item en ebay",
                WaitUntil.the(EbayUserInterface.EDT_BUSCAR,isEnabled()),
                Enter.theValue(item).into(EbayUserInterface.EDT_BUSCAR).thenHit(Keys.ENTER)
                );
    }

}
