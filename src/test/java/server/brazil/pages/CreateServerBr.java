package server.brazil.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateServerBr extends PageObject {

    public void enterUser(String user) {
        findBy("#exampleInputEmail1").type(user);
    }

    public void enterPwd() {
        findBy("#exampleInputPassword1").type("123br");
    }

    public void clickCaptcha() {
        waitForCondition().
                until(ExpectedConditions.
                frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
        findBy(".rc-anchor-content").click();
        getDriver().switchTo().defaultContent();
    }

    public void buttonCreate() {
        findBy("//button[@type='submit']").click();
    }

    public String validateAccountCreate() {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView()", findBy("//h2[contains(.,'Create Premium VPN Account')]"));
        System.out.println("DETAILS ACCOUNT:::" + findBy("//div[starts-with(@class, 'alert') and contains(.,'Account has been successfully created !')]").getText());
        return findBy("//div[starts-with(@class, 'alert') and contains(.,'Account has been successfully created !')]").getText();
    }
}
