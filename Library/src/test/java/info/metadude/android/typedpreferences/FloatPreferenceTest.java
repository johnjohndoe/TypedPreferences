package info.metadude.android.typedpreferences;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
public class FloatPreferenceTest extends AbstractPreferenceTest {

    protected final float mTestValue = 23.23f;
    protected final float mDefaultValue = 42.42f;
    protected final float mDelta = 0f;

    @Before @Override
    public void beforeEach() {
        final SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(Robolectric.application);
        mPreference = new FloatPreference(sharedPreferences, PREFERENCES_KEY, mDefaultValue);
    }

    @Test @Override
    public void expect_Preference_To_BeInitialized() throws Exception {
        assertNotNull(mPreference);
    }

    @Test @Override
    public void expect_Preference_To_EqualDefaultValue() throws Exception {
        final SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(Robolectric.application);
        FloatPreference preference = new FloatPreference(sharedPreferences, PREFERENCES_KEY);
        assertEquals(preference.get(), FloatPreference.DEFAULT_VALUE_VALUE, mDelta);
    }

    @Test @Override
    public void expect_Preference_To_BeSet() throws Exception {
        ((FloatPreference) mPreference).set(mTestValue);
        assertTrue(mPreference.isSet());
    }

    @Test @Override
    public void expect_Preference_To_EqualDefaultValue_BeforeBeingSet() throws Exception {
        final float value = (Float) mPreference.get();
        assertEquals(value, mDefaultValue, mDelta);
        assertNotEquals(value, mTestValue);
    }

    @Test @Override
    public void expect_Preference_To_EqualValue() throws Exception {
        ((FloatPreference) mPreference).set(mTestValue);
        final float value = (Float) mPreference.get();
        assertEquals(value, mTestValue, mDelta);
    }

    @Test @Override
    public void expect_Preference_NotTo_EqualValue() throws Exception {
        ((FloatPreference) mPreference).set(77.77f);
        final float value = (Float) mPreference.get();
        assertNotEquals(value, mTestValue, mDelta);
    }

    @Test @Override
    public void expect_Preference_To_BeUnset() throws Exception {
        ((FloatPreference) mPreference).set(mTestValue);
        mPreference.delete();
        assertNotEquals(mPreference.get(), mTestValue);
    }

}
