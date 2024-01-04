package factories.settings;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeSettings implements IBrowserConfig {

  private String browserVersion = System.getProperty("browser.version");

  @Override
  public WebDriver config() {

    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--start-fullscreen");
    chromeOptions.addArguments("--no-sandbox");
    chromeOptions.addArguments("--no-first-run");
    chromeOptions.addArguments("--enable-extensions");
    chromeOptions.addArguments("--homepage=about:blank");
    chromeOptions.addArguments("--ignore-certificate-errors");
    chromeOptions.addArguments("--remote-allow-origins=*");

    WebDriverManager.chromedriver().browserVersion(browserVersion).setup();

    return new ChromeDriver(chromeOptions);
  }
}
