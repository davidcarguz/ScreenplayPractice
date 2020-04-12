package ebay.automation.screenplay.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class Navigate {
    public static Performable toEbayMainPage(){
        return Task.where("Navegar a pagina principal Ebay", Open.browserOn().the(EbayMainPage.class));
    }

}
