package pl.stqa.training.selenium.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by Konrad on 27/11/2017.
 */
public class CustomWaits extends HelperBase {

  private static Logger logger = Logger.getLogger(CustomWaits.class);


  private static final int DEFAULT_TIMEOUT_IN_SEC = 10;

  public CustomWaits(ApplicationManager app) throws Exception {
    super(app);
  }

  public FluentWait<WebDriver> createFluentWait() {
    return new WebDriverWait(wd, DEFAULT_TIMEOUT_IN_SEC);
  }

  private FluentWait<WebDriver> createWait(final int seconds) {
    return createFluentWait().withTimeout(seconds, SECONDS);
  }


  public boolean isElementVisible(final WebElement element) {
    FluentWait<WebDriver> wait = createWait(DEFAULT_TIMEOUT_IN_SEC);
    try {
      wait.until(ExpectedConditions.visibilityOf(element));
      return true;
    } catch (TimeoutException e) {
      logger.error("Element not found!", e);
      return false;
    }
  }

  public boolean isElementClickable(final WebElement element) {
    FluentWait<WebDriver> wait = createWait(DEFAULT_TIMEOUT_IN_SEC);
    try {
      wait.until(ExpectedConditions.elementToBeClickable(element));
      return true;
    } catch (TimeoutException e) {
      logger.error("Element not found!", e);
      return false;
    }
  }

  public boolean isElementPresent(final By by) {
    FluentWait<WebDriver> wait = createWait(DEFAULT_TIMEOUT_IN_SEC);
    try {
      wait.until(ExpectedConditions.presenceOfElementLocated(by));
      return true;
    } catch (TimeoutException e) {
      logger.error("Element not found!", e);
      return false;
    }
  }

  public boolean elementText(final By by, String text) {
    FluentWait<WebDriver> wait = createWait(DEFAULT_TIMEOUT_IN_SEC);
    try {
      wait.until(ExpectedConditions.textToBePresentInElementLocated(by, text));
      System.out.println(text);
      return true;
    } catch (TimeoutException e) {
      logger.error("Element not found! Can't get element's text...", e);
      return false;
    }
  }


  public boolean isElementDisappear(final By by) {
    FluentWait<WebDriver> wait = createWait(DEFAULT_TIMEOUT_IN_SEC);
    try {
      wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
      return true;
    } catch (TimeoutException e) {
      logger.error("Element should not be visible!", e);
      return false;
    }
  }

  public void clickElement(final By by, final int timeoutInSeconds) {
    FluentWait<WebDriver> wait = createWait(timeoutInSeconds);
    wait.until(driver -> {
      if (isElementClickable(driver.findElement(by))) {
        driver.findElement(by).click();
      }
      return true;
    });
  }

  public void clickElement(final WebElement element, final int timeoutInSeconds) {
    FluentWait<WebDriver> wait = createWait(timeoutInSeconds);
    wait.until(driver -> {
      if (isElementClickable(element)) {
        element.click();
      }
      return true;
    });
  }

  public void clickElement(final WebElement element) {
    clickElement(element, DEFAULT_TIMEOUT_IN_SEC);
  }

  public void clickElement(final By by) {
    clickElement(by, DEFAULT_TIMEOUT_IN_SEC);
  }

  public String getElementText(final By by, final int timeoutInSeconds) {
    FluentWait<WebDriver> wait = createWait(timeoutInSeconds);
    return wait.until(driver -> {
      try {
        if (isElementVisible(driver.findElement(by))) {
          return driver.findElement(by).getText();
        }
      } catch (NoSuchElementException e) {
        logger.error("Element not found! Can't get element's text...", e);

      }
      return "";
    });
  }

  public String getElementAttribute(final By by, final String attributeName, final int timeoutInSeconds) {
    FluentWait<WebDriver> wait = createWait(timeoutInSeconds);
    return wait.until(driver -> {
      try {
        if (!driver.findElement(by).getAttribute(attributeName).isEmpty()) {
          return driver.findElement(by).getAttribute(attributeName);
        }
      } catch (NoSuchElementException e) {
        logger.error("Element not found! Can't get '" + attributeName + "'...", e);

      }
      return "";
    });
  }

}
