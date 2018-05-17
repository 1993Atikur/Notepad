package pallob.loop.com.notepad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by pallob on 5/17/18.
 */

public class ReadMode extends Activity {
    Intent intent;
    String Display = "";
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.readmode);
        ButterKnife.bind(this);
        intent = getIntent();
        Display = intent.getStringExtra("Display");
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setText(Display);

    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void onBackPressed() {

    }
}
