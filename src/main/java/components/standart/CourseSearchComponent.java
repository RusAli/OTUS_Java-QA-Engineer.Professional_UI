package components.standart;

import annotations.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.CoursesCatalogPage;

@Component(value = "//label[contains(text(), 'Поиск')]//..")
public class CourseSearchComponent extends AbsBaseComponent<CourseSearchComponent> {

  public CourseSearchComponent(WebDriver driver) {
    super(driver);
  }

  private String searchFieldLocator = baseComponentLocator + "//input[@type='search']";


  public CoursesCatalogPage searchByName(String name) {
    WebElement element = driver.findElement(By.xpath(searchFieldLocator));
    actions.sendKeys(element, name).sendKeys(Keys.ENTER).perform();

    return new CoursesCatalogPage(driver);
  }


}
