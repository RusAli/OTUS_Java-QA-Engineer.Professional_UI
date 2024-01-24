package otus.support;

import io.cucumber.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;
import otus.factories.WebDriverFactory;

@ScenarioScoped
public class DiScooped {

  private WebDriver driver = new WebDriverFactory().create();

  public WebDriver getDriver() {
    return driver;
  }
}
