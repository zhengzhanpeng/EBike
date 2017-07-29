package com.zzp.e_bike.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * 用于加密的算法
 * @author ho
 * @create 2017-07-21 11:29
 */
public class EncryptionUtil {

    /** @param source 需要加密的字符串
     * @param hashType  加密类型 （MD5 和 SHA）
     * @return
     */public static String getHash(String source, String hashType){
        StringBuilder sb = new StringBuilder();
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance(hashType);
            md5.update(source.getBytes());
            for (byte b : md5.digest()) {
                sb.append(String.format("%02X", b)); // 10进制转16进制，X 表示以十六进制形式输出，02 表示不足两位前面补0输出
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /* 获取随机生成的32位字符串，此为加密时用到的盐*/
    public static String getRandom() {
        StringBuilder sb = new StringBuilder();
        byte[] bs = SecureRandom.getSeed(16);
        for (byte b : bs) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
}
