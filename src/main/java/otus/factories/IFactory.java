package otus.factories;

import org.openqa.selenium.WebDriver;

public interface IFactory<T extends WebDriver> {

  T create();
}
