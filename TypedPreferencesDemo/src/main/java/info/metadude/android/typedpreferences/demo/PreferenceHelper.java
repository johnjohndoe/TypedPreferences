package info.metadude.android.typedpreferences.demo;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import info.metadude.android.typedpreferences.StringPreference;

public class PreferenceHelper {

    protected static final String PREF_KEY_USER_INPUT =
            BuildConfig.APPLICATION_ID + ".USER_INPUT";

    protected final StringPreference mUserInputPreference;

    public PreferenceHelper(@NonNull final SharedPreferences mSharedPreferences) {
        mUserInputPreference = new StringPreference(
                mSharedPreferences, PREF_KEY_USER_INPUT);
    }

    public void storeUserInput(@NonNull final String userInput) {
        mUserInputPreference.set(userInput);
    }

    public
    @NonNull
    String restoreUserInput() {
        return mUserInputPreference.get();
    }

    public boolean storesUserInput() {
        return mUserInputPreference.isSet();
    }

}
