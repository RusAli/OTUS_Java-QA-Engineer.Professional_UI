package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.AbsBaseUtils;

public abstract class AbsBasePage<T> extends AbsBaseUtils {

  protected final String baseUrl = System.getProperty("webdriver.base.url");

  public AbsBasePage(WebDriver driver) {
    super(driver);
  }
}
