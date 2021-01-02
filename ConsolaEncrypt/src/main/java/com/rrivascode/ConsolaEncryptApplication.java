package com.rrivascode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.MessageDigest;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

@SpringBootApplication
public class ConsolaEncryptApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ConsolaEncryptApplication.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
 
		byte[] x = cifra("eyJhbGciOiJIUzUxMiJ9.eyJhcHAiOiJFQ1UiLCJzZWMiOmZhbHNlLCJzdWIiOiJFQ1VDT0xERlVTSU9OIiwiYXVkIjoidW5rbm93biIsImNoa3MiOnRydWUsImlzcyI6IkJhbnJlZ2lvIiwidGlwIjp0cnVlLCJpYXQiOjE1OTUyODEyNTIsImp0aSI6InJNTWJreWl3VmtwV0NoOUxXeGQ0WXFuY3JQRU9JWEFER2s3OG8vSUxwL0ZqVXlzL1lDSzdMY3NBVkR1S0JuMU4ifQ.mcCyO1wK5ozDIjQib88DtIg0paG77DPK7PyEIjoAJVNEiZSJRGNUgO-P6Z7o-qkm8txlBWLmLtHHGot8cLgWTg");
		System.out.println("Token Cifrado");
		System.out.println(x);
		System.out.println(x);
 		
		String y = descifra(x);
		System.out.println("Token Descifrado");
		System.out.println(y);
		System.out.println(y);
		
		
		
	}
	
	public byte[] cifra(String sinCifrar) throws Exception {
		final byte[] bytes = sinCifrar.getBytes("UTF-8");
		final Cipher aes = obtieneCipher(true);
		final byte[] cifrado = aes.doFinal(bytes);
		return cifrado;
	}

	public String descifra(byte[] cifrado) throws Exception {
		final Cipher aes = obtieneCipher(false);
		final byte[] bytes = aes.doFinal(cifrado);
		final String sinCifrar = new String(bytes, "UTF-8");
		return sinCifrar;
	}

	private Cipher obtieneCipher(boolean paraCifrar) throws Exception {
		final String frase = "FraseLargaConDiferentesLetrasNumerosYCaracteresEspeciales_áÁéÉíÍóÓúÚüÜñÑ1234567890!#%$&()=%_NO_USAR_ESTA_FRASE!_";
		final MessageDigest digest = MessageDigest.getInstance("SHA");
		digest.update(frase.getBytes("UTF-8"));
		final SecretKeySpec key = new SecretKeySpec(digest.digest(), 0, 16, "AES");

		final Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
		if (paraCifrar) {
			aes.init(Cipher.ENCRYPT_MODE, key);
		} else {
			aes.init(Cipher.DECRYPT_MODE, key);
		}

		return aes;
	}
	
	
	

}
