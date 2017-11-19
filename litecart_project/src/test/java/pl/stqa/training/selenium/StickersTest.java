package pl.stqa.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Konrad on 12/11/2017.
 */
public class StickersTest extends TestBase {


  @Test(enabled = true)
  public void forEachArticleCountOfStickersShouldBeEqualOne() {
    app.goTo().mainPage();
    List<WebElement> articleList = wd.findElements(By.cssSelector("ul.listing-wrapper.products >li"));
    for (int i = 0; i < articleList.size(); i++) {
      List<WebElement> stickers = articleList.get(i).findElements
              (By.cssSelector(".image-wrapper .sticker"));
      int stickersSize = stickers.size();

      Assert.assertTrue(stickersSize == 1);

    }

  }


}
