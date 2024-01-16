package waiters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class StandartWaiter {

  private WebDriver driver;

  private final Duration duration = Duration.ofSeconds(5);

  public StandartWaiter(WebDriver driver) {
    this.driver = driver;
  }


  public boolean waitForCondition(ExpectedCondition condition) {
    WebDriverWait webDriverWait = new WebDriverWait(driver, duration);
    try {
      webDriverWait.until(condition);
      return true;
    } catch (Exception ex) {
      ex.printStackTrace();
      return false;
    }
  }

  public WebElement waitingForElement(By by) {
    WebElement element;

    try {
      waitForElementVisible(by);
      waitForElementClickable(by);
      return element = driver.findElement(by);
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return null;
  }

  public List<WebElement> waitingForElements(By by) {
    List<WebElement> elements;

    try {
      waitForElementVisible(by);
      return elements = driver.findElements(by);
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return null;
  }

  public boolean waitForElementVisible(By by) {
    return waitForCondition(ExpectedConditions.visibilityOfElementLocated(by));
  }

  public boolean waitForElementClickable(By by) {
    return waitForCondition(ExpectedConditions.elementToBeClickable(by));
  }

  public boolean waitForElementNotVisible(By by) {
    return waitForCondition(ExpectedConditions.invisibilityOfElementLocated(by));
  }
}
