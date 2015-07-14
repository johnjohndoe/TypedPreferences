package info.metadude.android.typedpreferences;

import android.content.SharedPreferences;

/**
 * A wrapper class for a {@code short} preference that reuses IntPreference.
 */
public class ShortPreference {

    protected final IntPreference mIntPreference;
    public static final short DEFAULT_VALUE_VALUE = (short) IntPreference.DEFAULT_VALUE_VALUE;

    /**
     * Constructs a {@code short} preference for the given key
     */
    public ShortPreference(final SharedPreferences preferences, final String key) {
        this(preferences, key, DEFAULT_VALUE_VALUE);
    }

    /**
     * Constructs a {@code short} preference for the given key
     * having the default value available.
     */
    public ShortPreference(final SharedPreferences preferences, final String key, int defaultValue) {
        mIntPreference = new IntPreference(preferences, key, defaultValue);
    }

    /**
     * Returns the stored {@code short} value if it exists
     * or the default value.
     */
    public short get() {
        return (short) mIntPreference.get();
    }

    /**
     * Returns {@code true} if some value is stored for
     * this preference, otherwise {@code false}.
     */
    public boolean isSet() {
        return mIntPreference.isSet();
    }

    /**
     * Stores the given {@code short} value asynchronously.
     */
    public void set(final short value) {
        mIntPreference.set(value);
    }

    /**
     * Removes this preference setting asynchronously.
     */
    public void delete() {
        mIntPreference.delete();
    }

}
