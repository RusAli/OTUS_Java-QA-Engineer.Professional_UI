package otus.pages;

import com.google.inject.Inject;
import otus.annotations.UrlPage;
import otus.support.DiScooped;

@UrlPage("/")
public class MainPage extends AbsBasePage<MainPage> {

  @Inject
  public MainPage(DiScooped diScooped) {
    super(diScooped);
  }
}
