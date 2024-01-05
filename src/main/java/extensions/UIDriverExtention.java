package extensions;

import annotations.Driver;
import factories.WebDriverFactory;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

public class UIDriverExtention implements BeforeEachCallback, AfterEachCallback, IGetAnnotatedFields {

  private WebDriver driver = null;

  @Override
  public Set<Field> getAnnotatedFields(Class<? extends Annotation> annotation, ExtensionContext extensionContext) {
    Set<Field> fields = new HashSet<>();
    Class<?> testclasses = extensionContext.getTestClass().get();

    for (Field field : testclasses.getDeclaredFields()) {
      if (field.isAnnotationPresent(annotation)) {
        fields.add(field);
      }
    }
    return fields;
  }

  @Override
  public void beforeEach(ExtensionContext extensionContext) throws Exception {

    driver = new WebDriverFactory().create();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

    Set<Field> fieldsToInject = getAnnotatedFields(Driver.class, extensionContext);

    for (Field field : fieldsToInject) {
      if (field.getType().getName().equals(WebDriver.class.getName())) {
        field.setAccessible(true);
        field.set(extensionContext.getTestInstance().get(), driver);
      }
    }
  }

  @Override
  public void afterEach(ExtensionContext extensionContext) throws Exception {
    if (driver != null) {
      driver.close();
      driver.quit();
    }
  }
}
