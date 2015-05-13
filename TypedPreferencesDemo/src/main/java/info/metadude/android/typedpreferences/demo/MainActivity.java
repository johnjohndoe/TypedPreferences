package info.metadude.android.typedpreferences.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected TextView mAndroidVersionTextView;
    protected EditText mAndroidVersionEditText;
    protected PreferenceHelper mPreferenceHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPreferenceHelper = getApp().getPreferenceHelper();
        mAndroidVersionTextView = (TextView) findViewById(R.id.android_version_text_view);
        mAndroidVersionEditText = (EditText) findViewById(R.id.android_version_edit_text);

        final Button submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                final String androidVersion = mAndroidVersionEditText.getText().toString();
                mAndroidVersionTextView.setText(androidVersion);
            }
        });
    }

    @Override protected void onResume() {
        super.onResume();
        restoreAndroidVersion();
    }

    @Override protected void onPause() {
        storeAndroidVersion();
        super.onPause();
    }

    protected void restoreAndroidVersion() {
        if (!mPreferenceHelper.storesAndroidVersion()) {
            return;
        }
        String androidVersion = mPreferenceHelper.restoreAndroidVersion();
        mAndroidVersionTextView.setText(androidVersion);
    }

    protected void storeAndroidVersion() {
        final String androidVersion = mAndroidVersionEditText.getText().toString();
        mPreferenceHelper.storeAndroidVersion(androidVersion);
    }

    protected TypedPreferencesDemoApplication getApp() {
        return (TypedPreferencesDemoApplication) getApplication();
    }

}
