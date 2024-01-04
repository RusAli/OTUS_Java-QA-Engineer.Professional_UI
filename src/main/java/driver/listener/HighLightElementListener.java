package driver.listener;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class HighLightElementListener implements WebDriverListener {

  private void highLightElement(WebDriver driver, WebElement element) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
  }

  @Override
  public void afterFindElement(WebDriver driver, By locator, WebElement element) {
    highLightElement(driver, element);
  }

}
