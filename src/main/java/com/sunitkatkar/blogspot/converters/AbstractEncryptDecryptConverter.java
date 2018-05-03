/**
 * Copyright 2018 onwards - Sunit Katkar (sunitkatkar@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sunitkatkar.blogspot.converters;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.persistence.AttributeConverter;

/**
 * Abstract base class for implementing the JPA Attribute Converter which will
 * encrypt and decrypt an Entity attribute (table column)
 * 
 * @author Sunit Katkar, sunitkatkar@gmail.com (https://sunitkatkar.blogspot.com/)
 * @since ver 1.0 (Apr 2018)
 * @version 1.0
 * @param <X>
 */
public abstract class AbstractEncryptDecryptConverter<X>
		implements AttributeConverter<X, String> {

	/**
	 * This is the key required for encryption/decryption. This is defined here
	 * for example purpose. In production, this should come from a secure
	 * location not accessible easily. In Spring Boot, one possible location is
	 * the application.properties file. Though its not the most secure way, it
	 * will keep this key out of the actual java code.
	 */
	private static final String SECRET_ENCRYPTION_KEY = "MySuperSecretKey";

	/** CipherMaker is needed to configure and create instance of Cipher */
	private CipherMaker cipherMaker;

	/**
	 * Constructor
	 * 
	 * @param cipherMaker
	 */
	public AbstractEncryptDecryptConverter(CipherMaker cipherMaker) {
		this.cipherMaker = cipherMaker;
	}

	/**
	 * Default constructor
	 */
	public AbstractEncryptDecryptConverter() {
		this(new CipherMaker());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.persistence.AttributeConverter#convertToDatabaseColumn(java.lang.
	 * Object)
	 */
	@Override
	public String convertToDatabaseColumn(X attribute) {
		if (isNotEmpty(SECRET_ENCRYPTION_KEY) && isNotNullOrEmpty(attribute)) {
			try {
				Cipher cipher = cipherMaker.configureAndGetInstance(
						Cipher.ENCRYPT_MODE, 
						SECRET_ENCRYPTION_KEY);
				return encryptData(cipher, attribute);
			} catch (NoSuchAlgorithmException 
					| InvalidKeyException
					| InvalidAlgorithmParameterException 
					| BadPaddingException
					| NoSuchPaddingException 
					| IllegalBlockSizeException e) {
				throw new RuntimeException(e);
			}
		}
		return convertEntityAttributeToString(attribute);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.persistence.AttributeConverter#convertToEntityAttribute(java.lang.
	 * Object)
	 */
	@Override
	public X convertToEntityAttribute(String dbData) {
		if (isNotEmpty(SECRET_ENCRYPTION_KEY) && isNotEmpty(dbData)) {
			try {
				Cipher cipher = cipherMaker.configureAndGetInstance(
						Cipher.DECRYPT_MODE, 
						SECRET_ENCRYPTION_KEY);
				return decryptData(cipher, dbData);
			} catch (NoSuchAlgorithmException 
					| InvalidAlgorithmParameterException
					| InvalidKeyException 
					| BadPaddingException
					| NoSuchPaddingException 
					| IllegalBlockSizeException e) {
				throw new RuntimeException(e);
			}
		}
		return convertStringToEntityAttribute(dbData);
	}

	/**
	 * The concrete class which implements this abstract class will have to
	 * provide the implementation. For simple String encryption, the
	 * implementation is simple as apache commons lang StringUtils can be used.
	 * But this method was abstracted out as there might be other types of null
	 * check technique required when a non String entity is to be encrypted
	 * 
	 * @param attribute
	 * @return
	 */
	abstract boolean isNotNullOrEmpty(X attribute);

	/**
	 * The concrete class which implements this abstract class will have to
	 * provide the implementation. For decryption of a String, its simple as a
	 * String has to be returned, but for other non String types some more code
	 * might have to be implemented. For example, a Date type of Date string.
	 * 
	 * @param dbData
	 * @return
	 */
	abstract X convertStringToEntityAttribute(String dbData);

	/**
	 * The concrete class which implements this abstract class will have to
	 * provide the implementation. For encryption of a String, its simple as a
	 * String has to be returned, but for other non String types some more code
	 * might have to be implemented. For example, a Date type of Date string.
	 * 
	 * @param attribute
	 * @return
	 */
	abstract String convertEntityAttributeToString(X attribute);

	/**
	 * Helper method to encrypt data
	 * 
	 * @param cipher
	 * @param attribute
	 * @return
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	private String encryptData(Cipher cipher, X attribute)
			throws IllegalBlockSizeException, BadPaddingException {
		byte[] bytesToEncrypt = convertEntityAttributeToString(attribute)
				.getBytes();
		byte[] encryptedBytes = cipher.doFinal(bytesToEncrypt);
		return Base64.getEncoder().encodeToString(encryptedBytes);
	}

	/**
	 * Helper method to decrypt data
	 * 
	 * @param cipher
	 * @param dbData
	 * @return
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	private X decryptData(Cipher cipher, String dbData)
			throws IllegalBlockSizeException, BadPaddingException {
		byte[] bytesToDecrypt = Base64.getDecoder().decode(dbData);
		byte[] decryptedBytes = cipher.doFinal(bytesToDecrypt);
		return convertStringToEntityAttribute(new String(decryptedBytes));
	}
}