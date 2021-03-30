package com.chenyi.study.toolkit.utils;

public class MD5Utils {

    private static String algorithmName = "md5";   //指定散列算法为MD5,还有别的算法如：SHA256、SHA1、SHA512
    private static int hashIterations = 2;     //散列迭代次数 md5(md5(pwd)): new Md5Hash(pwd, salt, 2).toString()

    //加密：输入明文得到密文
    public static String encodePassword(String pwd, String salt) {
        //user.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = null;
//                new SimpleHash(
//                algorithmName,
//                pwd,
//                ByteSource.Util.bytes(salt),
//                hashIterations).toHex();
        return newPassword;
    }

    public static void main(String[] args) {
        final String encodePassword = encodePassword("123", "chenyi52021984-323b-40d5-848f-c59b05654dd2");
        System.out.println("encodePassword = " + encodePassword);
    }
}
