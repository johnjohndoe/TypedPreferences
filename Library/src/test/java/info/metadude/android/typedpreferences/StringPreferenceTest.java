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
public class StringPreferenceTest extends PreferenceTest {

    protected static final String PREFERENCES_KEY =
            BuildConfig.APPLICATION_ID + ".TEST_KEY_STRING";
    protected StringPreference mPreference;
    protected final String mTestValue = "Hello World";
    protected final String mDefaultValue = "Empty";

    @Before
    public void beforeEach() {
        final SharedPreferences sharedPreferences = getSharedPreferences();
        mPreference = new StringPreference(sharedPreferences, PREFERENCES_KEY, mDefaultValue);
    }

    @Test
    public void expect_Preference_To_BeInitialized() throws Exception {
        assertNotNull(mPreference);
    }

    @Test
    public void expect_Preference_To_EqualDefaultValue() throws Exception {
        final SharedPreferences sharedPreferences = getSharedPreferences();
        StringPreference preference = new StringPreference(sharedPreferences, PREFERENCES_KEY);
        assertEquals(preference.get(), StringPreference.DEFAULT_VALUE_VALUE);
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
        assertEquals(mPreference.get(), mDefaultValue);
        assertNotEquals(mPreference.get(), mTestValue);
    }

    @Test
    public void expect_Preference_To_EqualValue() throws Exception {
        mPreference.set(mTestValue);
        assertEquals(mPreference.get(), mTestValue);
    }

    @Test
    public void expect_Preference_NotTo_EqualValue() throws Exception {
        mPreference.set("Something else");
        assertNotEquals(mPreference.get(), mTestValue);
    }

    @Test
    public void expect_Preference_To_BeUnset() throws Exception {
        mPreference.set(mTestValue);
        mPreference.delete();
        assertNotEquals(mPreference.get(), mTestValue);
    }

}
