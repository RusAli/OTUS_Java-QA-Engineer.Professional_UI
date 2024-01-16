package components;

import annotations.Component;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AbsBaseUtils;

public abstract class AbsBaseComponent<T> extends AbsBaseUtils {

  {
    Assertions.assertTrue(
            standartWaiter.waitForCondition(ExpectedConditions.visibilityOfElementLocated(getComponentLocator())));
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