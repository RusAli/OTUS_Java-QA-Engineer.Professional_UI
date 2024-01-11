package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import waiters.StandartWaiter;

public abstract class AbsBaseUtils {

  protected WebDriver driver;

  protected Actions actions;

  protected StandartWaiter standartWaiter;

  public AbsBaseUtils(WebDriver driver) {
    this.driver = driver;
    this.actions = new Actions(driver);
    this.standartWaiter = new StandartWaiter(driver);
    PageFactory.initElements(driver, this);
  }
}
