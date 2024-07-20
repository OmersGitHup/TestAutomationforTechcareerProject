package Pages;

import Base.BaseLibrary;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class MainPages extends BaseLibrary{

    @Step("Accept Cookies and Selections if Shown")
    public MainPages acceptCookies() throws InterruptedException {
        sleep(2000);
        try {
            WebElement cookieBanner = webDriver.findElement(By.xpath("//*[@id=\"onetrust-banner-sdk\"]/div/div"));
            if (cookieBanner.isDisplayed()) {
                webDriver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
            }
        } catch (NoSuchElementException e) {
            // Cookie banner is not present
            // Log the exception or handle it if needed
        }

        try {
            webDriver.findElement(By.cssSelector("body > div.o-home > div > div.o-modal.genderPopup > div > div.o-modal__header > button > svg")).click();
        } catch (NoSuchElementException e) {
            // Gender popup is not present
            // Log the exception or handle it if needed
        }

        return this;
    }




}
