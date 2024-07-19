package Pages;

import Base.BaseLibrary;
import Base.BaseTest;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends BaseLibrary {


    @Step("Going SignUp Panel")
    public SignUpPage goingSignUp() throws InterruptedException{
        sleep(2000);
        webDriver.findElement(By.cssSelector("body > div.o-home > div > div.o-modal.genderPopup > div > div.o-modal__header > button > svg")).click();
        webDriver.findElement(By.cssSelector("body > header > div > div > div.col.col-xl-3.d-flex.justify-content-end > div > a.o-header__userInfo--item.bwi-account-o.-customer > svg")).click();
        sleep(2000);
        webDriver.findElement(By.className("a-borderButton")).click();
        sleep(2000);
        return this;
    }
    @Step("Fill Name Blank")
    public SignUpPage fillName(String name) {
        webDriver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(name);
        return this;
    }
   @Step("Accept Cookies if it Shown")
    public SignUpPage acceptCookies(){
       WebElement element = webDriver.findElement(By.xpath("//*[@id=\"onetrust-banner-sdk\"]/div/div"));
       if (element.isDisplayed())
           webDriver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
       return this;
   }
    @Step("Accept Notification if it Shown")
    public SignUpPage acceptNotification(){
        WebElement element = webDriver.findElement(By.xpath("//*[@id=\"dengage-push-perm-slide\"]/div/div[2]"));
        if (element.isDisplayed())
            webDriver.findElement(By.xpath("//*[@id=\"dengage-push-perm-slide\"]/div/div[2]/div[2]/button[2]")).click();
        return this;
    }
    @Step("Fill Surname Blank")
    public SignUpPage fillSurname(String surname) {
        webDriver.findElement(By.xpath("//*[@id=\"surname\"]")).sendKeys(surname);
        return this;
    }
    @Step("Fill Surname Blank")
    public SignUpPage fillEmail(String email) {
        webDriver.findElement(By.xpath("//*[@id=\"customerEmail\"]")).sendKeys(email);
        return this;
    }
    @Step("Fill Phone Number")
    public SignUpPage fillPhoneNumber(String phoneNumber) {
        webDriver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys(phoneNumber);
        return this;
    }
    @Step("Fill Birth Date")
    public SignUpPage fillBirthDate(String day,String month,String year) {
        WebElement dropdownElement=webDriver.findElement(By.xpath("//*[@id=\"day\"]"));
        Select dropdown=new Select(dropdownElement);
        dropdown.selectByValue(day);
        WebElement dropdownElement2=webDriver.findElement(By.xpath("//*[@id=\"month\"]"));
        Select dropdown2=new Select(dropdownElement2);
        dropdown2.selectByValue(month);
        WebElement dropdownElement3=webDriver.findElement(By.xpath("//*[@id=\"year\"]"));
        Select dropdown3=new Select(dropdownElement3);
        dropdown3.selectByValue(year);
        return this;
    }
    @Step("Fill Phone Number")
    public SignUpPage fillPassword(String password) {
        webDriver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
        return this;
    }
    @Step("Clicking Agreement Button")
    public SignUpPage agreementButton() {

        WebElement checkbox=webDriver.findElement(By.cssSelector("#registerForm > div:nth-child(3) > div > label"));

        int w=checkbox.getSize().getWidth();
        int h=checkbox.getSize().getHeight();
        int xOffset=0;
        int yOffset = h / 2;
        Actions actions = new Actions(webDriver);
        actions.moveToElement(checkbox, xOffset, yOffset).click().perform();
        return this;
    }
    @Step("Clicking Register Button")
    public SignUpPage registerClick() {
        webDriver.findElement(By.id("registerbtn")).click();
        return this;
    }
    @Step("Passing Allow Button")
    public SignUpPage passingAllow() {
        webDriver.findElement(By.id("yesAllowBtn")).click();
        return this;
    }
    @Step("Confirm Message Check")
    public SignUpPage confirmCheck() throws InterruptedException{
        sleep(3000);
        String value=webDriver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/div/div/div[2]/div/div/div/ul/li[1]/span[2]")).getText();

        Assert.assertEquals("PHONE NUMBER VERIFICATION",value);
        return this;
    }
    @Step("Empty Blank Error Message Check")
    public SignUpPage errorCheck(String xpath) throws InterruptedException{
        sleep(2000);
        String value=webDriver.findElement(By.xpath(xpath)).getText();

        Assert.assertEquals(erroreMessageEmptyBlank,value);
        webDriver.quit();
        return this;
    }
    @Step("Short N/A Valid Blank Error Message Check")
    public SignUpPage shortorNumericErrorCheck(String xpath) throws InterruptedException{
        sleep(2000);
        String value=webDriver.findElement(By.xpath(xpath)).getText();

        Assert.assertEquals(errorMessageInvalidValue,value);
        webDriver.quit();
        return this;
    }

    @Step("Short Password Chech")
    public SignUpPage shortPasswordErrorMessageCheck(String xpath) throws InterruptedException{
        sleep(2000);
        String value=webDriver.findElement(By.xpath(xpath)).getText();

        Assert.assertEquals(shortPasswordErrorMessage,value);
        webDriver.quit();
        return this;
    }










}
