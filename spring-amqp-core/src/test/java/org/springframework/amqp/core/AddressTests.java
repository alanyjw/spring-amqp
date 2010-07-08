/*
 * Copyright 2002-2010 the original author or authors.
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

package org.springframework.amqp.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import junit.framework.Assert;

import org.junit.Test;

/**
 * @author Mark Pollack
 */
public class AddressTests {

	@Test
	public void parse() {
		Address a = new Address(ExchangeType.direct, "my-exchange", "routing-key");
		String replyToUri = "direct://my-exchange/routing-key";
		Assert.assertEquals(replyToUri, a.toString());
		
		Address b = Address.parse(replyToUri);
		assertEquals(b.getExchangeType(), ExchangeType.direct);
		assertEquals(b.getExchangeName(), "my-exchange");
		assertEquals(b.getRoutingKey(), "routing-key");
		assertTrue(b.isStructured());
		
		b = Address.parse("my-exchange/routing-key");
		assertFalse(b.isStructured());
		assertEquals("my-exchange/routing-key", b.toString());
	}

}