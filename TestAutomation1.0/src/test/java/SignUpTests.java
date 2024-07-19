import Base.BaseTest;
import Pages.MainPages;
import Pages.SignUpPage;

import org.testng.annotations.Test;

public class SignUpTests extends BaseTest {
    SignUpPage signUpPage=new SignUpPage();


    @Test(description = "Sign In with Valid Information")
    public  void signUpSuccsessful() throws InterruptedException{
        sleep(3000);
        signUpPage
                .goingSignUp()
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

    }
    @Test(description = "Sign In with Null Name ")
    public  void nullName() throws InterruptedException{
        signUpPage
                .goingSignUp()
                .fillName("")
                .fillSurname(surname)
                .fillEmail(email)
                .fillPhoneNumber(phoneNumber)
                .fillPassword(password)
                .fillBirthDate("04","03","1999")
                .agreementButton()
                .registerClick()
                .errorCheck("//*[@id=\"registerForm\"]/div[1]/div[1]/span[2]");

    }
    @Test(description = "Sign In with Null Surname ")
    public  void nullSurname() throws InterruptedException{
        signUpPage
                .goingSignUp()
                .fillName(name)
                .fillSurname("")
                .fillEmail(email)
                .fillPhoneNumber(phoneNumber)
                .fillPassword(password)
                .fillBirthDate("04","03","1999")
                .agreementButton()
                .registerClick()
                .errorCheck("//*[@id=\"registerForm\"]/div[1]/div[2]/span[2]");

    }
    @Test(description = "Sign In with Null Email ")
    public  void nullEmail() throws InterruptedException{
        signUpPage
                .goingSignUp()
                .fillName(name)
                .fillSurname(surname)
                .fillEmail("")
                .fillPhoneNumber(phoneNumber)
                .fillPassword(password)
                .fillBirthDate("04","03","1999")
                .agreementButton()
                .registerClick()
                .errorCheck("//*[@id=\"js-registerScroll\"]/span[2]");

    }
    @Test(description = "Sign In with Null Password ")
    public  void nullPassword() throws InterruptedException{
        signUpPage
                .goingSignUp()
                .fillName(name)
                .fillSurname(surname)
                .fillEmail(email)
                .fillPhoneNumber(phoneNumber)
                .fillPassword("21")
                .fillBirthDate("04","03","1999")
                .agreementButton()
                .registerClick()
                .shortPasswordErrorMessageCheck("//*[@id=\"registerForm\"]/div[1]/div[7]/span[2]");

    }
    @Test(description = "Sign In with Short Password ")
    public  void shortPassword() throws InterruptedException{
        signUpPage
                .goingSignUp()
                .fillName(name)
                .fillSurname(surname)
                .fillEmail(email)
                .fillPhoneNumber(phoneNumber)
                .fillPassword("")
                .fillBirthDate("04","03","1999")
                .agreementButton()
                .registerClick()
                .errorCheck("//*[@id=\"registerForm\"]/div[1]/div[7]/span[2]");

    }
    @Test(description = "Sign In with Just Numeric Password ")
    public  void numericPassword() throws InterruptedException{
        signUpPage
                .goingSignUp()
                .fillName(name)
                .fillSurname(surname)
                .fillEmail(email)
                .fillPhoneNumber(phoneNumber)
                .fillPassword("12345667890")
                .fillBirthDate("04","03","1999")
                .agreementButton()
                .registerClick()
                .shortorNumericErrorCheck("//*[@id=\"registerForm\"]/div[1]/div[7]/span[2]");

    }
    @Test(description = "Sign In with Unclicking Permission ")
    public  void noPermissionAccepting() throws InterruptedException{
        sleep(1000);
        signUpPage
                .goingSignUp()
                .fillName(name)
                .fillSurname(surname)
                .fillEmail(email)
                .fillPhoneNumber(phoneNumber)
                .fillPassword(password)
                .fillBirthDate("04","03","1999")
                .registerClick()
                .errorCheck("//*[@id=\"registerForm\"]/div[3]/div/span");

    }


}
