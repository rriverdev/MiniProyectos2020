package com.rrivascode;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsoleDecripterApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ConsoleDecripterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
      String plainText = "eyJhbGciOiJIUzUxMiJ9.eyJhcHAiOiJFQ1UiLCJzZWMiOmZhbHNlLCJzdWIiOiJFQ1VDT0xERlVTSU9OIiwiYXVkIjoidW5rbm93biIsImNoa3MiOnRydWUsImlzcyI6IkJhbnJlZ2lvIiwidGlwIjp0cnVlLCJpYXQiOjE1OTUyODEyNTIsImp0aSI6InJNTWJreWl3VmtwV0NoOUxXeGQ0WXFuY3JQRU9JWEFER2s3OG8vSUxwL0ZqVXlzL1lDSzdMY3NBVkR1S0JuMU4ifQ.mcCyO1wK5ozDIjQib88DtIg0paG77DPK7PyEIjoAJVNEiZSJRGNUgO-P6Z7o-qkm8txlBWLmLtHHGot8cLgWTg";
      String encrypted;
		try {
			System.out.println(plainText);
			
			encrypted = ConsoleDecripterApplication.encrypt(plainText);
			String decrypted = ConsoleDecripterApplication.decrypt(encrypted);

			System.out.println(encrypted);
			System.out.println(decrypted);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
	}

	 private static byte[] linebreak = {}; // Remove Base64 encoder default linebreak
	 private static String secret = "tvnw63ufg9gh5392"; // secret key length must be 16
	 private static SecretKey key;
	 private static Cipher cipher;
	 private static Base64 coder;
	
	
	
	   static {
			 try {
			     key = new SecretKeySpec(secret.getBytes(), "AES");
			     cipher = Cipher.getInstance("AES/ECB/PKCS5Padding", "SunJCE");
			     coder = new Base64();
			 } catch (Throwable t) {
			     t.printStackTrace();
			 }
		 }

		 public static synchronized String encrypt(String plainText) throws Exception {
		        cipher.init(Cipher.ENCRYPT_MODE, key);
		        byte[] cipherText = cipher.doFinal(plainText.getBytes());
		        return  new String(coder.encode(cipherText));
		 }

		 public static synchronized String decrypt(String codedText) throws Exception {
		        byte[] encypted = coder.decode(codedText.getBytes());
		        cipher.init(Cipher.DECRYPT_MODE, key);
		        byte[] decrypted = cipher.doFinal(encypted);  
		        return new String(decrypted);
		 }
		 
	
}
