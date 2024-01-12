package pages;

import annotations.UrlPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@UrlPage("/catalog/courses")
public class CoursesCatalogPage extends AbsBasePage<CoursesCatalogPage> {

  public CoursesCatalogPage(WebDriver driver) {
    super(driver);
  }

  public static String courseCatalogTitle = "Обучение всех типов по направлению программирование любого уровня продолжительностью от 1 до 15 месяцев";

  @FindBy(xpath = "//label[contains(text(), 'Все направления')]/..//input")
  WebElement allVectors;

  @FindBy(xpath = "//label[contains(text(), 'Программирование')]/..//input")
  WebElement programming;

  @FindBy(xpath = "//label[contains(text(), 'Архитектура')]/..//input")
  WebElement arhitech;


  public CoursesCatalogPage markAllVectors() {

    allVectors.click();
    return this;
  }

  public CoursesCatalogPage markArhitech() {
    actions.moveToElement(arhitech).click().perform();
    return this;
  }

  public CoursesCatalogPage markProgramming() {
    actions.moveToElement(programming).click().perform();
    return this;
  }


}
