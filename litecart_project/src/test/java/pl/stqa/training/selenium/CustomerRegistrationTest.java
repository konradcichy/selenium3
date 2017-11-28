package pl.stqa.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pl.stqa.training.selenium.appmanager.CustomerData;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by Konrad on 26/11/2017.
 */
public class CustomerRegistrationTest extends TestBase {


  @Test
  public void customerRegistrationTest() throws InterruptedException {

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
                    "email" + app.generators().getRandomAlphanumericString(5) + "@email.email",
                    "1234",
                    "some",
                    "some"));

      app.customer().submitRegistration();
      boolean registrationText = app.customer().RegistrationText();
      assertThat(registrationText, equalTo(true));
      app.login().logout();
      app.login().logOutConfirmationText();






  }


}
