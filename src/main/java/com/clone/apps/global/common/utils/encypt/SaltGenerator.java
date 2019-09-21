package com.clone.apps.global.common.utils.encypt;

import java.nio.charset.Charset;
import java.util.Random;

/**
 * Created by kh.jin on 2019. 7. 1.
 */
public class SaltGenerator {

    private final static int DEFAULT_LENGTH = 10;

    public static String generate() {
        return SaltGenerator.generate(DEFAULT_LENGTH);
    }

    public static String generate(int len) {
        byte[] array = new byte[len];
        new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }
}