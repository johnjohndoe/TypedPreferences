package info.metadude.android.typedpreferences;

import android.content.SharedPreferences;

/**
 * A wrapper class to store and restore a double value in preferences.
 */
public class DoublePreference implements TypedPreference<Double> {

    protected LongPreference mLongPreference;
    public static final double DEFAULT_VALUE_VALUE = 0d;

    public DoublePreference(SharedPreferences preferences, String key) {
        this(preferences, key, DEFAULT_VALUE_VALUE);
    }

    public DoublePreference(SharedPreferences preferences, String key, double defaultValue) {
        mLongPreference = new LongPreference(preferences, key, Double.doubleToLongBits(defaultValue));
    }

    public Double get() {
        return Double.longBitsToDouble(mLongPreference.get());
    }

    public boolean isSet() {
        return mLongPreference.isSet();
    }

    public void set(Double value) {
        mLongPreference.set(Double.doubleToLongBits(value));
    }

    public void delete() {
        mLongPreference.delete();
    }

}
