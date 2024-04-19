package ru.sgu.hell.dh.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

class XorCryptTest {

	@Test
	void test() {
		XorCrypt crypt = new XorCrypt(new BigInteger("1"));
		assertEquals("`reg", crypt.encode("asdf"));
		assertEquals("asdf", crypt.encode(crypt.encode("asdf")));
	}

	@Test
	void decode() {
		XorCrypt crypt = new XorCrypt(new BigInteger("125135132414"));
		assertEquals("asdf", crypt.encode(crypt.encode("asdf")));
		assertEquals("asdf", crypt.decode(crypt.encode("asdf")));
	}

}
