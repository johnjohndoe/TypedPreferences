package info.metadude.android.typedpreferences.demo;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PreferenceHelper {

    protected final SharedPreferences mSharedPreferences;

    public PreferenceHelper(Context applicationContext) {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
    }

    public void storeAndroidVersion(final String androidVersion) {
        throw new IllegalStateException("Not yet implemented");
    }

    public String restoreAndroidVersion() {
        throw new IllegalStateException("Not yet implemented");
    }

    public boolean storesAndroidVersion() {
        throw new IllegalStateException("Not yet implemented");
    }

}
