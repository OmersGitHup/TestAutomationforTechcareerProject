package Base;


import Pages.MainPages;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BaseLibrary {

   MainPages mainPages=new MainPages();
   @BeforeMethod
    public void setDriver() throws InterruptedException{
       webDriver= new ChromeDriver();
       webDriver.get("https://www.beymen.com/en");
       mainPages.acceptCookies();
   }


   @AfterMethod
   public void closeApp() {
      webDriver.quit();
   }
}
