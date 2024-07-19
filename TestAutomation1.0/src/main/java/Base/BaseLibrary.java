package Base;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class BaseLibrary extends Data {
    public static WebDriver webDriver;

    public void sleep(int time) throws InterruptedException {
        Thread.sleep(time);
    }
//    @Attachment(value = "Screenshot", type = "image/png")
//    public byte[] screenshot() {
//        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
//    }

//    public void switchTab()
//    {
//        ArrayList<String> list = new ArrayList<>(webDriver.getWindowHandles());
//        webDriver.switchTo().window(list.get(1));
//    }
}