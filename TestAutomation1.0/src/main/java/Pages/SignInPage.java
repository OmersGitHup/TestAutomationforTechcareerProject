package Pages;

import Base.BaseLibrary;
import Base.BaseTest;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SignInPage extends BaseLibrary {

    @Step("Going SignIn Page")
    public SignInPage goingSignIn() throws InterruptedException{
        sleep(2000);
        webDriver.findElement(By.cssSelector("body > div.o-home > div > div.o-modal.genderPopup > div > div.o-modal__header > button > svg")).click();
        webDriver.findElement(By.cssSelector("body > header > div > div > div.col.col-xl-3.d-flex.justify-content-end > div > a.o-header__userInfo--item.bwi-account-o.-customer > svg")).click();
        return this;
    }

    @Step("Filling Valid Mail Address")
    public SignInPage fillEmail(String email) throws InterruptedException{
        webDriver.findElement(By.id("customerEmail")).sendKeys(email);
        return this;
    }
    @Step("Filling Valid Password Address")
    public SignInPage fillPassword(String password) throws InterruptedException{
        webDriver.findElement(By.id("password")).sendKeys(password);
        return this;
    }
    @Step("Click SignIn Button")
    public SignInPage clickSignIn() throws InterruptedException{
        webDriver.findElement(By.id("loginBtn")).click();
        return this;
    }
    @Step("Invalid SignIn Information Error")
    public SignInPage errorSignIn() throws InterruptedException{
        sleep(900);
        String value=webDriver.findElement(By.xpath("//*[@id=\"notifyMessage\"]")).getText();

        Assert.assertEquals("Please check your information and try again.",value);
        return this;
    }
    @Step("SignIn Empty Blank Control")
    public SignInPage errorEmptyBlank(String selector) throws InterruptedException {
        sleep(900);
        String value = webDriver.findElement(By.cssSelector(selector)).getText();

        Assert.assertEquals("This field cannot be left blank!", value);
        return this;
    }

    @Step("SignIn Empty Blank Control")
    public SignInPage errorInvalidEmail() throws InterruptedException {
        sleep(900);
        String value = webDriver.findElement(By.cssSelector("#loginForm > div:nth-child(1) > div > span.-errorMessage")).getText();

        Assert.assertEquals("Must be a valid email", value);
        return this;
    }


}
