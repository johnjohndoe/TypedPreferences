package info.metadude.android.typedpreferences;

import android.content.SharedPreferences;

/**
 * A wrapper class for a long preference.
 */
public class LongPreference {

    protected final SharedPreferences mPreferences;
    protected final String mKey;
    protected final long mDefaultValue;
    public static final long DEFAULT_VALUE_VALUE = 0L;

    /**
     * Constructs a {@code long} preference for the given key
     * having the default value set to {@code 0} available.
     */
    public LongPreference(final SharedPreferences preferences, final String key) {
        this(preferences, key, DEFAULT_VALUE_VALUE);
    }

    /**
     * Constructs a {@code long} preference for the given key
     * having the default value available.
     */
    public LongPreference(final SharedPreferences preferences, final String key, long defaultValue) {
        mPreferences = preferences;
        mKey = key;
        mDefaultValue = defaultValue;
    }

    /**
     * Returns the stored {@code long} value if it exists
     * or the default value.
     */
    public long get() {
        return mPreferences.getLong(mKey, mDefaultValue);
    }

    /**
     * Returns {@code true} if some value is stored for
     * this preference, otherwise {@code false}.
     */
    public boolean isSet() {
        return mPreferences.contains(mKey);
    }

    /**
     * Stores the given {@code long} value asynchronously.
     */
    public void set(long value) {
        mPreferences.edit().putLong(mKey, value).apply();
    }

    /**
     * Removes this preference setting asynchronously.
     */
    public void delete() {
        mPreferences.edit().remove(mKey).apply();
    }

}
