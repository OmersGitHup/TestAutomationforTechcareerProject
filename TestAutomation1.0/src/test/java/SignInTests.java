import Base.BaseLibrary;
import Base.BaseTest;
import Pages.SignInPage;
import org.testng.annotations.Test;

public class SignInTests extends BaseTest {

    SignInPage signInPage=new SignInPage();

    @Test(description = "Sign In with NonUser Information")
    public  void signInWithNonUser() throws InterruptedException{
        signInPage
                .goingSignIn()
                .fillEmail(email)
                .fillPassword(password)
                .clickSignIn()
                .errorSignIn()
        ;
    }
    @Test(description = "Sign In with Empty Email ")
    public  void signInEmptyEmail() throws InterruptedException{
        signInPage
                .goingSignIn()
                .fillEmail("")
                .fillPassword(password)
                .clickSignIn()
                .errorEmptyBlank("#loginForm > div:nth-child(1) > div > span.-errorMessage")
        ;
    }
    @Test(description = "Sign In with Empty Password ")
    public  void signInEmptyPassword() throws InterruptedException{
        signInPage
                .goingSignIn()
                .fillEmail(email)
                .fillPassword("")
                .clickSignIn()
                .errorEmptyBlank("#loginForm > div:nth-child(2) > div > span.-errorMessage")
        ;
    }
    @Test(description = "Empty Blanks Check ")
    public  void signInWithNull() throws InterruptedException{
        signInPage
                .goingSignIn()
                .fillEmail("")
                .fillPassword("")
                .clickSignIn()
                .errorEmptyBlank("#loginForm > div:nth-child(2) > div > span.-errorMessage")
                .errorEmptyBlank("#loginForm > div:nth-child(1) > div > span.-errorMessage")
        ;
    }
    @Test(description = "Sign In with Invalid Email ")
    public  void signInInvalidEmail() throws InterruptedException{
        signInPage
                .goingSignIn()
                .fillEmail("kle")
                .fillPassword(password)
                .clickSignIn()
                .errorInvalidEmail()
        ;
    }

}
