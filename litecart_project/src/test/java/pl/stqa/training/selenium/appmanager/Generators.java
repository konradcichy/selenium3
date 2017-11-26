package pl.stqa.training.selenium.appmanager;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

/**
 * Created by Konrad on 26/11/2017.
 */
public class Generators extends HelperBase {

  public Generators(ApplicationManager app) throws Exception {
    super(app);
  }

  public static String getRandomAlphanumericString(int length){
    return RandomStringUtils.randomAlphanumeric(length);
  }

  public static String getRandomAlphabeticString(int length){
    return RandomStringUtils.randomAlphabetic(length);
  }

  public static int getRandomInt(int max){
    return new Random().nextInt(max);
  }

  public static boolean getRandomBoolean(){
    return new Random().nextBoolean();
  }
}
