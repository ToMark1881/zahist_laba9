package com.company;

import javafx.util.Pair;

import java.math.BigInteger;
import java.util.Random;

public class Gost12 {

    public void execute(String text) {
        int h = getHash(text);
        int q = 47;
        int e = h % q;
        int k = new Random().nextInt(q);
        Pair<Integer, Integer> c = new Pair<>(16, 16);
        int r = c.getKey() % q;
        int d = 10;
        int s = (r * d + k * e) % q;
        System.out.println("Sending message = " + text + " и r = " + r + "; s = " + s + ";");
        int h1 = getHash(text);
        int e1 = h1 % q;
        BigInteger e11 = BigInteger.ONE;
        while (BigInteger.valueOf(e1).multiply(e11).mod(BigInteger.valueOf(q)).intValue() != 1) {
            e11 = e11.add(BigInteger.ONE);
        }
        int v = e11.mod(BigInteger.valueOf(q)).intValue();
        int z1 = (s * v) % q;
        int z2 = ((q - r) * v) % q;
        Pair<Integer, Integer> c1 = new Pair<>(16, 16);
        int r1 = c1.getKey() % q;
        System.out.println("If r’ = r: " + r1 + " = " + r + ", then receiver B thinks that received message T’ = T and it delivered by А.");
        System.out.println("\n");
    }

    public static void main(String[] args) {
        new Gost12().execute("TestMessageGOST12");
    }

    private int getHash(String text) {
        return text.length();
    }

}
