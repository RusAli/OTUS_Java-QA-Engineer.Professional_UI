package pages;

import annotations.UrlPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@UrlPage("/")
public class MainPage extends AbsBasePage<MainPage> {

  public MainPage(WebDriver driver) {
    super(driver);
  }

  public static String mainPageTitle = "Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям";

  @FindBy(xpath = "//div[contains(text(), 'Каталог курсов')]")
  WebElement coursesCatalog;


  @Step(value = "Открыть главную страницу")
  public CoursesCatalogPage clickOnCoursesCatalog() {

    actions.scrollToElement(coursesCatalog).moveToElement(coursesCatalog).click().perform();

    return new CoursesCatalogPage(driver);
  }


}
