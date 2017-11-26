package pl.stqa.training.selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Konrad on 26/11/2017.
 */
public class CustomerHelper extends HelperBase {

  public CustomerHelper(ApplicationManager app) throws Exception {
    super(app);
  }


  public void fillCustomerForm(CustomerData customerData) {
    type(By.name("tax_id"), customerData.getTaxId());
    type(By.name("company"), customerData.getCompany());
    type(By.name("firstname"), customerData.getFirstname());
    type(By.name("lastname"), customerData.getLastname());
    type(By.name("address1"), customerData.getAddress1());
    type(By.name("address2"), customerData.getAddress2());
    type(By.name("postcode"), customerData.getPostcode());
    type(By.name("city"), customerData.getCity());
    type(By.name("country_code"), customerData.getCountrycode());
    type(By.name("zone_code"), customerData.getZonecode());
    type(By.name("email"), customerData.getEmail());
    type(By.name("phone"), customerData.getPhone());
    type(By.name("newsletter"), customerData.getNewsletter());
    type(By.name("password"), customerData.getPassword());
  }


  public void openRegistrationPage(int index) throws InterruptedException {
    List<WebElement> we = wd.findElements(By.cssSelector("#navigation .content form[name =\"login_form\"]  td"));
    we.get(index).click();
  }

}
