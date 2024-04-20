package ru.sgu.hell.dh.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class SimpleCryptGeneratorTest {

	@Test
	void generateTest() {
		SimpleCryptGenerator generator = new SimpleCryptGenerator();
		Long key = generator.generate();
		assertNotNull(key);
		assertEquals(43, key);
	}

}
