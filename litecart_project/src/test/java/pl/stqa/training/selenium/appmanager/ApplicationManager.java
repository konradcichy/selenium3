package pl.stqa.training.selenium.appmanager;

import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Konrad on 19/11/2017.
 */
public class ApplicationManager {
  public final Properties properties;
  WebDriver wd;
  WebDriverWait wait;
  private String browser;
  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private HelperBase helperBase;
  private ArticleHelper articleHelper;
  private CustomerHelper customerHelper;
  private Generators generators;
  private CustomWaits customWaits;


  public ApplicationManager(String browser) {

    this.browser = browser;
    properties = new Properties();
  }


  public void init() throws Exception {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
    navigationHelper = new NavigationHelper(this);
    sessionHelper = new SessionHelper(this);
    helperBase = new HelperBase(this);
    articleHelper = new ArticleHelper(this);
    customerHelper = new CustomerHelper(this);
    generators = new Generators(this);
    customWaits = new CustomWaits(this);

  }


  public void stop() {
    if (wd != null) {
      wd.quit();
    }
  }

  public SessionHelper login() {
    return sessionHelper;
  }

  public NavigationHelper goTo() {
    return navigationHelper;
  }

  public HelperBase helperBase() {
    return helperBase;
  }

  public ArticleHelper article() {
    return articleHelper;
  }

  public CustomerHelper customer(){
    return customerHelper;
  }

  public Generators generators(){
    return generators;
  }

  public CustomWaits customWaits(){
    return  customWaits;
  }



  public void runChrome() throws Exception {

    System.setProperty("webdriver.chrome.driver", "/Users/Konrad/selenium3/litecart_project/src/test/resources/chromedriver");
    ChromeOptions options = new ChromeOptions();
    options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
    options.addArguments("--kiosk");
    wd = new ChromeDriver(options);
    wait = new WebDriverWait(wd, 5);
  }


  public void runFirefoxNightly() {
    System.setProperty
            ("webdriver.gecko.driver", "/Users/Konrad/selenium3/litecart_project/src/test/resources/geckodriver");
    FirefoxOptions options = new FirefoxOptions();
    options.setBinary
            (new FirefoxBinary(new File("/Applications/FirefoxNightly.app/Contents/MacOS/firefox-bin")));
    wd = new FirefoxDriver(options);
    System.out.println(((HasCapabilities) wd).getCapabilities());
    wait = new WebDriverWait(wd, 5);


  }


  public WebDriver getDriver() throws Exception {
    if (wd == null) {
      if (browser.equals(BrowserType.FIREFOX)) {
        runFirefoxNightly();
      } else if (browser.equals(BrowserType.CHROME)) {
        runChrome();
      }
      wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
      wd.get(properties.getProperty("web.baseUrl"));
    }
    return wd;
  }


}
