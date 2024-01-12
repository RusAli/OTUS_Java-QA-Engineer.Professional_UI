import annotations.Driver;
import extensions.UIDriverExtention;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.CoursesCatalogPage;
import pages.MainPage;

import static pages.CoursesCatalogPage.courseCatalogTitle;
import static pages.MainPage.mainPageTitle;

@ExtendWith(UIDriverExtention.class)
public class CoursesCatalogTest {

  @Driver
  private WebDriver driver;

  @Test
  @Story("Allure test")
  void testgg() throws InterruptedException {

    new MainPage(driver)
            .open()
            .checkTitle(mainPageTitle)
            .acceptCookiesPolices()
            .clickOnCoursesCatalog()
            .checkTitle(courseCatalogTitle)
            .markProgramming()
            .markArhitech()
            .markAllVectors()
            .markProgramming();

    Thread.sleep(5000);
  }

  @Test
  void t2() throws InterruptedException {

    new CoursesCatalogPage(driver)
            .open()
            .acceptCookiesPolices();


    Thread.sleep(5000);
  }

}
