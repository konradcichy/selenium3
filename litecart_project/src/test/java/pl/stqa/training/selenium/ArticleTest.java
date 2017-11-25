package pl.stqa.training.selenium;

import org.testng.annotations.Test;
import pl.stqa.training.selenium.appmanager.Article;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by Konrad on 25/11/2017.
 */
public class ArticleTest extends TestBase {

  @Test
  public void compareArticleMainPageDetailsWithProductPage() throws InterruptedException {

    app.goTo().mainPage();
    Article mainPageArticleDetails = app.article().displayMainPageProductDetails();
    System.out.println(mainPageArticleDetails);
    app.article().articleClick();
    Article productPageArticleDetails = app.article().displayProductPageProductDetails();
    System.out.println(productPageArticleDetails);
    assertThat(mainPageArticleDetails, equalTo(productPageArticleDetails));


  }


}
