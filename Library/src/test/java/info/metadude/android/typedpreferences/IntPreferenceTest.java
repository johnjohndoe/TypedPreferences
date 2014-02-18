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
public class IntPreferenceTest extends AbstractPreferenceTest {

    protected final int mTestValue = 42;
    protected final int mDefaultValue = 23;

    @Before @Override
    public void beforeEach() {
        final SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(Robolectric.application);
        mPreference = new IntPreference(sharedPreferences, PREFERENCES_KEY, mDefaultValue);
    }

    @Test @Override
    public void expect_Preference_To_BeInitialized() throws Exception {
        assertNotNull(mPreference);
    }

    @Test @Override
    public void expect_Preference_To_EqualDefaultValue() throws Exception {
        final SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(Robolectric.application);
        IntPreference preference = new IntPreference(sharedPreferences, PREFERENCES_KEY);
        final int value = preference.get();
        assertEquals(value, IntPreference.DEFAULT_VALUE_VALUE);
    }

    @Test @Override
    public void expect_Preference_To_BeSet() throws Exception {
        ((IntPreference) mPreference).set(mTestValue);
        assertTrue(mPreference.isSet());
    }

    @Test @Override
    public void expect_Preference_To_EqualDefaultValue_BeforeBeingSet() throws Exception {
        final int value = (Integer) mPreference.get();
        assertEquals(value, mDefaultValue);
        assertNotEquals(value, mTestValue);
    }

    @Test @Override
    public void expect_Preference_To_EqualValue() throws Exception {
        ((IntPreference) mPreference).set(mTestValue);
        final int value = (Integer) mPreference.get();
        assertEquals(value, mTestValue);
    }

    @Test @Override
    public void expect_Preference_NotTo_EqualValue() throws Exception {
        ((IntPreference) mPreference).set(55);
        assertNotEquals(mPreference.get(), mTestValue);
    }

    @Test @Override
    public void expect_Preference_To_BeUnset() throws Exception {
        ((IntPreference) mPreference).set(mTestValue);
        mPreference.delete();
        assertNotEquals(mPreference.get(), mTestValue);
    }

}
