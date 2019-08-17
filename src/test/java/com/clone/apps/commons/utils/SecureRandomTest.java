package com.clone.apps.commons.utils;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;
import static org.junit.Assert.*;

/**
 * Created by kh.jin on 2019. 7. 1.
 */
public class SecureRandomTest {
    private final Logger log = LoggerFactory.getLogger(SecureRandomTest.class);

    @Test
    public void test_secure_random() {

        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        log.info("salt : {}", salt);
        assertNotNull(salt);
    }
}
