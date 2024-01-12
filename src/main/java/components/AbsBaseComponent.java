package components;

import annotations.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AbsBaseUtils;

public abstract class AbsBaseComponent<T> extends AbsBaseUtils {

  {
    this.standartWaiter.waitForCondition(ExpectedConditions.visibilityOfElementLocated(getComponentLocator()));
  }

  public AbsBaseComponent(WebDriver driver) {
    super(driver);
  }

  protected String baseComponentLocator;


  private By getComponentLocator() {
    Component component = getClass().getAnnotation(Component.class);

    if (component != null) {
      String path = component.value();
      baseComponentLocator = path;

      return path.startsWith("/") ? By.xpath(path) : By.cssSelector(path);
    }
    return null;
  }
}