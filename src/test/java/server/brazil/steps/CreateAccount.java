package server.brazil.steps;


import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;
import server.brazil.pages.CreateServerBr;
import server.brazil.pages.MainPage;
import server.brazil.pages.ServersAmerica;
import server.brazil.pages.ServersBrazil;

import static org.junit.Assert.assertEquals;

public class CreateAccount {

    @Steps
    MainPage mainPage = new MainPage();
    @Steps
    ServersBrazil serversBrazil;
    @Steps
    CreateServerBr createServerBr;
    @Steps
    ServersAmerica serversAmerica;

    @Given("^user is on main page$")
    public void openMainPage() {
        mainPage.open();
    }

    @And("^Select America server$")
    public void selectServerRegion() {
        mainPage.selectAmericaSv();
        mainPage.closePopUp();
    }

    @And("^Select Brazil server$")
    public void selectBrServer(){
        serversAmerica.selectSvBr();
    }

    @When("^user choose one server: (.+)$")
    public void chooseServer(int nServer) {
        serversBrazil.selectServer(nServer);
    }

    @Then("^user create an account with username: (.+) and pwd automatically$")
    public void createSsh(String username) {
        createServerBr.enterUser(username);
        createServerBr.enterPwd();
        createServerBr.clickCaptcha();
        createServerBr.buttonCreate();
    }

    @And("^validate account: (.+)$")
    public void validateAccount(String AccSuccess) {
        assertEquals(AccSuccess, createServerBr.validateAccountCreate());
    }

}
