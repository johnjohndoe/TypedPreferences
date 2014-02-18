package info.metadude.android.typedpreferences;

import android.content.SharedPreferences;

/**
 * A wrapper class for a int preference.
 */
public class IntPreference implements TypedPreference<Integer> {

    protected final SharedPreferences mPreferences;
    protected final String mKey;
    protected final int mDefaultValue;
    public static final int DEFAULT_VALUE_VALUE = 0;

    /**
     * Constructs a {@code int} preference for the given key
     * having the default value set to zero available.
     */
    public IntPreference(final SharedPreferences preferences, final String key) {
        this(preferences, key, DEFAULT_VALUE_VALUE);
    }

    /**
     * Constructs a {@code int} preference for the given key
     * having the default value available.
     */
    public IntPreference(final SharedPreferences preferences, final String key, int defaultValue) {
        mPreferences = preferences;
        mKey = key;
        mDefaultValue = defaultValue;
    }

    /**
     * Returns the stored {@code int} value if it exists
     * or the default value.
     */
    public Integer get() {
        return mPreferences.getInt(mKey, mDefaultValue);
    }

    /**
     * Returns {@code true} if some value is stored for
     * this preference, otherwise {@code false}.
     */
    public boolean isSet() {
        return mPreferences.contains(mKey);
    }

    /**
     * Stores the given {@code int} value.
     */
    public void set(final Integer value) {
        mPreferences.edit().putInt(mKey, value).commit();
    }

    /**
     * Removes this preference setting.
     */
    public void delete() {
        mPreferences.edit().remove(mKey).commit();
    }

}
