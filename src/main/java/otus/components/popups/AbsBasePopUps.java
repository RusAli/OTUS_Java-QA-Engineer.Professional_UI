package otus.components.popups;

import com.google.inject.Inject;
import otus.support.DiScooped;
import otus.utils.AbsBaseUtils;

public abstract class AbsBasePopUps<T> extends AbsBaseUtils implements IPopUp<T> {

  @Inject
  public AbsBasePopUps(DiScooped diScooped) {
    super(diScooped);
  }
}
