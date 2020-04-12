package ebay.automation.screenplay.user_interface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EbayUserInterface {

    public static final Target EDT_BUSCAR = Target.the("caja de busqueda pagina inicial").located(By.name("_nkw"));
}
