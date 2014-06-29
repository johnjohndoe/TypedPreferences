package info.metadude.android.typedpreferences;

import android.content.SharedPreferences;

/**
 * A wrapper class for a String preference.
 */
public class StringPreference {

    protected final SharedPreferences mPreferences;
    protected final String mKey;
    protected final String mDefaultValue;
    public static final String DEFAULT_VALUE_VALUE = "";

    /**
     * Constructs a {@code String} preference for the given key
     * having the default value set to an empty string available.
     */
    public StringPreference(final SharedPreferences preferences, final String key) {
        this(preferences, key, DEFAULT_VALUE_VALUE);
    }

    /**
     * Constructs a {@code String} preference for the given key
     * having the default value available.
     */
    public StringPreference(final SharedPreferences preferences, final String key, final String defaultValue) {
        mPreferences = preferences;
        mKey = key;
        mDefaultValue = defaultValue;
    }

    /**
     * Returns the stored {@code String} value if it exists
     * or the default value.
     */
    public String get() {
        return mPreferences.getString(mKey, mDefaultValue);
    }

    /**
     * Returns {@code true} if some value is stored for
     * this preference, otherwise {@code false}.
     */
    public boolean isSet() {
        return mPreferences.contains(mKey);
    }

    /**
     * Stores the given {@code String} value asynchronously.
     */
    public void set(final String value) {
        mPreferences.edit().putString(mKey, value).apply();
    }

    /**
     * Removes this preference setting asynchronously.
     */
    public void delete() {
        mPreferences.edit().remove(mKey).apply();
    }

}
