package com.rambo.tools;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/**
 * @author ：baizhanshi
 * @date ：Created in 2021/3/10 14:31
 */
@Slf4j
public class AESEncryptUtils {
    private static final String DEFAULT_CHARSET = "UTF-8";

    private AESEncryptUtils() {
    }

    public static String encrypt(String token, String content) {
        try {
            byte[] e = content.getBytes(Charset.forName(DEFAULT_CHARSET));
            byte[] tokenBytes = token.getBytes(Charset.forName(DEFAULT_CHARSET));
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(tokenBytes);
            byte[] md5Bytes = md5.digest();
            SecretKeySpec secretKey = new SecretKeySpec(md5Bytes, 0,
                    Math.min(md5Bytes.length, Cipher.getMaxAllowedKeyLength("AES") / 8), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(1, secretKey);
            byte[] encryptedByte = cipher.doFinal(e);
            byte[] encryptedBytes = Base64.encodeBase64(encryptedByte, false);
            return new String(encryptedBytes, Charset.forName(DEFAULT_CHARSET));
        } catch (Exception var10) {
            log.info(">>>encrypt is error...", var10);
            return "";
        }
    }

    public static String decrypt(String token, String content) {
        try {
            byte[] e = content.getBytes(Charset.forName(DEFAULT_CHARSET));
            byte[] decryptBase64Byte = Base64.decodeBase64(e);
            byte[] tokenBytes = token.getBytes(Charset.forName(DEFAULT_CHARSET));
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(tokenBytes);
            byte[] md5Bytes = md5.digest();
            SecretKeySpec secretKey = new SecretKeySpec(md5Bytes, 0,
                    Math.min(md5Bytes.length, Cipher.getMaxAllowedKeyLength("AES") / 8), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(2, secretKey);
            byte[] decryptBytes = cipher.doFinal(decryptBase64Byte);
            return new String(decryptBytes, Charset.forName(DEFAULT_CHARSET));
        } catch (Exception var10) {
            log.info(">>>decrypt is error... ", var10);
            return "";
        }
    }
}
