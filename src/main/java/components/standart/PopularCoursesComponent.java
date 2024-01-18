package components.standart;

import annotations.Component;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.CoursePage;

import java.util.List;

@Component(value = "//h2[contains(text(),'Популярные курсы')]/ancestor::section")
public class PopularCoursesComponent extends AbsBaseComponent<PopularCoursesComponent> {

  public PopularCoursesComponent(WebDriver driver) {
    super(driver);
  }

  String courseNameLocator = baseComponentLocator + "//h5";

  public CoursePage clickOnCourseName(String name) {

    List<WebElement> elementList = getComponentElements(courseNameLocator);
    WebElement course = elementList.stream().filter(e -> e.getText().contains(name)).findFirst().orElse(null);
    actions.moveToElement(course).click().perform();

    return new CoursePage(driver);
  }


}
