package info.metadude.android.typedpreferences;

import android.content.SharedPreferences;

/**
 * A wrapper class for a boolean preference.
 */
public class BooleanPreference extends BasePreference {

    protected final boolean mDefaultValue;
    public static final boolean DEFAULT_VALUE_VALUE = false;

    /**
     * Constructs a {@code boolean} preference for the given key
     * having the default value set to {@code false} available.
     */
    public BooleanPreference(final SharedPreferences preferences, final String key) {
        this(preferences, key, DEFAULT_VALUE_VALUE);
    }

    /**
     * Constructs a {@code boolean} preference for the given key
     * having the default value available.
     */
    public BooleanPreference(final SharedPreferences preferences, final String key, boolean defaultValue) {
        super(preferences, key);
        mDefaultValue = defaultValue;
    }

    /**
     * Returns the stored {@code boolean} value if it exists
     * or the default value.
     */
    public boolean get() {
        return mPreferences.getBoolean(mKey, mDefaultValue);
    }

    /**
     * Stores the given {@code boolean} value asynchronously.
     */
    public void set(boolean value) {
        mPreferences.edit().putBoolean(mKey, value).apply();
    }

}
