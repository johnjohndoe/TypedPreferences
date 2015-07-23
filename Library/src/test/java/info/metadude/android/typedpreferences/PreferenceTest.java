package info.metadude.android.typedpreferences;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import org.robolectric.Robolectric;

public abstract class PreferenceTest {

    public SharedPreferences getSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(Robolectric.application);
    }

}
