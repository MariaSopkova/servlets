package ru.innopolis.stc.service.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {
    private HashUtil(){

    }
    public static String stringToMD5(String password){
        byte[] digest = new byte[0];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(password.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger bigInteger = new BigInteger(1, digest);
        String res = bigInteger.toString(16);
        while (res.length() < 32){
            res = "0" + res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(HashUtil.stringToMD5("HarryPotter"));
    }
}