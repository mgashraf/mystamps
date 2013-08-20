/*
 * Copyright (C) 2009-2013 Slava Semushin <slava.semushin@gmail.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package ru.mystamps.web.service;

import java.util.Date;

import ru.mystamps.web.entity.Country;
import ru.mystamps.web.entity.SuspiciousActivityType;
import ru.mystamps.web.entity.User;
import ru.mystamps.web.entity.UsersActivation;

final class TestObjects {

	protected static final String TEST_PASSWORD     = "secret";
	
	private static final Integer TEST_COUNTRY_ID = 1;
	private static final String TEST_COUNTRY_NAME = "Somewhere";
	
	private static final String TEST_EMAIL          = "test@example.org";
	private static final String TEST_ACTIVATION_KEY = "1234567890";

	private static final String TEST_NAME           = "Test Name";
	private static final String TEST_LOGIN          = "test";
	private static final String TEST_SALT           = "salt";

	// sha1(TEST_SALT + "{" + TEST_PASSWORD + "}")
	private static final String TEST_HASH           = "b0dd94c84e784ddb1e9a83c8a2e8f403846647b9";

	private TestObjects() {
	}
	
	public static Country createCountry() {
		Country country = new Country();
		country.setId(TEST_COUNTRY_ID);
		country.setName(TEST_COUNTRY_NAME);
		Date now = new Date();
		country.getMetaInfo().setCreatedAt(now);
		country.getMetaInfo().setUpdatedAt(now);
		return country;
	}
	
	public static UsersActivation createUsersActivation() {
		UsersActivation activation = new UsersActivation();
		activation.setActivationKey(TEST_ACTIVATION_KEY);
		activation.setEmail(TEST_EMAIL);
		activation.setCreatedAt(new Date());
		return activation;
	}
	
	public static User createUser() {
		final Integer anyId = 777;
		User user = new User();
		user.setId(anyId);
		user.setLogin(TEST_LOGIN);
		user.setName(TEST_NAME);
		user.setEmail(TEST_EMAIL);
		user.setRegisteredAt(new Date());
		user.setActivatedAt(new Date());
		user.setHash(TEST_HASH);
		user.setSalt(TEST_SALT);

		return user;
	}
	
	public static SuspiciousActivityType createPageNotFoundActivityType() {
		SuspiciousActivityType type = new SuspiciousActivityType();
		type.setId(1);
		type.setName("PageNotFound");
		return type;
	}
	
	public static SuspiciousActivityType createAuthFailedActivityType() {
		SuspiciousActivityType type = new SuspiciousActivityType();
		type.setId(2);
		type.setName("AuthenticationFailed");
		return type;
	}
	
}
