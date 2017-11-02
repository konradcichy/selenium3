package pl.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by Konrad on 01/11/2017.
 */
public class InitialTest {

  private WebDriver driver;
  private WebDriverWait wait;

  @Before
  public void start(){
    driver  = new ChromeDriver();
    wait = new WebDriverWait(driver,10);
  }

  @Test
  public void myTest(){
    driver.get("http://www.google.com/");
    driver.findElement(By.name("q")).sendKeys("webdriver" + Keys.ENTER);
//    driver.findElement(By.name("btnK")).click();
    wait.until(titleIs("webdriver - Google Search"));


  }



  @After
  public void stop(){
    driver.quit();
    driver = null;
  }


}
