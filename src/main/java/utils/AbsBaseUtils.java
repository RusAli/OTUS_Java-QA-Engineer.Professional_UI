package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public abstract class AbsBaseUtils {

  protected WebDriver driver;

  protected Actions actions;

  public AbsBaseUtils(WebDriver driver) {
    this.driver = driver;
    this.actions = new Actions(driver);
  }
}
