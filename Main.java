package com.company;

public class Main {

    public static void main(String[] args) {
        new Rsa().execute("TestMessageRSA");
        new Gost94().execute("TestMessageGost94");
        new Gost12().execute("TestMessageGost12");
    }
}
