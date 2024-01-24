package otus.components.standart;

import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import otus.annotations.Component;
import otus.pages.CoursesCatalogPage;
import otus.support.DiScooped;

@Component(value = "//label[contains(text(), 'Поиск')]//..")
public class CourseSearchComponent extends AbsBaseComponent<CourseSearchComponent> {

  private DiScooped diScooped;

  @Inject
  public CourseSearchComponent(DiScooped diScooped) {
    super(diScooped);
    this.diScooped = diScooped;
  }

  private String searchFieldLocator = baseComponentLocator + "//input[@type='search']";


  public CoursesCatalogPage searchByName(String name) {
    WebElement element = driver.findElement(By.xpath(searchFieldLocator));
    actions.sendKeys(element, name).sendKeys(Keys.ENTER).perform();

    return new CoursesCatalogPage(diScooped);
  }


}
