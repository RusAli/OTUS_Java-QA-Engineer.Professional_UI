package pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class CoursesCatalogPage extends AbsBasePage<CoursesCatalogPage> {

  public CoursesCatalogPage(WebDriver driver) {
    super(driver);
  }

  @Step(value = "Проверить заголовок курсов")
  public CoursesCatalogPage checkTitle() {

    Assertions.assertEquals("Обучение всех типов по направлению программирование любого уровня продолжительностью от 1 до 15 месяцев",
            driver.getTitle());

    return this;
  }



}
