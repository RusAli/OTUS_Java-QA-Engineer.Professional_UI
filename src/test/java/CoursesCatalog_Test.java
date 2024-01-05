import annotations.Driver;
import extensions.UIDriverExtention;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

@ExtendWith(UIDriverExtention.class)
public class CoursesCatalog_Test {

  @Driver
  private WebDriver driver;

  private MainPage mainPage;


  @Test
  @Story("Allure test")
  void testgg() {

    mainPage = new MainPage(driver);

    mainPage
            .openMainPage()
            .checkTitle()
            .clickOnCoursesCatalog()
            .checkTitle();
  }

}
