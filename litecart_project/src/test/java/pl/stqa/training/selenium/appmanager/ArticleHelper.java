package pl.stqa.training.selenium.appmanager;

import org.openqa.selenium.By;

/**
 * Created by Konrad on 25/11/2017.
 */
public class ArticleHelper extends HelperBase {

  public ArticleHelper(ApplicationManager app) throws Exception {
    super(app);

  }

  public Article displayProductPageProductDetails() throws InterruptedException {


    String productArticleTitle = wd.findElement(By.cssSelector("#box-product > div.content > div.images-wrapper > a > img")).getAttribute("title");
    String productRegularPrice = wd.findElement(By.cssSelector("#box-product > div.content .information .price-wrapper .regular-price")).getText();
    String productRegularPriceColor = wd.findElement(By.cssSelector("#box-product > div.content .information .price-wrapper .regular-price")).getCssValue("color");
    String productCampaignPrice = wd.findElement(By.cssSelector("#box-product > div.content .information .price-wrapper .campaign-price")).getText();
    String productCampaignPriceColor = wd.findElement(By.cssSelector("#box-product > div.content .information .price-wrapper .campaign-price")).getCssValue("color");


    return new Article()
            .withTitle(productArticleTitle)
            .withProductRegularPrice(productRegularPrice)
            .withProductRegularPriceColor(productRegularPriceColor)
            .withProductCampaignPrice(productCampaignPrice)
            .withProductCampaignPriceColor(productCampaignPriceColor);


  }


  public Article displayMainPageProductDetails() {
    String articleTitle = wd.findElement(By.cssSelector("#box-campaigns a > .name")).getText();
    String regularPrice = wd.findElement(By.cssSelector("#box-campaigns a .regular-price")).getText();
    String regularPriceColor = wd.findElement(By.cssSelector("#box-campaigns a .regular-price")).getCssValue("color");
    String campaignPrice = wd.findElement(By.cssSelector("#box-campaigns a .campaign-price")).getText();
    String campaignPriceColor = wd.findElement(By.cssSelector("#box-campaigns a .campaign-price")).getCssValue("color");


    return new Article()
            .withTitle(articleTitle)
            .withProductRegularPrice(regularPrice)
            .withProductRegularPriceColor(regularPriceColor)
            .withProductCampaignPrice(campaignPrice)
            .withProductCampaignPriceColor(campaignPriceColor);

  }

  public void articleClick() {
    wd.findElement(By.cssSelector("#box-campaigns a.link")).click();
  }

}
