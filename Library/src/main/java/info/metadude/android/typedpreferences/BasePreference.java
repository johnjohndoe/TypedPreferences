package info.metadude.android.typedpreferences;

import android.content.SharedPreferences;

class BasePreference {

    protected final SharedPreferences mPreferences;
    protected final String mKey;

    public BasePreference(final SharedPreferences preferences, final String key) {
        mPreferences = preferences;
        mKey = key;
    }

    /**
     * Returns {@code true} if some value is stored for
     * this preference, otherwise {@code false}.
     */
    public boolean isSet() {
        return mPreferences.contains(mKey);
    }

    /**
     * Removes this preference setting asynchronously.
     */
    public void delete() {
        mPreferences.edit().remove(mKey).apply();
    }

}
