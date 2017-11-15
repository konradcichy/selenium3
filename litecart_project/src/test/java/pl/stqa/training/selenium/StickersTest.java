package pl.stqa.training.selenium;

import org.openqa.selenium.By;
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

/**
 * Created by Konrad on 12/11/2017.
 */
public class StickersTest {

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
    wd.get(properties.getProperty("web.shopUrl"));
  }

  @Test(enabled = true)
  public void forEachArticleCountOfStickersShouldBeEqualOne()

  {

    List<WebElement> articleList = wd.findElements(By.cssSelector("ul.listing-wrapper.products >li"));
    for (int i = 0; i < articleList.size(); i++) {
      List<WebElement> stickers = articleList.get(i).findElements
              (By.cssSelector(".image-wrapper .sticker"));
      int stickersSize = stickers.size();
      Assert.assertTrue(stickersSize == 1);
    }

  }

  @AfterMethod
  public void tearDown() {
    wd.quit();
    wd = null;
  }


}
