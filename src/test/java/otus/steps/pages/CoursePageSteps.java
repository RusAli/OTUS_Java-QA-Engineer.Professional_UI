package otus.steps.pages;

import com.google.inject.Inject;
import io.cucumber.java.ru.Тогда;
import otus.pages.CoursePage;
import otus.support.DiScooped;

public class CoursePageSteps {

  @Inject
  public CoursePage coursePage;

  @Inject
  public DiScooped diScooped;

  @Тогда("Откроется страница курса {string}")
  public void checkLessonPage(String name) {
    coursePage.checkLessonPage(name);
  }


}
