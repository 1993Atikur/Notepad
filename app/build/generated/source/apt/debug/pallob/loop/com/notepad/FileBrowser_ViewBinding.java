// Generated code from Butter Knife. Do not modify!
package pallob.loop.com.notepad;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FileBrowser_ViewBinding implements Unbinder {
  private FileBrowser target;

  private View view2131230804;

  private View view2131230801;

  private View view2131230806;

  private View view2131230802;

  private View view2131230851;

  @UiThread
  public FileBrowser_ViewBinding(FileBrowser target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public FileBrowser_ViewBinding(final FileBrowser target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.filehome, "field 'filehome' and method 'onViewClicked'");
    target.filehome = Utils.castView(view, R.id.filehome, "field 'filehome'", Button.class);
    view2131230804 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fileback, "field 'fileback' and method 'onViewClicked'");
    target.fileback = Utils.castView(view, R.id.fileback, "field 'fileback'", Button.class);
    view2131230801 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.filedirlist = Utils.findRequiredViewAsType(source, R.id.filedirlist, "field 'filedirlist'", ListView.class);
    target.filename = Utils.findRequiredViewAsType(source, R.id.filename, "field 'filename'", EditText.class);
    view = Utils.findRequiredView(source, R.id.filesave, "field 'filesave' and method 'onViewClicked'");
    target.filesave = Utils.castView(view, R.id.filesave, "field 'filesave'", Button.class);
    view2131230806 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.filecancel, "field 'filecancel' and method 'onViewClicked'");
    target.filecancel = Utils.castView(view, R.id.filecancel, "field 'filecancel'", Button.class);
    view2131230802 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.newfolder, "field 'newfolder' and method 'onViewClicked'");
    target.newfolder = Utils.castView(view, R.id.newfolder, "field 'newfolder'", Button.class);
    view2131230851 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mainlayout = Utils.findRequiredViewAsType(source, R.id.mainlayout, "field 'mainlayout'", LinearLayout.class);
    target.layoutprogress = Utils.findRequiredViewAsType(source, R.id.layoutprogress, "field 'layoutprogress'", LinearLayout.class);
    target.spinner = Utils.findRequiredViewAsType(source, R.id.spinner, "field 'spinner'", Spinner.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FileBrowser target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.filehome = null;
    target.fileback = null;
    target.filedirlist = null;
    target.filename = null;
    target.filesave = null;
    target.filecancel = null;
    target.newfolder = null;
    target.mainlayout = null;
    target.layoutprogress = null;
    target.spinner = null;

    view2131230804.setOnClickListener(null);
    view2131230804 = null;
    view2131230801.setOnClickListener(null);
    view2131230801 = null;
    view2131230806.setOnClickListener(null);
    view2131230806 = null;
    view2131230802.setOnClickListener(null);
    view2131230802 = null;
    view2131230851.setOnClickListener(null);
    view2131230851 = null;
  }
}
