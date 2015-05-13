package info.metadude.android.typedpreferences.demo;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import info.metadude.android.typedpreferences.StringPreference;

public class PreferenceHelper {

    protected final SharedPreferences mSharedPreferences;

    protected static final String PREF_KEY_ANDROID_VERSION =
            BuildConfig.APPLICATION_ID + ".ANDROID_VERSION";

    public PreferenceHelper(Context applicationContext) {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
    }

    public void storeAndroidVersion(final String androidVersion) {
        StringPreference pref = new StringPreference(mSharedPreferences, PREF_KEY_ANDROID_VERSION);
        pref.set(androidVersion);
    }

    public String restoreAndroidVersion() {
        StringPreference pref = new StringPreference(mSharedPreferences, PREF_KEY_ANDROID_VERSION);
        return pref.get();
    }

    public boolean storesAndroidVersion() {
        StringPreference pref = new StringPreference(mSharedPreferences, PREF_KEY_ANDROID_VERSION);
        return pref.isSet();
    }

}
