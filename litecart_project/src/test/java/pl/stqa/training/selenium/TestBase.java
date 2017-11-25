package pl.stqa.training.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pl.stqa.training.selenium.appmanager.ApplicationManager;

/**
 * Created by Konrad on 19/11/2017.
 */
public class TestBase {

  WebDriver wd;
  WebDriverWait wait;


  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));


  protected void loginAsAdmin() {

    app.goTo().adminPage();
    app.login().adminLogin(
            app.properties.getProperty("web.adminLogin"),
            app.properties.getProperty("web.adminPassword"));
//    Assert.assertTrue(wait.until(titleIs("My Store")));

  }


  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
    wd = app.getDriver();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }

}
