package factories;

import driver.listener.HighLightElementListener;
import factories.settings.ChromeSettings;
import factories.settings.FireFoxSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import java.util.ArrayList;
import java.util.List;

public class WebDriverFactory implements IFactory<WebDriver> {

  private String browser = System.getProperty("browser").toLowerCase();

  private List<WebDriverListener> listeners;


  @Override
  public WebDriver create() {

    listeners = getWebDriverListeners();

    switch (browser) {
      case "chrome":
        return new EventFiringDecorator<>(listeners.toArray(WebDriverListener[]::new)).decorate(new ChromeSettings().config());
      case "firefox":
        return new EventFiringDecorator<>(listeners.toArray(WebDriverListener[]::new)).decorate(new FireFoxSettings().config());
      default:
        throw new RuntimeException("Browser not supported");
    }


  }

  private List<WebDriverListener> getWebDriverListeners() {

    List<WebDriverListener> webDriverListeners = new ArrayList<>();
    webDriverListeners.add(new HighLightElementListener());

    return webDriverListeners;
  }
}
