package com.clone.apps.global.utils.encypt;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kh.jin on 2019. 7. 2.
 */
public class SHA256HelperTest {

    @Test
    public void test_인자에_salt를_전달하지않은경우() throws Exception{
        String source = "a1";
        String result = SHA256Helper.getInstance().encypt(source);
        assertEquals(64, result.length());
    }

    @Test
    public void test_인자에_salt를_전달하는경우() throws Exception{
        String source = "a1";
        String result = SHA256Helper.getInstance().encypt(source, SaltGenerator.generate());
        assertEquals(64, result.length());
    }
}