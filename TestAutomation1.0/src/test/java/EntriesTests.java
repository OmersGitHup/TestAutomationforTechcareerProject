import Base.BaseTest;
import Pages.MainPages;
import Pages.SignUpPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;

import java.util.List;

public class EntriesTests extends BaseTest {
    SignUpPage signUpPage=new SignUpPage();
    BaseTest baseTest=new BaseTest();

    @Test
    public  void signUpSuccsessful() throws InterruptedException{
        baseTest.setDriver();
        signUpPage
                .fillName(name)
                .fillSurname(surname)
                .fillEmail(email)
                .fillPhoneNumber(phoneNumber)
                .fillPassword(password)
                .fillBirthDate("04","03","1999")
                .agreementButton()
                .registerClick()
                .passingAllow()
                .confirmCheck();
        webDriver.quit();
    }
    @Test
    public  void nullName() throws InterruptedException{
        baseTest.setDriver();
        signUpPage
                .fillName("")
                .fillSurname(surname)
                .fillEmail(email)
                .fillPhoneNumber(phoneNumber)
                .fillPassword(password)
                .fillBirthDate("04","03","1999")
                .agreementButton()
                .registerClick()
                .errorCheck("//*[@id=\"registerForm\"]/div[1]/div[1]/span[2]");
        webDriver.quit();
    }
    @Test
    public  void nullSurname() throws InterruptedException{
        baseTest.setDriver();
        signUpPage
                .fillName(name)
                .fillSurname("")
                .fillEmail(email)
                .fillPhoneNumber(phoneNumber)
                .fillPassword(password)
                .fillBirthDate("04","03","1999")
                .agreementButton()
                .registerClick()
                .errorCheck("//*[@id=\"registerForm\"]/div[1]/div[2]/span[2]");

        webDriver.quit();
    }
    @Test
    public  void nullEmail() throws InterruptedException{
        baseTest.setDriver();
        signUpPage
                .fillName(name)
                .fillSurname(surname)
                .fillEmail("")
                .fillPhoneNumber(phoneNumber)
                .fillPassword(password)
                .fillBirthDate("04","03","1999")
                .agreementButton()
                .registerClick()
                .errorCheck("//*[@id=\"js-registerScroll\"]/span[2]");
        webDriver.quit();
    }
    @Test
    public  void nullPassword() throws InterruptedException{
        baseTest.setDriver();
        signUpPage
                .fillName(name)
                .fillSurname(surname)
                .fillEmail(email)
                .fillPhoneNumber(phoneNumber)
                .fillPassword("21")
                .fillBirthDate("04","03","1999")
                .agreementButton()
                .registerClick()
                .shortPasswordErrorMessageCheck("//*[@id=\"registerForm\"]/div[1]/div[7]/span[2]");
        webDriver.quit();
    }
    @Test
    public  void shortPassword() throws InterruptedException{
        baseTest.setDriver();
        signUpPage
                .fillName(name)
                .fillSurname(surname)
                .fillEmail(email)
                .fillPhoneNumber(phoneNumber)
                .fillPassword("")
                .fillBirthDate("04","03","1999")
                .agreementButton()
                .registerClick()
                .errorCheck("//*[@id=\"registerForm\"]/div[1]/div[7]/span[2]");
        webDriver.quit();
    }
    @Test
    public  void numericPassword() throws InterruptedException{
        baseTest.setDriver();

        signUpPage
                .fillName(name)
                .fillSurname(surname)
                .fillEmail(email)
                .fillPhoneNumber(phoneNumber)
                .fillPassword("12345667890")
                .fillBirthDate("04","03","1999")
                .agreementButton()
                .registerClick()
                .shortorNumericErrorCheck("//*[@id=\"registerForm\"]/div[1]/div[7]/span[2]");

        webDriver.quit();
    }
    @Test
    public  void noPermissionAccepting() throws InterruptedException{
        baseTest.setDriver();

        signUpPage
                .fillName(name)
                .fillSurname(surname)
                .fillEmail(email)
                .fillPhoneNumber(phoneNumber)
                .fillPassword(password)
                .fillBirthDate("04","03","1999")
                .registerClick()
                .errorCheck("//*[@id=\"registerForm\"]/div[3]/div/span");
        webDriver.quit();
    }


}
