package ru.sgu.hell.dh.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class XorCryptTest {

	@Test
	void test() {
		XorCrypt crypt = new XorCrypt(1l);
		assertEquals("`reg", crypt.encode("asdf"));
		assertEquals("asdf", crypt.encode(crypt.encode("asdf")));
	}

	@Test
	void decode() {
		XorCrypt crypt = new XorCrypt(31415l);
		assertEquals("`reg", crypt.encode("asdf"));
		assertEquals("asdf", crypt.encode(crypt.encode("asdf")));
		assertEquals("asdf", crypt.decode(crypt.encode("asdf")));
	}

}
