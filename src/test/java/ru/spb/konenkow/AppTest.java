package ru.spb.konenkow;


import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Unit test for simple App.
 */
public class AppTest

{
    @Test
    public void testReadingConf() throws Exception {
        App app = new App();
        assertNotNull("Incorrect reading config",App.getProperties());

    }
}
