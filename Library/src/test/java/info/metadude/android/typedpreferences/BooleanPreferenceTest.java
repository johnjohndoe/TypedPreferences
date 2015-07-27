package info.metadude.android.typedpreferences;

import android.content.SharedPreferences;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricGradleTestRunner.class)
@Config(
        constants = BuildConfig.class,
        sdk = BuildConfig.ROBOLECTRIC_EMULATE_SDK_VERSION
)
public class BooleanPreferenceTest extends PreferenceTest {

    protected static final String PREFERENCES_KEY =
            BuildConfig.APPLICATION_ID + ".TEST_KEY_BOOLEAN";
    protected BooleanPreference mPreference;
    protected final boolean mTestValue = true;
    protected final boolean mDefaultValue = false;

    @Before
    public void beforeEach() {
        final SharedPreferences sharedPreferences = getSharedPreferences();
        mPreference = new BooleanPreference(sharedPreferences, PREFERENCES_KEY, mDefaultValue);
    }

    @Test
    public void expect_Preference_To_BeInitialized() throws Exception {
        assertNotNull(mPreference);
    }

    @Test
    public void expect_Preference_To_EqualDefaultValue() throws Exception {
        final SharedPreferences sharedPreferences = getSharedPreferences();
        BooleanPreference preference = new BooleanPreference(sharedPreferences, PREFERENCES_KEY);
        assertEquals(preference.get(), BooleanPreference.DEFAULT_VALUE_VALUE);
    }

    @Test
    public void expect_Preference_NotTo_BeSet() throws Exception {
        assertFalse(mPreference.isSet());
    }

    @Test
    public void expect_Preference_To_BeSet() throws Exception {
        mPreference.set(false);
        assertTrue(mPreference.isSet());
    }

    @Test
    public void expect_Preference_To_EqualDefaultValue_BeforeBeingSet() throws Exception {
        assertFalse(mPreference.get());
        assertEquals(mPreference.get(), mDefaultValue);
    }

    @Test
    public void expect_Preference_To_EqualValue() throws Exception {
        mPreference.set(mTestValue);
        assertTrue(mPreference.get());
    }

    @Test
    public void expect_Preference_NotTo_EqualValue() throws Exception {
        mPreference.set(false);
        assertFalse(mPreference.get());
    }

    @Test
    public void expect_Preference_To_BeUnset() throws Exception {
        mPreference.set(mTestValue);
        mPreference.delete();
        assertFalse(mPreference.get());
    }

}
