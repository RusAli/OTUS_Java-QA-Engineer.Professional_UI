package otus.pages;

import com.google.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import otus.annotations.UrlPage;
import otus.support.DiScooped;

import java.util.List;

@UrlPage("/catalog/courses")
public class CoursesCatalogPage extends AbsBasePage<CoursesCatalogPage> {

  @Inject
  public CoursesCatalogPage(DiScooped diScooped) {
    super(diScooped);
  }

  String vectorsLocator = "//label[contains(text(), '%s')]/..//input";

  String courcesNameLocator = "//section/descendant::div[contains(text(),'%s')]";

  public CoursesCatalogPage markVectorByName(String name) {
    WebElement element = driver.findElement(By.xpath(String.format(vectorsLocator, name)));
    element.click();

    return this;
  }

  public CoursesCatalogPage checkCourseIsPresentOnPageByName(String name) {

    List<WebElement> elements = driver.findElements(By.xpath(String.format(courcesNameLocator, name)));
    elements.stream().forEach(e -> Assertions.assertTrue(e.getText().contains(name)));

    return this;
  }


}
