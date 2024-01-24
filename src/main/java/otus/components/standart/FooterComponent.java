package otus.components.standart;

import otus.annotations.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import otus.support.DiScooped;

@Component(value = "//footer")
public class FooterComponent extends AbsBaseComponent<FooterComponent> {

  private DiScooped diScooped;

  public FooterComponent(DiScooped diScooped) {
    super(diScooped);
    this.diScooped = diScooped;
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
