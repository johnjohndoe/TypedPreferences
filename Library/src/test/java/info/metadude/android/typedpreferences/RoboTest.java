package info.metadude.android.typedpreferences;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

@RunWith(RobolectricGradleTestRunner.class)
@Config(
        constants = BuildConfig.class,
        sdk = BuildConfig.ROBOLECTRIC_EMULATE_SDK_VERSION
)
public class RoboTest {

    @Test
    public void testTrueIsTrue() throws Exception {
        assertEquals(true, true);
    }

}
