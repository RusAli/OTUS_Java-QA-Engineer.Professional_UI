package otus.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import otus.support.DiScooped;
import otus.waiters.StandartWaiter;

public abstract class AbsBaseUtils {

  protected WebDriver driver;

  protected Actions actions;

  protected StandartWaiter standartWaiter;

  public AbsBaseUtils(DiScooped scenarioScoped) {
    this.driver = scenarioScoped.getDriver();
    this.actions = new Actions(driver);
    this.standartWaiter = new StandartWaiter(driver);
    PageFactory.initElements(driver, this);
  }
}
