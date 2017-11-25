package pl.stqa.training.selenium.appmanager;

/**
 * Created by Konrad on 25/11/2017.
 */
public class Article {


  String productArticleTitle;
  String productRegularPrice;
  String productRegularPriceColor;
  String productCampaignPrice;
  String productCampaignPriceColor;


  public Article withTitle(String productArticleTitle) {
    this.productArticleTitle = productArticleTitle;
    return this;
  }

  public Article withProductRegularPrice(String productRegularPrice) {
    this.productRegularPrice = productRegularPrice;
    return this;
  }

  public Article withProductRegularPriceColor(String productRegularPriceColor) {
    this.productRegularPriceColor = productRegularPriceColor;
    return this;

  }

  public Article withProductCampaignPrice(String productCampaignPrice) {
    this.productCampaignPrice = productCampaignPrice;
    return this;
  }

  public Article withProductCampaignPriceColor(String productCampaignPriceColor) {
    this.productCampaignPriceColor = productCampaignPriceColor;
    return this;

  }


  public String getProductArticleTitle() {
    return productArticleTitle;
  }


  public String getProductRegularPrice() {
    return productRegularPrice;
  }


  public String getProductRegularPriceColor() {
    return productRegularPriceColor;
  }


  public String getProductCampaignPrice() {
    return productCampaignPrice;
  }


  public String getProductCampaignPriceColor() {
    return productCampaignPriceColor;
  }

  @Override
  public String toString() {
    return "Article{" +
            "productArticleTitle='" + productArticleTitle + '\'' +
            ", productRegularPrice='" + productRegularPrice + '\'' +
            ", productRegularPriceColor='" + productRegularPriceColor + '\'' +
            ", productCampaignPrice='" + productCampaignPrice + '\'' +
            ", productCampaignPriceColor='" + productCampaignPriceColor + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Article article = (Article) o;

    if (!productArticleTitle.equals(article.productArticleTitle)) return false;
    if (!productRegularPrice.equals(article.productRegularPrice)) return false;
    if (!productRegularPriceColor.equals(article.productRegularPriceColor)) return false;
    if (!productCampaignPrice.equals(article.productCampaignPrice)) return false;
    return productCampaignPriceColor.equals(article.productCampaignPriceColor);

  }

  @Override
  public int hashCode() {
    int result = productArticleTitle.hashCode();
    result = 31 * result + productRegularPrice.hashCode();
    result = 31 * result + productRegularPriceColor.hashCode();
    result = 31 * result + productCampaignPrice.hashCode();
    result = 31 * result + productCampaignPriceColor.hashCode();
    return result;
  }


}


