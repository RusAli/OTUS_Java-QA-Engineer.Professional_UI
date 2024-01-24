package otus.pages;

import com.google.inject.Inject;
import otus.annotations.UrlPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import otus.support.DiScooped;

@UrlPage("/lessons")
public class CoursePage extends AbsBasePage<CoursePage> {

  @Inject
  public CoursePage(DiScooped diScooped) {
    super(diScooped);
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
