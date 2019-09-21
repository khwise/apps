package com.clone.apps.global.common.utils.encypt;

import java.security.NoSuchAlgorithmException;

/**
 * Created by kh.jin on 2019. 7. 2.
 */
public interface EncryptHelper {

    String encypt(String source) throws NoSuchAlgorithmException;
    String encypt(String source, String salt) throws NoSuchAlgorithmException;
}
