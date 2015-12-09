package info.metadude.android.typedpreferences.demo;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import info.metadude.android.typedpreferences.StringPreference;

public class PreferenceHelper {

    protected static final String PREF_KEY_ANDROID_VERSION =
            BuildConfig.APPLICATION_ID + ".ANDROID_VERSION";

    protected final StringPreference mAndroidVersionPreference;

    public PreferenceHelper(@NonNull final SharedPreferences mSharedPreferences) {
        mAndroidVersionPreference = new StringPreference(
                mSharedPreferences, PREF_KEY_ANDROID_VERSION);
    }

    public void storeAndroidVersion(@NonNull final String androidVersion) {
        mAndroidVersionPreference.set(androidVersion);
    }

    public @NonNull String restoreAndroidVersion() {
        return mAndroidVersionPreference.get();
    }

    public boolean storesAndroidVersion() {
        return mAndroidVersionPreference.isSet();
    }

}
