package info.metadude.android.typedpreferences;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
public abstract class AbstractPreferenceTest {

    protected static final String PREFERENCES_KEY =
            "info.metadude.android.typedpreferences.TEST_KEY";
    protected TypedPreference mPreference;

    @Before
    public abstract void beforeEach();

    @Test
    public void expect_Preference_To_BeInitialized() throws Exception {
        assertNotNull(mPreference);
    }

    @Test
    public abstract void expect_Preference_To_EqualDefaultValue() throws Exception;

    @Test
    public void expect_Preference_NotTo_BeSet() throws Exception {
        assertFalse(mPreference.isSet());
    }

    @Test
    public abstract void expect_Preference_To_BeSet() throws Exception;

    @Test
    public abstract void expect_Preference_To_EqualDefaultValue_BeforeBeingSet() throws Exception;

    @Test
    public abstract void expect_Preference_To_EqualValue() throws Exception;

    @Test
    public abstract void expect_Preference_NotTo_EqualValue() throws Exception;

    @Test
    public abstract void expect_Preference_To_BeUnset() throws Exception;

}
