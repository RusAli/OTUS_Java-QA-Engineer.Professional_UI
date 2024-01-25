package otus.steps.components;

import com.google.inject.Inject;
import io.cucumber.java.ru.И;
import otus.components.standart.SpecializationCoursesComponent;

public class SpecializationCoursesComponentSteps {

  @Inject
  SpecializationCoursesComponent specializationCoursesComponent;

  @И("Получаем курс стартующий раньше всех")
  public void getEarliestCourse() {
    specializationCoursesComponent.getEarliestCourse();
  }

  @И("Получаем курс стартующий позже всех")
  public void getLatestCourse() {
    specializationCoursesComponent.getLatestCourse();
  }

}
