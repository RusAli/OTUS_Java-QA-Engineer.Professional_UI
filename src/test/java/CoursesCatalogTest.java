import annotations.Driver;
import components.standart.CourseSearchComponent;
import components.standart.PopularCoursesComponent;
import components.standart.SpecializationCoursesComponent;
import extensions.UIDriverExtention;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.CoursesCatalogPage;
import pages.MainPage;


@ExtendWith(UIDriverExtention.class)
public class CoursesCatalogTest {

  @Driver
  private WebDriver driver;

  @Test
  void shouldFindCourseByNameOnCatalogPage() {

    String courseName = "QA Lead";

    new CoursesCatalogPage(driver)
            .open()
            .acceptCookiesPolices()
            .markVectorByName("Все направления");
    new CourseSearchComponent(driver)
            .searchByName(courseName)
            .checkCourseIsPresentOnPageByName(courseName);
  }

  @Test
  void shouldFindCourseByNameOnPopularSectionOnMainPage() {

    String popularCourseName = "DevRel";

    new MainPage(driver)
            .open()
            .acceptCookiesPolices();
    new PopularCoursesComponent(driver)
            .clickOnCourseName(popularCourseName)
            .checkLessonPage(popularCourseName);
  }

  @Test
  void shouldFindFirstStartedCourse() {

    new MainPage(driver)
            .open()
            .acceptCookiesPolices();
    new SpecializationCoursesComponent(driver)
            .getEarliestCourse();
  }

  @Test
  void shouldFindLatestStartedCourse() {

    new MainPage(driver)
            .open()
            .acceptCookiesPolices();
    new SpecializationCoursesComponent(driver)
            .getLatestCourse();
  }
}
