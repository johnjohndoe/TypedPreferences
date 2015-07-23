package info.metadude.android.typedpreferences;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import org.robolectric.RuntimeEnvironment;

public abstract class PreferenceTest {

    public SharedPreferences getSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(RuntimeEnvironment.application);
    }

}
