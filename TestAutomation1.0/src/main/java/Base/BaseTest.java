package Base;


import Pages.MainPages;
import Pages.SignUpPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BaseLibrary {


   @BeforeMethod
    public void setDriver() throws InterruptedException{
       webDriver= new ChromeDriver();
       webDriver.get("https://www.beymen.com/en");
   }
   @AfterMethod
   public void closeApp() {
      webDriver.quit();
   }
}
