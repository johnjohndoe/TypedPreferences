package info.metadude.android.typedpreferences;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

@Config(emulateSdk = 18)
@RunWith(RobolectricTestRunner.class)
public class RoboTest {

    @Test
    public void testTrueIsTrue() throws Exception {
        assertEquals(true, true);
    }

}
