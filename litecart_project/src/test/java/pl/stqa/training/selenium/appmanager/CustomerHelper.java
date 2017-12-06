package pl.stqa.training.selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

/**
 * Created by Konrad on 26/11/2017.
 */
public class CustomerHelper extends HelperBase {

  public CustomerHelper(ApplicationManager app) throws Exception {
    super(app);
  }


  public void fillCustomerForm(CustomerData customerData) throws InterruptedException {
    type(By.name("tax_id"), customerData.getTaxId());
    type(By.name("company"), customerData.getCompany());
    type(By.name("firstname"), customerData.getFirstname());
    type(By.name("lastname"), customerData.getLastname());
    type(By.name("address1"), customerData.getAddress1());
    type(By.name("address2"), customerData.getAddress2());
    type(By.name("postcode"), customerData.getPostcode());
    type(By.name("city"), customerData.getCity());
    WebElement drop = wd.findElement(By.cssSelector("span.select2.select2-container"));
    drop.click();
    type(By.cssSelector("input.select2-search__field"), customerData.getCountrycode());
    WebElement element = wd.findElement(By.name("email"));
    Actions actions = new Actions(wd);
    actions.moveToElement(element).click().perform();
    type(By.name("email"), customerData.getEmail());
    type(By.name("phone"), customerData.getPhone());
    type(By.name("password"), customerData.getPassword());
    type(By.name("confirmed_password"), customerData.getPassword());
  }


  public void openRegistrationPage(int index) throws InterruptedException {
    List<WebElement> we = wd.findElements(By.cssSelector("#navigation .content form[name =\"login_form\"]  td"));
    we.get(index).click();
  }

  public void submitRegistration() {
    wd.findElement(By.cssSelector("button[name=\"create_account\"]")).click();
  }

  public boolean correctRegistrationText() {
    return app.customWaits().elementText(By.cssSelector("div.notice"), "Your customer account has been created.");
  }

  public boolean correctLoginConfirmationText() {
    return app.customWaits().elementText(By.cssSelector("div.notice"), "You are now logged in as Mark Vieira.");
  }

  public boolean logOutConfirmationText() {
    return app.customWaits().elementText(By.cssSelector("div.notice"), "You are now logged out.");
  }
}


