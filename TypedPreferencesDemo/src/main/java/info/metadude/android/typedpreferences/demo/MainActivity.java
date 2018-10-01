package info.metadude.android.typedpreferences.demo;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.storage_current_value)
    TextView storageValueTextView;

    @BindView(R.id.user_input)
    EditText userInputEditText;

    private PreferenceHelper mPreferenceHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setIcon(R.drawable.ic_launcher);
        }
        mPreferenceHelper = ((DemoApplication) getApplication())
                .getPreferenceHelper();
    }

    @Override
    protected void onResume() {
        super.onResume();
        restorePreferences();
    }

    @Override
    protected void onPause() {
        storePreferences();
        super.onPause();
    }

    @OnClick(R.id.submit_user_input)
    public void onUserInputSubmit() {
        Editable userInput = userInputEditText.getText();
        if (!TextUtils.isEmpty(userInput)) {
            String text = userInput.toString();
            storageValueTextView.setText(text);
        }
    }

    private void restorePreferences() {
        if (mPreferenceHelper.storesUserInput()) {
            storageValueTextView.setText(mPreferenceHelper.restoreUserInput());
        }
    }

    private void storePreferences() {
        mPreferenceHelper.storeUserInput(storageValueTextView.getText().toString());
    }

}
