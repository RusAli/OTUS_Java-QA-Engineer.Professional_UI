package otus.components.standart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import otus.annotations.Component;
import otus.pages.CoursePage;
import otus.support.DiScooped;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("//h2[contains(text(),'Специализации')]/ancestor::section")
public class SpecializationCoursesComponent extends AbsBaseComponent<SpecializationCoursesComponent> {

  private DiScooped diScooped;

  public SpecializationCoursesComponent(DiScooped diScooped) {
    super(diScooped);
    this.diScooped = diScooped;
  }

  String startCourseLocator = baseComponentLocator + "//span[@class='sc-12yergf-7 dPBnbE']";


  public CoursePage getEarliestCourse() {

    List<WebElement> dateInfoElements = standartWaiter.waitingForElements(By.xpath(startCourseLocator));
    Map<LocalDate, WebElement> coursesMap = new HashMap<>();
    LocalDate startCourseDate;

    for (WebElement element : dateInfoElements) {

      startCourseDate = parseDateFromCourse(element.getText());

      if (startCourseDate != null)
        coursesMap.put(startCourseDate, element);
    }

    startCourseDate = coursesMap.keySet().stream()
            .reduce((first, current) -> current.isBefore(first) ? current : first)
            .get();

    actions.click(coursesMap.get(startCourseDate)).click().perform();

    return new CoursePage(diScooped);
  }

  public CoursePage getLatestCourse() {

    List<WebElement> dateInfoElements = standartWaiter.waitingForElements(By.xpath(startCourseLocator));
    Map<LocalDate, WebElement> coursesMap = new HashMap<>();
    LocalDate startCourseDate;

    for (WebElement element : dateInfoElements) {

      startCourseDate = parseDateFromCourse(element.getText());

      if (startCourseDate != null)
        coursesMap.put(startCourseDate, element);
    }

    startCourseDate = coursesMap.keySet().stream()
            .reduce((last, current) -> current.isAfter(last) ? current : last)
            .get();

    actions.click(coursesMap.get(startCourseDate)).click().perform();

    return new CoursePage(diScooped);
  }


}
