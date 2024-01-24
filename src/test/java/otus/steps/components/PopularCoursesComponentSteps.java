package otus.steps.components;

import com.google.inject.Inject;
import io.cucumber.java.ru.Если;
import otus.components.standart.PopularCoursesComponent;

public class PopularCoursesComponentSteps {

  @Inject
  public PopularCoursesComponent popularCoursesComponent;

  @Если("Кликнуть по плитке курса по названию {string}")
  public void clickOnCourseByName(String name){
    popularCoursesComponent.clickOnCourseName(name);
  }
}
