package components.standart;

import annotations.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Component(value = "//footer")
public class FooterComponent extends AbsBaseComponent<FooterComponent> {

  public FooterComponent(WebDriver driver) {
    super(driver);
  }

  private String footerSiteMapLocator = baseComponentLocator;

  public FooterComponent moveToFooterSiteMap() {

    WebElement element = driver.findElement(By.xpath(footerSiteMapLocator));
    actions.scrollToElement(element).moveToElement(element).perform();

    return this;
  }

  public void clickOnFooterElementByName(String name) {

    WebElement element = driver.findElement(By.xpath(String.format("//div[contains(text(), '%s')]", name)));
    actions.moveToElement(element).click().perform();
  }

}
