package pl.stqa.training.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by Konrad on 01/11/2017.
 */
public class LoginTest {

  private WebDriver wd;
  private WebDriverWait wait;
  public Properties properties;


  @BeforeMethod
  public void setUp() throws IOException {
    properties = new Properties();
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
    wd = new ChromeDriver();
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


  }


  @AfterMethod
  public void tearDown() {
    wd.quit();
    wd = null;
  }


}