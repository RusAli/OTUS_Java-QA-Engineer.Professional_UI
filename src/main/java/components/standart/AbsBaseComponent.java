package components.standart;

import annotations.Component;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AbsBaseUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public abstract class AbsBaseComponent<T> extends AbsBaseUtils {

  {
    Assertions.assertTrue(
            standartWaiter.waitForCondition(ExpectedConditions.visibilityOfElementLocated(getComponentLocator())));
  }

  public AbsBaseComponent(WebDriver driver) {
    super(driver);
  }

  protected String baseComponentLocator;


  private By getComponentLocator() {
    Component component = getClass().getAnnotation(Component.class);

    if (component != null) {
      String path = component.value();
      baseComponentLocator = path;

      return path.startsWith("/") ? By.xpath(path) : By.cssSelector(path);
    }
    return null;
  }

  public WebElement getComponentElement(String path) {
    return path.startsWith("/") ? standartWaiter.waitingForElement(By.xpath(path)) :
            standartWaiter.waitingForElement(By.cssSelector(path));
  }

  public List<WebElement> getComponentElements(String path) {
    return path.startsWith("/") ? standartWaiter.waitingForElements(By.xpath(path)) :
            standartWaiter.waitingForElements(By.cssSelector(path));
  }

  public LocalDate parseDateFromCourse(String input) {

    String formatted = input
            .replace("С ", "")
            .replaceAll("\\bгода\\b", "")
            .replaceAll(" \\d+ (месяцев|месяца)$", "")
            .trim();

    if (!formatted.matches("\\d{4}$")) {
      formatted += " " + LocalDate.now().getYear();
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy").withLocale(new Locale("ru"));

    return LocalDate.parse(formatted, formatter);
  }
}
