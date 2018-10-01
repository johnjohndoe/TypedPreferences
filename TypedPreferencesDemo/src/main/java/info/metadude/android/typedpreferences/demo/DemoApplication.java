package info.metadude.android.typedpreferences.demo;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class DemoApplication extends Application {

    private PreferenceHelper mPreferenceHelper;

    public PreferenceHelper getPreferenceHelper() {
        if (mPreferenceHelper == null) {
            SharedPreferences sharedPreferences =
                    PreferenceManager.getDefaultSharedPreferences(this);
            mPreferenceHelper = new PreferenceHelper(sharedPreferences);
        }
        return mPreferenceHelper;
    }

}
