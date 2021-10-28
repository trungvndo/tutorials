package com.trungtiendo.jasyptspringexample;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JasyptspringexampleApplicationTests {

	@Autowired
	@Qualifier("jasyptStringEncryptor")
	private StringEncryptor stringEncryptor;

	@Test
	public void testEncryptingClientId() {
		String value = "a_secret_id";
		String encryptedValue = this.stringEncryptor.encrypt(value);
		System.out.println("Encrypted value of " + value + " is: " + encryptedValue);
		String decryptedValue = this.stringEncryptor.decrypt(encryptedValue);
		Assertions.assertEquals(decryptedValue, value);
	}

	@Test
	public void testEncryptingClientSecret() {
		String value = "a_secret_secret";
		String encryptedValue = this.stringEncryptor.encrypt(value);
		System.out.println("Encrypted value of " + value + " is: " + encryptedValue);
		String decryptedValue = this.stringEncryptor.decrypt(encryptedValue);
		Assertions.assertEquals(decryptedValue, value);
	}

	@Test
	void contextLoads() {
	}

}
