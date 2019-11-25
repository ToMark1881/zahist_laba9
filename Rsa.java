package com.company;

import org.apache.commons.codec.digest.DigestUtils;

import java.math.BigInteger;

public class Rsa {

    public void execute(String text) {
        BigInteger d = new BigInteger("1266711491819178437", 10);
        BigInteger n = new BigInteger("8b86e91fc7cc883b96f8948eee8fb2bb", 16);
        BigInteger e = new BigInteger("103927237252362863277916442357768249901", 10);
        byte[] hash = DigestUtils.md5(text);
        BigInteger hashIntValue = bytesToHex(hash);
        System.out.println("А generating hash from received message and transforming into number = " + hashIntValue.toString());
        BigInteger s = hashIntValue.modPow(d, n);
        System.out.println("А is sending received message to B =  " + text + " and digital signature s = " + s);
        System.out.println("B generating hash from received message and transforming into number = " + hashIntValue.toString());
        System.out.println("B generating hash1 = " + s.modPow(e, n).toString() + " and matching with hash = " + hashIntValue.toString().equals(s.modPow(e, n).toString()));
        System.out.println("\n");
    }

    public static void main(String... args) {
        new Rsa().execute("TestMessageRSA");
    }

    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static BigInteger bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new BigInteger(new String(hexChars), 16);
    }

}
