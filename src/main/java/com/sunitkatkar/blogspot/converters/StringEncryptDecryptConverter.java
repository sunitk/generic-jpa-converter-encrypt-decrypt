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

import javax.persistence.Converter;

/**
 * Concrete implementation of the {@link AbstractEncryptDecryptConverter}
 * abstract class to encrypt/decrypt an entity attribute of type
 * {@link java.lang.String} <br/>
 * Note: This is the class where the {@literal @}Converter annotation is applied
 * 
 * @author Sunit Katkar, sunitkatkar@gmail.com (https://sunitkatkar.blogspot.com/)
 * @since ver 1.0 (Apr 2018)
 * @version 1.0 
 */
@Converter(autoApply = false)
public class StringEncryptDecryptConverter
		extends AbstractEncryptDecryptConverter<String> {

	/**
	 * Default constructor initializes with an instance of the
	 * {@link CipherMaker} crypto class to get a {@link javax.crypto.Cipher}
	 * instance
	 */
	public StringEncryptDecryptConverter() {
		this(new CipherMaker());
	}

	/**
	 * Constructor
	 * 
	 * @param cipherMaker
	 */
	public StringEncryptDecryptConverter(CipherMaker cipherMaker) {
		super(cipherMaker);
	}

	@Override
	boolean isNotNullOrEmpty(String attribute) {
		return isNotEmpty(attribute);
	}

	@Override
	String convertStringToEntityAttribute(String dbData) {
		// the input is a string and output is a string
		return dbData;
	}

	@Override
	String convertEntityAttributeToString(String attribute) {
		// Here too the input is a string and output is a string
		return attribute;
	}
}
