package pages;

import annotations.UrlPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@UrlPage("/lessons")
public class CoursePage extends AbsBasePage<CoursePage> {
  public CoursePage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//h1")
  WebElement courseName;

  public CoursePage open(String course) {
    driver.get(getBaseUrl() + "/" + course);
    return this;
  }

  public void checkLessonPage(String name) {
    Assertions.assertEquals(courseName.getText(), name);
  }
}
