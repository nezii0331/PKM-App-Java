package com.fran.pkm;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for App class
 */
public class AppTest {
    
    @Test
    public void testGetVersion() {
        App app = new App();
        String version = app.getVersion();
        assertEquals("1.0-SNAPSHOT", version);
    }
    
    @Test
    public void testAppInstantiation() {
        App app = new App();
        assertNotNull(app);
    }
}
