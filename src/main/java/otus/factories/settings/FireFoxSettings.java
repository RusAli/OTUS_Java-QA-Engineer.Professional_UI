package otus.factories.settings;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class FireFoxSettings implements IBrowserConfig{

  private String browserVersion = System.getProperty("browser.version");

  @Override
  public WebDriver config() {

    FirefoxOptions firefoxOptions = new FirefoxOptions();
    firefoxOptions.addArguments("--start-maximized");
    firefoxOptions.addArguments("--incognito");

    WebDriverManager.firefoxdriver().browserVersion(browserVersion).setup();

    return new FirefoxDriver(firefoxOptions);
  }
}
