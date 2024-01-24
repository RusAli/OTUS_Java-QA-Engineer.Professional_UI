package otus.components.standart;

import com.google.inject.Inject;
import org.openqa.selenium.WebElement;
import otus.annotations.Component;
import otus.pages.CoursePage;
import otus.support.DiScooped;

import java.util.List;

@Component(value = "//h2[contains(text(),'Популярные курсы')]/ancestor::section")
public class PopularCoursesComponent extends AbsBaseComponent<PopularCoursesComponent> {

  private DiScooped diScooped;

  @Inject
  public PopularCoursesComponent(DiScooped diScooped) {
    super(diScooped);
    this.diScooped = diScooped;
  }

  String courseNameLocator = baseComponentLocator + "//h5";

  public CoursePage clickOnCourseName(String name) {

    List<WebElement> elementList = getComponentElements(courseNameLocator);
    WebElement course = elementList.stream().filter(e -> e.getText().contains(name)).findFirst().orElse(null);
    actions.moveToElement(course).click().perform();

    return new CoursePage(diScooped);
  }


}
