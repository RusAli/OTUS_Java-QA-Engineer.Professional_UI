package otus.steps.pages;

import com.google.inject.Inject;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import otus.pages.MainPage;
import otus.support.DiScooped;

public class MainPageSteps {

  @Inject
  public MainPage mainPage;

  @Inject
  public DiScooped diScooped;

  @Пусть("Открыта главная страница")
  public void openMainPage() {
    mainPage.open();
  }

  @Тогда("Подтверждаем куки")
  public void acceptCookies() {
    mainPage.acceptCookiesPolices();
  }


}
