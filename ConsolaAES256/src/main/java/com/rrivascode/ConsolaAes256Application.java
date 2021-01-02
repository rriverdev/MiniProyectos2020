package com.rrivascode;

import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsolaAes256Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ConsolaAes256Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		String originalString = "eyJhbGciOiJIUzUxMiJ9.eyJhcHAiOiJFQ1UiLCJzZWMiOmZhbHNlLCJzdWIiOiJFQ1VDT0xERlVTSU9OIiwiYXVkIjoidW5rbm93biIsImNoa3MiOnRydWUsImlzcyI6IkJhbnJlZ2lvIiwidGlwIjp0cnVlLCJpYXQiOjE1OTUyODEyNTIsImp0aSI6InJNTWJreWl3VmtwV0NoOUxXeGQ0WXFuY3JQRU9JWEFER2s3OG8vSUxwL0ZqVXlzL1lDSzdMY3NBVkR1S0JuMU4ifQ.mcCyO1wK5ozDIjQib88DtIg0paG77DPK7PyEIjoAJVNEiZSJRGNUgO-P6Z7o-qkm8txlBWLmLtHHGot8cLgWTg";
		String fforiginalString = "0.2.0.1"; 
//		String token="sBZJ0U0iSfDm4KBohH3TBx89yKrapE7ipcSTOZ6THWlbF73Rk1w7+rCKJWHSZFXXkMdcCHSNcaDLzdUDTSe1DK+Ik8/MiTdfaKt4SBI0AIks/rV2JNToUYowLuQ/4U63pw69WnI7D/mIh3QUf3EGSrYCNLUlOqLLdGsJWDXE5EexomMMsi0adXTeBGqv72BjHnb+TS+RQxddXXtLwfqaKJ1+Qnwpop1E9tqRVjl57lZi/LDa34AOD0RWADzuvsuwgz804g2fU7xuQdpU1YjtmT9FPxrruC4Fdk/1/XWY/rJgeSBqhroG9fUHue3C2BGylKWsLYb+cXovd84n1Tzi41ekfbAkLJXDNzaMUZ7I7VGkGBx4RkJF5fZUA8H3+w5uQ4hIBu+ZvDL9HM4toaSEqPTpnH7nSoBPrTRMwjap9HDwdyqUHf4aGbrLh8JNmVzicwcMKZ1UISl9Pgivn49qLvxpfxs8JP5Rb7jnA+l2vok=";
				
	    String encryptedString = encrypt(originalString, secretKey) ;
	    String decryptedString = decrypt(encryptedString, secretKey) ;
	      
	    System.out.println(originalString);
	    System.out.println(encryptedString);
//	    System.out.println(token);
	    System.out.println(decryptedString);
	    
		
	}

	private static String secretKey = "#$%&/()=?¡";
	private static String salt = "FX_SALT_SIBAMEX_21_ECU_MS_NEXT";
	 
	public static String encrypt(String strToEncrypt, String secret) 
	{
	    try
	    {
	        byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
//	        byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0  };
	        IvParameterSpec ivspec = new IvParameterSpec(iv);
	         
//	        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
	        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
//	        KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 65536, 256);
	        KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 1024, 256);
	        SecretKey tmp = factory.generateSecret(spec);
	        SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
	         
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
	        return DatatypeConverter.printBase64Binary(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
//	        return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
	    } 
	    catch (Exception e) 
	    {
	        System.out.println("Error while encrypting: " + e.toString());
	    }
	    return null;
	}
	
	public static String decrypt(String strToDecrypt, String secret) {
	    try
	    {
	        byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
//	    	byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0  };
	        IvParameterSpec ivspec = new IvParameterSpec(iv);
	         
//	        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
	        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
//	        KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 65536, 256);
	        KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 1024, 256);
	        SecretKey tmp = factory.generateSecret(spec);
	        SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
	         
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
	        
	        
	        return new String(cipher.doFinal(DatatypeConverter.parseBase64Binary(strToDecrypt)));
//	        return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
	    } 
	    catch (Exception e) {
	        System.out.println("Error while decrypting: " + e.toString());
	    }
	    return null;
	}
	
}
