package pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbsBasePage<MainPage> {
  public MainPage(WebDriver driver) {
    super(driver);
  }

  private static final String PAGE_TITLE = "Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям";

  @FindBy(xpath = "//div[contains(text(), 'OK')]/ancestor::button")
  WebElement legalCookie;
  @FindBy(xpath = "//div[contains(text(), 'Каталог курсов')]")
  WebElement coursesCatalog;

  @Step(value = "Открыть главную страницу")
  public MainPage openMainPage() {
    driver.get(baseUrl);
    return this;
  }

  @Step(value = "Проверить заголовок")
  public MainPage checkTitle() {

    Assertions.assertEquals(PAGE_TITLE, driver.getTitle());
    return this;
  }

  @Step(value = "Открыть главную страницу")
  public CoursesCatalogPage clickOnCoursesCatalog() {

    actions.scrollToElement(coursesCatalog).moveToElement(coursesCatalog).click().perform();

    return new CoursesCatalogPage(driver);
  }

  public MainPage acceptCookiesPolices() {
    standartWaiter.waitForElementClickable(legalCookie);
    legalCookie.click();

    return this;
  }


}
