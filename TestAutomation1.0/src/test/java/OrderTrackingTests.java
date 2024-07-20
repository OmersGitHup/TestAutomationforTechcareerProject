import Base.BaseTest;
import Pages.OrderTrackingPage;
import Pages.SignInPage;
import org.testng.annotations.Test;



public class OrderTrackingTests extends BaseTest {
    OrderTrackingPage orderTrackingPage = new OrderTrackingPage();

    @Test(description = "Invalid Email Test on Order Tracking Page without SignIn")
    public void orderTrackingInvalidMail() throws InterruptedException {

        orderTrackingPage
                .goingTrackOrder()
                .fillEmail("asd")
                .fillOrderNumber(orderNoforTracking)
                .clickOrderDetail()
                .errorInvalidEmail();
    }
    @Test(description = "Empty Blank on Order Tracking ")
    public void nullBlank() throws InterruptedException {

        orderTrackingPage
                .goingTrackOrder()
                .fillEmail("")
                .fillOrderNumber("")
                .clickOrderDetail()
                .nullEmailCheck()
                .nullOrderNoCheck();

        ;
    }
    }