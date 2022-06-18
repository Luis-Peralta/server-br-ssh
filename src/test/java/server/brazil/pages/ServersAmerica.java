package server.brazil.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ServersAmerica extends PageObject {


    @FindBy(xpath = "//button[contains(text(),'Select VPN Brazil')]")
    WebElementFacade selectBrazilSv;

    public void selectSvBr() {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView()",selectBrazilSv);
        selectBrazilSv.click();
    }

}
