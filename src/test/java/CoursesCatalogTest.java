import annotations.Driver;
import components.CourseSearchComponent;
import extensions.UIDriverExtention;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.CoursesCatalogPage;


@ExtendWith(UIDriverExtention.class)
public class CoursesCatalogTest {

  @Driver
  private WebDriver driver;

  @Test
  @Story("Проверка фильтра поиска по названию курса")
  void shouldFindCourseByName() throws InterruptedException {

    String courseName = "QA Lead";

    new CoursesCatalogPage(driver)
            .open()
            .acceptCookiesPolices()
            .markVectorByName("Все направления");
    new CourseSearchComponent(driver)
            .searchByName(courseName)
            .checkCourseIsPresentOnPageByName(courseName);


    Thread.sleep(5000);
  }

}
