package kwic;

import kwic.model.KWIC;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class AppTest
{
    /**
     * Test to make sure KWIC can run successfully.
     */
    @Test
    public void testExpectedOutput()
    {
        try {
            (new KWIC()).execute("test1.txt");
        } catch (IOException e) {
            fail("KWIC unexpectedly threw exception");
        }
    }
}
