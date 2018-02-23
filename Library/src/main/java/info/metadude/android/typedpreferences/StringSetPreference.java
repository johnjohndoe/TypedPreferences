package info.metadude.android.typedpreferences;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build;

import java.util.Collections;
import java.util.Set;

/**
 * A wrapper class for a Set<String> preference.
 */
public class StringSetPreference {

    protected final SharedPreferences mPreferences;
    protected final String mKey;
    protected final Set<String> mDefaultValue;
    public static final Set<String> DEFAULT_VALUE_VALUE = Collections.emptySet();

    /**
     * Constructs a {@code Set<String>} preference for the given key
     * having the default value set to an empty string available.
     */
    public StringSetPreference(final SharedPreferences preferences, final String key) {
        this(preferences, key, DEFAULT_VALUE_VALUE);
    }

    /**
     * Constructs a {@code Set<String>} preference for the given key
     * having the default value available.
     */
    public StringSetPreference(final SharedPreferences preferences, final String key, final Set<String> defaultValue) {
        mPreferences = preferences;
        mKey = key;
        mDefaultValue = defaultValue;
    }

    /**
     * Returns the stored {@code Set<String>} value if it exists
     * or the default value.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public Set<String> get() {
        return mPreferences.getStringSet(mKey, mDefaultValue);
    }

    /**
     * Returns {@code true} if some value is stored for
     * this preference, otherwise {@code false}.
     */
    public boolean isSet() {
        return mPreferences.contains(mKey);
    }

    /**
     * Stores the given {@code Set<String>} value asynchronously.
     */
    public void set(final Set<String> value) {
        mPreferences.edit().putStringSet(mKey, value).apply();
    }

    /**
     * Removes this preference setting asynchronously.
     */
    public void delete() {
        mPreferences.edit().remove(mKey).apply();
    }

}
