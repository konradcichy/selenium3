package pl.stqa.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Konrad on 11/11/2017.
 */
public class AdminNavigationSidebarTest extends TestBase {


  @Test
  public void leftNavigationSidebarTest() {


    loginAsAdmin();
    List<WebElement> mainList = wd.findElements(By.id("app-"));
    for (int i = 0; i < mainList.size(); i++) {
      mainList = wd.findElements(By.id("app-"));
      mainList.get(i).click();
      if (app.helperBase().isElementPresent(wd, By.cssSelector("#app- > ul > li"))) {
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


}


