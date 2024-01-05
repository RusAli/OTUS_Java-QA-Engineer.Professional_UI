package factories.settings;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class OperaSettings implements IBrowserConfig {

  private String browserVersion = System.getProperty("browser.version");

  @Override
  public WebDriver config() {

    ChromeOptions options = new ChromeOptions();

    WebDriverManager.operadriver().browserVersion(browserVersion).setup();

    return new ChromeDriver(options);
  }
}
