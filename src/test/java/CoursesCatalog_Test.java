import annotations.Driver;
import extensions.UIDriverExtention;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@ExtendWith(UIDriverExtention.class)
public class CoursesCatalog_Test {

  @Driver
  private WebDriver driver;

  String url = "https://otus.ru/";


  @Test
  @Story("Allure test")
  void testgg() throws InterruptedException {

    driver.get(url);
    Thread.sleep(3000);
    driver.findElement(By.xpath("//div[contains(text(), 'Каталог курсов')]")).click();
    Thread.sleep(3000);
    System.out.println(driver.getTitle());

  }

}
