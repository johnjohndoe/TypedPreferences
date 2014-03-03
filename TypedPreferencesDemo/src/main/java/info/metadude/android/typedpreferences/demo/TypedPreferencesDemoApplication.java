package info.metadude.android.typedpreferences.demo;

import android.app.Application;

public class TypedPreferencesDemoApplication extends Application {

    protected PreferenceHelper mPreferenceHelper;

    public PreferenceHelper getPreferenceHelper() {
        if (mPreferenceHelper == null) {
            mPreferenceHelper = new PreferenceHelper(getApplicationContext());
        }
        return mPreferenceHelper;
    }

}
