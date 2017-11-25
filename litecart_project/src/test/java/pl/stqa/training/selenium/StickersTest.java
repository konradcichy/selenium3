package pl.stqa.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by Konrad on 12/11/2017.
 */
public class StickersTest extends TestBase {


  @Test(enabled = true)
  public void forEachArticleCountOfStickersShouldBeEqualOne() throws InterruptedException {
    app.goTo().mainPage();
    List<WebElement> articleList = wd.findElements(By.cssSelector("ul.listing-wrapper.products >li"));
    for (int i = 0; i < articleList.size(); i++) {
      List<WebElement> stickers = articleList.get(i).findElements
              (By.cssSelector(".image-wrapper .sticker"));
      int stickersSize = stickers.size();
      assertThat(stickersSize, equalTo(1));

    }

  }


}
