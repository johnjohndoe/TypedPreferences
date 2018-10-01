package info.metadude.android.typedpreferences.demo;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import info.metadude.android.typedpreferences.StringPreference;

class PreferenceHelper {

    private static final String PREF_KEY_USER_INPUT =
            BuildConfig.APPLICATION_ID + ".USER_INPUT";

    private final StringPreference mUserInputPreference;

    PreferenceHelper(@NonNull final SharedPreferences mSharedPreferences) {
        mUserInputPreference = new StringPreference(
                mSharedPreferences, PREF_KEY_USER_INPUT);
    }

    void storeUserInput(@NonNull final String userInput) {
        mUserInputPreference.set(userInput);
    }

    @NonNull
    String restoreUserInput() {
        return mUserInputPreference.get();
    }

    boolean storesUserInput() {
        return mUserInputPreference.isSet();
    }

}
