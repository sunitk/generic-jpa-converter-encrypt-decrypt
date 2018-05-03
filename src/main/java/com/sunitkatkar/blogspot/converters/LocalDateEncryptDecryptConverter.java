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

import static java.time.format.DateTimeFormatter.ISO_DATE;
import static org.apache.commons.lang3.StringUtils.isEmpty;

import java.time.LocalDate;

import javax.persistence.Converter;

/**
 * Concrete implementation of the {@link AbstractEncryptDecryptConverter}
 * abstract class to encrypt/decrypt an entity attribute of type
 * {@link java.time.LocalDate} <br/>
 * Note: This is the class where the {@literal @}Converter annotation is applied
 * 
 * @author Sunit Katkar, sunitkatkar@gmail.com
 * @since ver 1.0 (Apr 2018)
 * @version 1.0 *
 */
@Converter(autoApply = false)
public class LocalDateEncryptDecryptConverter
		extends AbstractEncryptDecryptConverter<LocalDate> {

	public LocalDateEncryptDecryptConverter() {
		this(new CipherMaker());
	}

	public LocalDateEncryptDecryptConverter(CipherMaker cipherMaker) {
		super(cipherMaker);
	}

	@Override
	boolean isNotNullOrEmpty(LocalDate attribute) {
		return attribute != null;
	}

	@Override
	LocalDate convertStringToEntityAttribute(String dbData) {
		return isEmpty(dbData) ? null : LocalDate.parse(dbData, ISO_DATE);
	}

	@Override
	String convertEntityAttributeToString(LocalDate attribute) {
		return ((attribute == null) ? null : attribute.format(ISO_DATE));
	}
}