import annotations.Driver;
import extensions.UIDriverExtention;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

@ExtendWith(UIDriverExtention.class)
public class CoursesCatalogTest {

  @Driver
  private WebDriver driver;


  @Test
  @Story("Allure test")
  void testgg() throws InterruptedException {

    new MainPage(driver)
            .openMainPage()
            .checkTitle()
            .acceptCookiesPolices()
            .clickOnCoursesCatalog()
            .checkTitle()
            .markProgramming()
            .markArhitech()
            .markAllVectors()
            .markProgramming();

    Thread.sleep(5000);


  }

}
