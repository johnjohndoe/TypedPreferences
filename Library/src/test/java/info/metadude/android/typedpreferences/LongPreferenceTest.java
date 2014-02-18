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
public class LongPreferenceTest extends AbstractPreferenceTest {

    protected final long mTestValue = 23L;
    protected final long mDefaultValue = 42L;

    @Before @Override
    public void beforeEach() {
        final SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(Robolectric.application);
        mPreference = new LongPreference(sharedPreferences, PREFERENCES_KEY, mDefaultValue);
    }

    @Test @Override
    public void expect_Preference_To_BeInitialized() throws Exception {
        assertNotNull(mPreference);
    }

    @Test @Override
    public void expect_Preference_To_EqualDefaultValue() throws Exception {
        final SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(Robolectric.application);
        LongPreference preference = new LongPreference(sharedPreferences, PREFERENCES_KEY);
        assertEquals((long) preference.get(), LongPreference.DEFAULT_VALUE_VALUE);
    }

    @Test @Override
    public void expect_Preference_To_BeSet() throws Exception {
        ((LongPreference) mPreference).set(mTestValue);
        assertTrue(mPreference.isSet());
    }

    @Test @Override
    public void expect_Preference_To_EqualDefaultValue_BeforeBeingSet() throws Exception {
        final long value = (Long) mPreference.get();
        assertEquals(value, mDefaultValue);
        assertNotEquals(value, mTestValue);
    }

    @Test @Override
    public void expect_Preference_To_EqualValue() throws Exception {
        ((LongPreference) mPreference).set(mTestValue);
        final long value = (Long) mPreference.get();
        assertEquals(value, mTestValue);
    }

    @Test @Override
    public void expect_Preference_NotTo_EqualValue() throws Exception {
        ((LongPreference) mPreference).set(77L);
        final long value = (Long) mPreference.get();
        assertNotEquals(value, mTestValue);
    }

    @Test @Override
    public void expect_Preference_To_BeUnset() throws Exception {
        ((LongPreference) mPreference).set(mTestValue);
        mPreference.delete();
        final long value = (Long) mPreference.get();
        assertNotEquals(value, mTestValue);
    }

}
