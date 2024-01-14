package pages;

import annotations.UrlPage;
import org.openqa.selenium.WebDriver;

@UrlPage("/")
public class MainPage extends AbsBasePage<MainPage> {

  public MainPage(WebDriver driver) {
    super(driver);
  }
}
