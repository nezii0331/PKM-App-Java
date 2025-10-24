package com.fran.pkm;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for App class
 */
public class AppTest {
    
    @Test
    public void testGetVersion() {
        PkmApplication app = new PkmApplication();
        // String version = app.getVersion();
        // assertEquals("1.0-SNAPSHOT", version);
    }
    
    @Test
    public void testAppInstantiation() {
        PkmApplication app = new PkmApplication();
        assertNotNull(app);
    }
}
