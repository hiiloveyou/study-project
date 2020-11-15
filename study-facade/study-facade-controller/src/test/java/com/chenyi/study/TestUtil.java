package com.chenyi.study;

import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author chenyi
 * @date 2020/11/15
 */
public class TestUtil {
    public static void main(String[] args) {
        final byte[] decode = Hex.decode("124");

        final Md5Hash md5Hash = new Md5Hash("123", "cd2131e0-4368-4789-8765-a51bafc29c89", 2);
//        Hex.encode()


    }
}
