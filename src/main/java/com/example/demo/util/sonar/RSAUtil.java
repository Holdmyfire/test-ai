package com.example.demo.util.sonar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public final class RSAUtil {


    private RSAUtil() {
    }

    private static final int KEY_SIZE = 1024;
    private static final Map<Integer, String> keyMap = new HashMap<>();

    public static void genKeyPair() {
        try {
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
            keyPairGen.initialize(KEY_SIZE, new SecureRandom());
            KeyPair keyPair = keyPairGen.generateKeyPair();
            RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
            RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
            String publicKeyString = encryptBASE64(publicKey.getEncoded());
            String privateKeyString = encryptBASE64(privateKey.getEncoded());
            keyMap.put(0, publicKeyString);
            keyMap.put(1, privateKeyString);
        } catch (Exception e) {
            throw new RSAKeyGenerationException("Error generating key pair", e);
        }
    }

    public static String encryptBASE64(byte[] key) {
        return Base64.getEncoder().encodeToString(key);
    }

    public static byte[] decryptBASE64(String key) {
        return Base64.getDecoder().decode(key);
    }

    public static String encrypt(String str, String publicKey) {
        try {
            byte[] decoded = decryptBASE64(publicKey);
            RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            return encryptBASE64(cipher.doFinal(str.getBytes(java.nio.charset.StandardCharsets.UTF_8)));
        } catch (Exception e) {
            throw new RSAEncryptionException("Encryption error", e);
        }
    }

    public static String decrypt(String str, String privateKey) {
        try {
            byte[] inputByte = decryptBASE64(str);
            byte[] decoded = decryptBASE64(privateKey);
            RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher.init(Cipher.DECRYPT_MODE, priKey);
            return new String(cipher.doFinal(inputByte), java.nio.charset.StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RSADecryptionException("Decryption error", e);
        }
    }

    public static void main(String[] args) {
        long temp = System.currentTimeMillis();
        genKeyPair();
        System.out.println("公钥："+keyMap.get(0));
        System.out.println("私钥："+keyMap.get(1));
        System.out.println("生成密钥消耗时间:"+(System.currentTimeMillis() - temp) / 1000.0+"秒");


        String message = "RSA测试aaa";
        System.out.println("原文:,"+message );


        temp = System.currentTimeMillis();
        String messageEn = encrypt(message, keyMap.get(0));
        System.out.println("密文:{}"+messageEn);
        System.out.println("加密消耗时间:"+(System.currentTimeMillis() - temp) / 1000.0);

        temp = System.currentTimeMillis();
        String messageDe = decrypt(messageEn, keyMap.get(1));
        System.out.println("解密:"+messageDe);
        System.out.println("解密消耗时间:"+(System.currentTimeMillis() - temp) / 1000.0);
    }

    public static class RSAKeyGenerationException extends RuntimeException {
        public RSAKeyGenerationException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class RSAEncryptionException extends RuntimeException {
        public RSAEncryptionException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class RSADecryptionException extends RuntimeException {
        public RSADecryptionException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}