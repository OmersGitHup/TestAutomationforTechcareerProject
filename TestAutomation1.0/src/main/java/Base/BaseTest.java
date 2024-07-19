package Base;


import Pages.MainPages;
import Pages.SignUpPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BaseLibrary {
   SignUpPage signUpPage=new SignUpPage();

   @BeforeMethod
    public void setDriver() throws InterruptedException{
       webDriver= new ChromeDriver();
       webDriver.get("https://www.beymen.com/en");
       signUpPage.goingSignUp();

   }

   @AfterMethod
   public void closeApp() {
      webDriver.quit();
   }
}
