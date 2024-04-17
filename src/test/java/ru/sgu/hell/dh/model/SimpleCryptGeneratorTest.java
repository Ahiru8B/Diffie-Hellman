package ru.sgu.hell.dh.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

class SimpleCryptGeneratorTest {

	@Test
	void generateTest() {
		SimpleCryptGenerator generator = new SimpleCryptGenerator();
		BigInteger key = generator.generate();
		assertNotNull(key);
		assertEquals(43, key);
	}

}
