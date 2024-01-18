package components.popups;

import org.openqa.selenium.WebDriver;
import utils.AbsBaseUtils;

public abstract class AbsBasePopUps<T> extends AbsBaseUtils implements IPopUp<T> {

  public AbsBasePopUps(WebDriver driver) {
    super(driver);
  }
}
