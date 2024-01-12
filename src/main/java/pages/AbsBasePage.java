package pages;

import annotations.UrlPage;
import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AbsBaseUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class AbsBasePage<T> extends AbsBaseUtils {

  private final String baseUrl = System.getProperty("webdriver.base.url");
  private final String legalCookieLocator = "//div[contains(text(), 'OK')]/ancestor::button";

  public AbsBasePage(WebDriver driver) {
    super(driver);
  }

  @Step(value = "Открыть страницу")
  public T open() {
    driver.get(getBaseUrl() + getUrlPrefix());
    return (T) page(getClass());
  }

  @Step(value = "Подтвердить куки на странице")
  public T acceptCookiesPolices() {
    standartWaiter.waitingForElement(By.xpath(legalCookieLocator)).click();
    return (T) page(getClass());
  }

  public T checkTitle(String title) {
    Assertions.assertEquals(title, driver.getTitle());
    return (T) page(getClass());
  }

  public String getBaseUrl() {
    return StringUtils.stripEnd(baseUrl, "/");
  }

  private String getUrlPrefix() {
    UrlPage annotatedPage = getClass().getAnnotation(UrlPage.class);
    if (annotatedPage != null) {
      return annotatedPage.value();
    }
    return "";
  }

  private <T> T page(Class<T> clazz) {
    try {
      Constructor<T> constructor = clazz.getConstructor(WebDriver.class);
      return clazz.cast(constructor.newInstance(driver));
    } catch (NoSuchMethodException | IllegalAccessException | InstantiationException
             | InvocationTargetException e) {
      e.printStackTrace();
    }
    return null;
  }
}
