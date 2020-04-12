package ebay.automation.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class Filter implements Task {

    private final String FILTRO1;
    private final String FILTRO2;

    public Filter(String FILTRO1, String FILTRO2) {
        this.FILTRO1 = FILTRO1;
        this.FILTRO2 = FILTRO2;
    }

    public static FilterBuilder byState(String filtro1){
        return new FilterBuilder(filtro1);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the("//span[@class='cbx x-refine__multi-select-cbx' and text()='"+FILTRO1+"']",isClickable()),
                Click.on("//span[@class='cbx x-refine__multi-select-cbx' and text()='"+FILTRO1+"']"),
                WaitUntil.the("//span[@class='cbx x-refine__multi-select-cbx' and text()='"+FILTRO2+"']",isClickable()),
                Click.on("//span[@class='cbx x-refine__multi-select-cbx' and text()='"+FILTRO2+"']")
        );
    }

    public static class FilterBuilder{
        private final String FILTRO1;

        public FilterBuilder(String filtro1) {
            this.FILTRO1 = filtro1;
        }

        public Filter andByLocation(String filtro2){
            return instrumented(Filter.class,this.FILTRO1,filtro2);
        }
    }
}
