package info.metadude.android.typedpreferences;

import android.content.SharedPreferences;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricGradleTestRunner.class)
@Config(
        constants = BuildConfig.class,
        sdk = BuildConfig.ROBOLECTRIC_EMULATE_SDK_VERSION
)
public class LongPreferenceTest extends PreferenceTest {

    protected static final String PREFERENCES_KEY =
            BuildConfig.APPLICATION_ID + ".TEST_KEY_LONG";
    protected LongPreference mPreference;
    protected final long mTestValue = 23L;
    protected final long mDefaultValue = 42L;
    protected final long mDelta = 0L;

    @Before
    public void beforeEach() {
        final SharedPreferences sharedPreferences = getSharedPreferences();
        mPreference = new LongPreference(sharedPreferences, PREFERENCES_KEY, mDefaultValue);
    }

    @Test
    public void expect_Preference_To_BeInitialized() throws Exception {
        assertNotNull(mPreference);
    }

    @Test
    public void expect_Preference_To_EqualDefaultValue() throws Exception {
        final SharedPreferences sharedPreferences = getSharedPreferences();
        LongPreference preference = new LongPreference(sharedPreferences, PREFERENCES_KEY);
        assertEquals(preference.get(), LongPreference.DEFAULT_VALUE_VALUE, mDelta);
    }

    @Test
    public void expect_Preference_NotTo_BeSet() throws Exception {
        assertFalse(mPreference.isSet());
    }

    @Test
    public void expect_Preference_To_BeSet() throws Exception {
        mPreference.set(mTestValue);
        assertTrue(mPreference.isSet());
    }

    @Test
    public void expect_Preference_To_EqualDefaultValue_BeforeBeingSet() throws Exception {
        final long value = mPreference.get();
        assertEquals(value, mDefaultValue);
        assertNotEquals(value, mTestValue);
    }

    @Test
    public void expect_Preference_To_EqualValue() throws Exception {
        mPreference.set(mTestValue);
        final long value = mPreference.get();
        assertEquals(value, mTestValue);
    }

    @Test
    public void expect_Preference_NotTo_EqualValue() throws Exception {
        mPreference.set(77L);
        final long value = mPreference.get();
        assertNotEquals(value, mTestValue);
    }

    @Test
    public void expect_Preference_To_BeUnset() throws Exception {
        mPreference.set(mTestValue);
        mPreference.delete();
        final long value = mPreference.get();
        assertNotEquals(value, mTestValue);
    }

}
