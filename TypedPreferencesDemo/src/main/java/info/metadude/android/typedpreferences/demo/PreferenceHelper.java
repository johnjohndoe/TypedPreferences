package info.metadude.android.typedpreferences.demo;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import info.metadude.android.typedpreferences.StringPreference;

public class PreferenceHelper {

    protected final SharedPreferences mSharedPreferences;

    protected static final String PREF_KEY_ANDROID_VERSION =
            BuildConfig.APPLICATION_ID + ".ANDROID_VERSION";

    protected final StringPreference mAndroidVersionPreference;

    public PreferenceHelper(Context applicationContext) {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        mAndroidVersionPreference = new StringPreference(
                mSharedPreferences, PREF_KEY_ANDROID_VERSION);
    }

    public void storeAndroidVersion(final String androidVersion) {
        mAndroidVersionPreference.set(androidVersion);
    }

    public String restoreAndroidVersion() {
        return mAndroidVersionPreference.get();
    }

    public boolean storesAndroidVersion() {
        return mAndroidVersionPreference.isSet();
    }

}
