package server.brazil.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DefaultUrl("https://www.tcpvpn.com")
public class MainPage extends PageObject {

    @FindBy(xpath = "//a[contains(text(),'Select VPN America')]")
    WebElementFacade selectSvAmerica;

    public void selectAmericaSv() {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView()", selectSvAmerica);
        selectSvAmerica.click();
    }

    public void searchElementsPopUp() {
        if (findBy("#dismiss-button").isPresent()) {
            System.out.println("DISMISBUTTON STATUS IN 1.ASWIFT_5:::::" + findBy("#dismiss-button").isPresent());
            findBy("#dismiss-button").waitUntilClickable().click();
        } else {
            waitForCondition().until(ExpectedConditions.
                    frameToBeAvailableAndSwitchToIt(By.cssSelector("#ad_iframe")));
            System.out.println("DISMISBUTTON STATUS IN 2.AD_IFRAME:::::" + findBy("#dismiss-button").isPresent());
            findBy("#dismiss-button").waitUntilClickable().click();
        }
    }

    public void closePopUp() {
        if (isElementVisible(By.cssSelector("#aswift_5"))){
            System.out.println("ASWIFT_5 IS PRESENT!!!!!!!!!!!!!!!!");
            waitForCondition().until(ExpectedConditions.
                    frameToBeAvailableAndSwitchToIt(By.cssSelector("#aswift_5")));
            searchElementsPopUp();

        }
//        else if (isElementVisible(By.cssSelector("#aswift_6"))) {
//            System.out.println("ASWIFT_6 IS PRESENT!!!!!!!!!!!!!!!!");
//            waitForCondition().until(ExpectedConditions.
//                    frameToBeAvailableAndSwitchToIt(By.cssSelector("#aswift_6")));
//            searchElementsPopUp();
//        }
    }
}
