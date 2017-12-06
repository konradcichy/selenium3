package pl.stqa.training.selenium;

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
    String taxId = app.generators().getRandomAlphanumericString(10);
    String email = "email" + app.generators().getRandomAlphanumericString(5) + "@email.email";
    String password = app.generators().getRandomAlphanumericString(9);
    System.out.println(email + " " + password);


    app.customer().fillCustomerForm(new CustomerData
            (
                    taxId,
                    "IT CONSULTING",
                    "Mark",
                    "Vieira",
                    "Warsaw",
                    "Cracov",
                    "123234",
                    "Berlin",
                    "Russian Federation",
                    "asday",
                    email,
                    "1234",
                    password,
                    password));

    app.customer().submitRegistration();
    assertThat(app.customer().correctRegistrationText(), equalTo(true));
    app.login().logout();
    assertThat(app.customer().logOutConfirmationText(), equalTo(true));
    app.login().customerLogin(email, password);
    assertThat(app.customer().correctLoginConfirmationText(), equalTo(true));


  }


}
