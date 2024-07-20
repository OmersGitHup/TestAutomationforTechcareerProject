package Pages;

import Base.BaseLibrary;
import Base.BaseTest;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class OrderTrackingPage extends BaseLibrary {
    @Step("Going Order Tracking Page")
    public OrderTrackingPage goingTrackOrder() throws InterruptedException{
        sleep(1000);
        webDriver.findElement(By.xpath("/html/body/div[1]/div/a[1]")).click();
        return this;
    }
    @Step("Filling Mail Address")
    public OrderTrackingPage fillEmail(String email ) throws InterruptedException{
        sleep(1000);
        webDriver.findElement(By.xpath("//*[@id=\"customerEmail\"]")).sendKeys(email);
        return this;
    }
    @Step("Filling Order Number")
    public OrderTrackingPage fillOrderNumber(String orderNo ) throws InterruptedException{
        webDriver.findElement(By.xpath("//*[@id=\"code\"]")).sendKeys(orderNo);
        return this;
    }
    @Step("Click Order Detail")
    public OrderTrackingPage clickOrderDetail( ) throws InterruptedException{
        webDriver.findElement(By.xpath("//*[@id=\"trackingBtn\"]")).click();
        return this;
    }
    @Step("Valid Mail Check")
    public OrderTrackingPage errorInvalidEmail() throws InterruptedException {
        sleep(900);
        String value = webDriver.findElement(By.cssSelector("#trackingForm > div:nth-child(1) > div > span")).getText();

        Assert.assertEquals("Must be a valid email", value);
        return this;
    }
    @Step("Could Not Found Check")
    public OrderTrackingPage errorCouldNotFound() throws InterruptedException {
        sleep(900);
        String value = webDriver.findElement(By.cssSelector("#notifyTitle")).getText();

        Assert.assertEquals("Verification Code Could Not Be Sent", value);
        return this;
    }
    //*[@id="trackingForm"]/div[1]/div/span
    @Step("Empty Email Check")
    public OrderTrackingPage nullEmailCheck() throws InterruptedException {
        sleep(2000);
        String value = webDriver.findElement(By.cssSelector("#trackingForm > div:nth-child(1) > div > span")).getText();

        Assert.assertEquals("This field cannot be left blank!", value);
        return this;
    }
    @Step("Empty Order No Check")
    public OrderTrackingPage nullOrderNoCheck() throws InterruptedException {
        sleep(1000);
        String value = webDriver.findElement(By.cssSelector("#trackingForm > div:nth-child(2) > div > span")).getText();

        Assert.assertEquals("This field cannot be left blank!", value);
        return this;
    }
}
