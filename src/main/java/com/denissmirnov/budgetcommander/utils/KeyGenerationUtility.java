package com.denissmirnov.budgetcommander.utils;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyPairGeneratorSpi;

public class KeyGenerationUtility {
    public static KeyPair generateRsaKey(){
        KeyPair keyPair;
        try{
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            keyPair = keyPairGenerator.generateKeyPair();
        }catch(Exception e){
            throw new IllegalStateException();
        }

        return keyPair;
    }
}
