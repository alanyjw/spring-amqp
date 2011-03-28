/*
 * Copyright 2002-2010 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package org.springframework.amqp.core;

import java.util.Map;

/**
 * @author Mark Fisher
 */
public interface Exchange {

	/**
	 * The name of the exchange.
	 * 
	 * @return the name of the exchange
	 */
	String getName();

	/**
	 * The type of the exchange. See {@link ExchangeTypes} for some well-known examples.
	 * 
	 * @return the type of the exchange
	 */
	String getType();

	/**
	 * A durable exchange will survive a server restart
	 * 
	 * @return true if durable
	 */
	boolean isDurable();

	/**
	 * True if the server should delete the exchange when it is no longer in use (if all bindings are deleted).
	 * 
	 * @return true if auto-delete
	 */
	boolean isAutoDelete();

	Map<String, Object> getArguments();

}
