// Generated code from Butter Knife. Do not modify!
package pallob.loop.com.notepad;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ReadMode_ViewBinding implements Unbinder {
  private ReadMode target;

  private View view2131230760;

  @UiThread
  public ReadMode_ViewBinding(ReadMode target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ReadMode_ViewBinding(final ReadMode target, View source) {
    this.target = target;

    View view;
    target.textView = Utils.findRequiredViewAsType(source, R.id.textView, "field 'textView'", TextView.class);
    view = Utils.findRequiredView(source, R.id.button, "field 'button' and method 'onViewClicked'");
    target.button = Utils.castView(view, R.id.button, "field 'button'", Button.class);
    view2131230760 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ReadMode target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.textView = null;
    target.button = null;

    view2131230760.setOnClickListener(null);
    view2131230760 = null;
  }
}
