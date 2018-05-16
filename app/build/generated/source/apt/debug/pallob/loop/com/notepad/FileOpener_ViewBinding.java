// Generated code from Butter Knife. Do not modify!
package pallob.loop.com.notepad;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FileOpener_ViewBinding implements Unbinder {
  private FileOpener target;

  private View view2131165250;

  private View view2131165248;

  private View view2131165247;

  @UiThread
  public FileOpener_ViewBinding(FileOpener target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public FileOpener_ViewBinding(final FileOpener target, View source) {
    this.target = target;

    View view;
    target.filedirlist = Utils.findRequiredViewAsType(source, R.id.filedirlist, "field 'filedirlist'", ListView.class);
    view = Utils.findRequiredView(source, R.id.filehome, "field 'filehome' and method 'onViewClicked'");
    target.filehome = Utils.castView(view, R.id.filehome, "field 'filehome'", Button.class);
    view2131165250 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.filecancel, "field 'filecancel' and method 'onViewClicked'");
    target.filecancel = Utils.castView(view, R.id.filecancel, "field 'filecancel'", Button.class);
    view2131165248 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fileback, "field 'fileback' and method 'onViewClicked'");
    target.fileback = Utils.castView(view, R.id.fileback, "field 'fileback'", Button.class);
    view2131165247 = view;
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
    FileOpener target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.filedirlist = null;
    target.filehome = null;
    target.filecancel = null;
    target.fileback = null;

    view2131165250.setOnClickListener(null);
    view2131165250 = null;
    view2131165248.setOnClickListener(null);
    view2131165248 = null;
    view2131165247.setOnClickListener(null);
    view2131165247 = null;
  }
}
