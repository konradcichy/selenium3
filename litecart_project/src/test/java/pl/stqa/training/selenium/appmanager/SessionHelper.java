package pl.stqa.training.selenium.appmanager;

import org.openqa.selenium.By;

/**
 * Created by Konrad on 19/11/2017.
 */


public class SessionHelper extends HelperBase {

  public SessionHelper(ApplicationManager app) throws Exception {
    super(app);
  }

  public void adminLogin(String username, String password) {
    type(By.name("username"), username);
    type(By.name("password"), password);
    if (!wd.findElement(By.name("remember_me")).isSelected()) {
      click(By.name("remember_me"));
    }
    click(By.name("login"));
  }

  public void customerLogin(String username, String password) {
    type(By.name("email"), username);
    type(By.name("password"), password);
    if (!wd.findElement(By.name("remember_me")).isSelected()) {
      click(By.name("remember_me"));
    }
    click(By.name("login"));
  }

  public void logout() {
    app.customWaits().clickElement(By.cssSelector(".account > nav >ul >li:nth-of-type(5) a"));
  }




}
