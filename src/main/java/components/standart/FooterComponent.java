package components.standart;

import annotations.Component;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Component(value = "//footer")
public class FooterComponent extends AbsBaseComponent<FooterComponent> {

  public FooterComponent(WebDriver driver) {
    super(driver);
  }

  private String footerSiteMapLocator = baseComponentLocator;

  @Step("Переместиться в footer сайта")
  public FooterComponent moveToFooterSiteMap() {

    WebElement element = driver.findElement(By.xpath(footerSiteMapLocator));
    actions.scrollToElement(element).moveToElement(element).perform();

    return this;
  }

  @Step("Нажать по элементу {name}")
  public void clickOnFooterElementByName(String name) {

    WebElement element = driver.findElement(By.xpath(String.format("//div[contains(text(), '%s')]", name)));
    actions.moveToElement(element).click().perform();
  }

}
