package info.metadude.android.typedpreferences;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@Config(emulateSdk = BuildConfig.ROBOLECTRIC_EMULATE_SDK_VERSION)
@RunWith(RobolectricTestRunner.class)
public class StringSetPreferenceTest {

    protected static final String PREFERENCES_KEY =
            BuildConfig.APPLICATION_ID + ".TEST_KEY_STRING_SET";
    protected StringSetPreference mPreference;
    protected final Set<String> mTestValue = new HashSet<>(
            Arrays.asList(new String[]{ "A", "B", "C", "D", "E" })
    );
    protected final Set<String> mDefaultValue = new HashSet<>(
            Arrays.asList(new String[]{ "1", "2", "3", "4", "5" })
    );

    @Before
    public void beforeEach() {
        final SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(Robolectric.application);
        mPreference = new StringSetPreference(sharedPreferences, PREFERENCES_KEY, mDefaultValue);
    }

    @Test
    public void expect_Preference_To_BeInitialized() throws Exception {
        assertNotNull(mPreference);
    }

    @Test
    public void expect_Preference_To_EqualDefaultValue() throws Exception {
        final SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(Robolectric.application);
        StringSetPreference preference = new StringSetPreference(sharedPreferences, PREFERENCES_KEY);
        assertEquals(preference.get(), StringSetPreference.DEFAULT_VALUE_VALUE);
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
        mPreference.set(new HashSet<>(
                Arrays.asList(new String[]{ "!", "@", "#", "$", "%" })
        ));
        assertNotEquals(mPreference.get(), mTestValue);
    }

    @Test
    public void expect_Preference_To_BeUnset() throws Exception {
        mPreference.set(mTestValue);
        mPreference.delete();
        assertNotEquals(mPreference.get(), mTestValue);
    }

}
