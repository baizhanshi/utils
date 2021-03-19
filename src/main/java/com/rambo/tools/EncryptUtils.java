package com.rambo.tools;

import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;

/**
 * MD5.getInstance().getMD5String（）也可以用作MD5加密
 * @author ：baizhanshi
 * @date ：Created in 2021/3/10 14:33
 */
@Slf4j
public class EncryptUtils {
    private static final String ENCRYPT_ERROR = "密码加密异常";

    private EncryptUtils() {
        throw new IllegalStateException("EncryptUtils class");
    }

    /**
     * 加密
     * 
     * @param encName
     * @param message
     * @return
     */
    public static String encrypt(String encName, String message) {
        MessageDigest md = null;
        String encrypted = null;
        byte[] bt = message.getBytes();

        try {
            if (encName == null || encName.equals("")) {
                encName = "SHA-256";
            }

            md = MessageDigest.getInstance(encName);
            md.update(bt);
            encrypted = byteArrayToHexString(md.digest());
            return encrypted;
        } catch (Exception var6) {
            log.error("密码加密异常", var6);
            throw new RuntimeException(ENCRYPT_ERROR);
        }
    }

    /**
     * 加密
     * 
     * @param origin
     * @return
     */
    public static String encode(String origin) {
        String resultString = null;

        try {
            MessageDigest ex = MessageDigest.getInstance("MD5");
            resultString = origin.trim();
            resultString = byteArrayToHexString(ex.digest(resultString.getBytes("UTF-8")));
            return resultString;
        } catch (Exception var3) {
            log.error("密码加密异常", var3);
            throw new RuntimeException(ENCRYPT_ERROR);
        }
    }

    public static String byteArrayToHexString(byte[] bts) {
        StringBuilder des = new StringBuilder();
        String tmp = null;

        for (int i = 0; i < bts.length; ++i) {
            tmp = Integer.toHexString(bts[i] & 255);
            if (tmp.length() == 1) {
                des.append("0");
            }

            des.append(tmp);
        }

        return des.toString();
    }
}
