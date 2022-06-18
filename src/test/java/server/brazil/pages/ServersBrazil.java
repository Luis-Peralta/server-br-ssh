package server.brazil.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

import java.time.Duration;


public class ServersBrazil extends PageObject {

    private static final String SERVER = "//div[@class='col-md-4'][{0}]//button[contains(.,'Create Username and Password')]";

    public void selectServer(int nServer) {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView()", findBy(SERVER,nServer));
            findBy(SERVER,nServer).click();
    }


}
