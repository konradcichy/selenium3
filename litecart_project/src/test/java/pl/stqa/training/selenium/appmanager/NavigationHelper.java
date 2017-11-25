package pl.stqa.training.selenium.appmanager;

import org.openqa.selenium.By;

/**
 * Created by Konrad on 19/11/2017.
 */
public class NavigationHelper extends HelperBase {


  public NavigationHelper(ApplicationManager app) throws Exception {
    super(app);


  }

  public void adminPage() {
    if (isElementPresent(By.tagName("span"))
            && wd.findElement(By.tagName("span")).getText().equals("Appearance")) {
      return;
    }
    wd.get("http://litecart.stqa.ru/admin/");
  }

  public void mainPage() {
    if (isElementPresent(By.tagName("h3"))
            && wd.findElement(By.tagName("h3")).getText().equals("Categories")) {
      return;
    }

    wd.get("http://litecart.stqa.ru/index.php/en/");
  }


}
