package Pages;

import Base.BaseLibrary;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPages extends BaseLibrary{

    @Step("Accept Cookies if it Shown")
    public MainPages acceptCookies() throws InterruptedException{
        sleep(2000);
        WebElement element = webDriver.findElement(By.xpath("//*[@id=\"onetrust-banner-sdk\"]/div/div"));
        if (element.isDisplayed())
            webDriver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
        return this;
    }


}
