package com.groupeseb.kite.check.impl.operators;


import com.google.common.base.Preconditions;
import com.groupeseb.kite.Json;
import com.groupeseb.kite.check.ICheckOperator;
import org.springframework.stereotype.Component;

import static org.testng.Assert.assertTrue;

/**
 * Verifies if actual value is strictly greater than expected value
 * <p>
 * Launch an {@link IllegalArgumentException} if actual or expected values are not numeric
 *
 * @author mgaudin
 */
@Component
public class GreaterThanOperator implements ICheckOperator {
	@Override
	public boolean match(String name) {
		return "gt".equalsIgnoreCase(name);
	}

	@Override
	public void apply(Object value, Object expected, String description, Boolean failOnError, Json parameters) {
		Preconditions.checkArgument(
				Number.class.isAssignableFrom(value.getClass()),
				"The input argument of 'gt' must be a number"
		);

		Preconditions.checkArgument(
				Number.class.isAssignableFrom(expected.getClass()),
				"The input argument of 'gt' must be a number"
		);

		assertTrue(
				((Number) value).doubleValue() > ((Number) expected).doubleValue()
				, description
		);
	}
}
