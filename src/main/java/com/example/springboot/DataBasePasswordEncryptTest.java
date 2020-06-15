package com.example.springboot;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentPBEConfig;

@Slf4j
public class DataBasePasswordEncryptTest {
    public static void main(String[] arg) {
        testDe(testEncrypt());

    }

    /**
     * 加密
     */
    public static String testEncrypt() {
        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        EnvironmentPBEConfig config = new EnvironmentPBEConfig();

        config.setAlgorithm("PBEWithMD5AndDES");          // 加密的算法，这个算法是默认的
        config.setPassword("ljk");                        // 加密的密钥
        standardPBEStringEncryptor.setConfig(config);
        String plainText = "preciousYouAreMine.96";
        String encryptedText = standardPBEStringEncryptor.encrypt(plainText);
        log.info("------加密后字符串为： " + encryptedText);
        return encryptedText;
    }

    /**
     * 解密
     */
    public static String testDe(String string) {
        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        EnvironmentPBEConfig config = new EnvironmentPBEConfig();
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setPassword("ljk");
        standardPBEStringEncryptor.setConfig(config);
        String plainText = standardPBEStringEncryptor.decrypt(string);
        log.info("------解密后字符串为： " + plainText);
        return plainText;
    }
}
