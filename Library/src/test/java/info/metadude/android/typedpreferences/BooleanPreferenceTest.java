package info.metadude.android.typedpreferences;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
public class BooleanPreferenceTest extends AbstractPreferenceTest {

    protected final boolean mTestValue = true;
    protected final boolean mDefaultValue = false;

    @Before @Override
    public void beforeEach() {
        final SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(Robolectric.application);
        mPreference = new BooleanPreference(sharedPreferences, PREFERENCES_KEY, mDefaultValue);
    }

    @Test @Override
    public void expect_Preference_To_BeInitialized() throws Exception {
        assertNotNull(mPreference);
    }

    @Test @Override
    public void expect_Preference_To_EqualDefaultValue() throws Exception {
        final SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(Robolectric.application);
        BooleanPreference preference = new BooleanPreference(sharedPreferences, PREFERENCES_KEY);
        assertEquals(preference.get(), BooleanPreference.DEFAULT_VALUE_VALUE);
    }

    @Test @Override
    public void expect_Preference_NotTo_BeSet() throws Exception {
        assertFalse(mPreference.isSet());
    }

    @Test @Override
    public void expect_Preference_To_BeSet() throws Exception {
        ((BooleanPreference) mPreference).set(false);
        assertTrue(mPreference.isSet());
    }

    @Test @Override
    public void expect_Preference_To_EqualDefaultValue_BeforeBeingSet() throws Exception {
        assertFalse((Boolean) mPreference.get());
        assertEquals(((BooleanPreference) mPreference).get(), mDefaultValue);
    }

    @Test @Override
    public void expect_Preference_To_EqualValue() throws Exception {
        ((BooleanPreference) mPreference).set(mTestValue);
        assertTrue(((BooleanPreference) mPreference).get());
    }

    @Test @Override
    public void expect_Preference_NotTo_EqualValue() throws Exception {
        ((BooleanPreference) mPreference).set(false);
        assertFalse((Boolean) mPreference.get());
    }

    @Test @Override
    public void expect_Preference_To_BeUnset() throws Exception {
        ((BooleanPreference) mPreference).set(mTestValue);
        mPreference.delete();
        assertFalse((Boolean) mPreference.get());
    }

}
