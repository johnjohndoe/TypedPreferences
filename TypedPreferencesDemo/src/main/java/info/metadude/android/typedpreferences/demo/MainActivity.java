package info.metadude.android.typedpreferences.demo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView androidVersionTextView =
                (TextView) findViewById(R.id.android_version_text_view);
        final EditText androidVersionEditText =
                (EditText) findViewById(R.id.android_version_edit_text);

        final Button submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                final String androidVersion = androidVersionEditText.getText().toString();
                androidVersionTextView.setText(androidVersion);
            }
        });
    }

}
