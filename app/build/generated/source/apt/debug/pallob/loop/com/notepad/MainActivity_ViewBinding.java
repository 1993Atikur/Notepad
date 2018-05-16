// Generated code from Butter Knife. Do not modify!
package pallob.loop.com.notepad;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2131165185;

  private View view2131165186;

  private View view2131165187;

  private View view2131165188;

  private View view2131165240;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.B1, "field 'B1' and method 'onViewClicked'");
    target.B1 = Utils.castView(view, R.id.B1, "field 'B1'", Button.class);
    view2131165185 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.B2, "field 'B2' and method 'onViewClicked'");
    target.B2 = Utils.castView(view, R.id.B2, "field 'B2'", Button.class);
    view2131165186 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.B3, "field 'B3' and method 'onViewClicked'");
    target.B3 = Utils.castView(view, R.id.B3, "field 'B3'", Button.class);
    view2131165187 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.B4, "field 'B4' and method 'onViewClicked'");
    target.B4 = Utils.castView(view, R.id.B4, "field 'B4'", Button.class);
    view2131165188 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.linearLayout = Utils.findRequiredViewAsType(source, R.id.linearLayout, "field 'linearLayout'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.editText, "field 'editText' and method 'onViewClicked'");
    target.editText = Utils.castView(view, R.id.editText, "field 'editText'", EditText.class);
    view2131165240 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.B1 = null;
    target.B2 = null;
    target.B3 = null;
    target.B4 = null;
    target.linearLayout = null;
    target.editText = null;

    view2131165185.setOnClickListener(null);
    view2131165185 = null;
    view2131165186.setOnClickListener(null);
    view2131165186 = null;
    view2131165187.setOnClickListener(null);
    view2131165187 = null;
    view2131165188.setOnClickListener(null);
    view2131165188 = null;
    view2131165240.setOnClickListener(null);
    view2131165240 = null;
  }
}
