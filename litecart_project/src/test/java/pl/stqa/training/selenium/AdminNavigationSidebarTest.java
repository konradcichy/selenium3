package pl.stqa.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by Konrad on 11/11/2017.
 */
public class AdminNavigationSidebarTest {

  private WebDriver wd;
  private WebDriverWait wait;
  public Properties properties;


  @BeforeMethod(enabled = true)
  public void setUpChrome() throws IOException {
    properties = new Properties();
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
    System.setProperty("webdriver.chrome.driver", "/Users/Konrad/selenium3/litecart_project/src/test/resources/chromedriver");
    ChromeOptions options = new ChromeOptions();
    options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
    options.addArguments("--kiosk");
    wd = new ChromeDriver(options);
    wait = new WebDriverWait(wd, 10);
  }


  @Test
  public void LoginTest() {
    wd.get(properties.getProperty("web.baseUrl"));
    wd.findElement(By.name("username")).sendKeys(properties.getProperty("web.adminLogin"));
    wd.findElement(By.name("password")).sendKeys(properties.getProperty("web.adminPassword"));
    if (!wd.findElement(By.name("remember_me")).isSelected()) {
      wd.findElement(By.name("remember_me")).click();
    }
    wd.findElement(By.name("login")).click();
    Assert.assertTrue(wait.until(titleIs("My Store")));

    List<WebElement> mainList = wd.findElements(By.id("app-"));
    for (int i = 0; i < mainList.size(); i++) {
      mainList = wd.findElements(By.id("app-"));
      mainList.get(i).click();
      if (isElementPresent(wd, By.cssSelector("#app- > ul > li"))) {
        List<WebElement> subList = wd.findElements(By.cssSelector("#app- > ul > li"));
        for (int j = 0; j < subList.size(); j++) {
          subList = wd.findElements(By.cssSelector("#app- > ul > li"));
          subList.get(j).click();
          verifyIfHeaderAvailable();

        }

      } else {

        verifyIfHeaderAvailable();
      }

    }
  }

  private void verifyIfHeaderAvailable() {
    if (wd.findElement(By.cssSelector("#content > h1")).isDisplayed()) {
      System.out.println(wd.findElement(By.cssSelector("#content > h1")).getText());
    } else {
      System.out.println("Header not displayed");
    }
  }


  boolean isElementPresent(WebDriver driver, By locator) {
    try {
      wait.until((WebDriver wd) -> wd.findElement(locator));
      return true;
    } catch (TimeoutException ex) {
      return false;
    }
  }

  boolean areElementsPresent(WebDriver driver, By locator) {
    return driver.findElements(locator).size() > 0;
  }


  @AfterMethod
  public void tearDown() {
    wd.quit();
    wd = null;
  }


}


