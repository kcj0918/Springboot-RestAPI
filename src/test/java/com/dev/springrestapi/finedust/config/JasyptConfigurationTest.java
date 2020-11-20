package com.dev.springrestapi.finedust.config;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Ignore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class JasyptConfigurationTest {
    @Autowired
    StringEncryptor jasyptStringEncryptor;

//    @Test
//    @DisplayName("설정_파일_암호화_테스트")
//    @Ignore
//    public void application_properties_encryptTest() throws Exception {
//        String url = "jdbc:mysql://freelect-springboot2-webservice-replaction.crlsnywg8dgw.ap-northeast-1.rds.amazonaws.com:3306/localservice";
//        String userName = "eunho";
//        String password = "spring1234";
//
//        String encryptedUrl = jasyptStringEncryptor.encrypt(url);
//        String decryptedUrl = jasyptStringEncryptor.decrypt(encryptedUrl);
//        String encryptedUserName = jasyptStringEncryptor.encrypt(userName);
//        String decryptedUserName = jasyptStringEncryptor.decrypt(encryptedUserName);
//        String encryptedPassword = jasyptStringEncryptor.encrypt(password);
//        String decryptedPassword = jasyptStringEncryptor.decrypt(encryptedPassword);
//
//        System.out.println("encryptedUrl : " + encryptedUrl);
//        System.out.println("decryptedUrl : " + decryptedUrl);
//        System.out.println("encryptedUserName : " + encryptedUserName);
//        System.out.println("decryptedUserName : " + decryptedUserName);
//        System.out.println("encryptedPassword : " + encryptedPassword);
//        System.out.println("decryptedPassword : " + decryptedPassword);
//    }
}
