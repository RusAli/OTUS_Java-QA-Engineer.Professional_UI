package otus.listener;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class HighLightElementListener implements WebDriverListener {

  private void highLightElement(WebDriver driver, WebElement element) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
  }

  private void unHighLightElement(WebDriver driver, WebElement element) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].style.border=''", element);
  }

  @Override
  public void afterFindElement(WebDriver driver, By locator, WebElement element) {
    unHighLightElement(driver,element);
    highLightElement(driver, element);
  }
}
