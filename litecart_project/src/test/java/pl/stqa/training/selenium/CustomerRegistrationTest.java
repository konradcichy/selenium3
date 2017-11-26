package pl.stqa.training.selenium;

import org.testng.annotations.Test;
import pl.stqa.training.selenium.appmanager.CustomerData;

/**
 * Created by Konrad on 26/11/2017.
 */
public class CustomerRegistrationTest extends TestBase {


  @Test
  public void test() throws InterruptedException {

    app.goTo().mainPage();
    app.customer().openRegistrationPage(4);
    app.customer().fillCustomerForm(new CustomerData
            (
                    app.generators().getRandomAlphanumericString(10),
                    "IT CONSULTING",
                    "Mark",
                    "Vieira",
                    "Warsaw",
                    "Cracov",
                    "123234",
                    "Berlin",
                    "Russian Federation",
                    "asday",
                    "email",
                    "1234",
                    "usome",
                    "some"));


  }


}
