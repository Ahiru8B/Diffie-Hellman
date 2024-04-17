package ru.sgu.hell.dh.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

class DiffieHellmanTest {

	@Test
	void testDiffieHellman() {
		DiffieHellman dh = new DiffieHellman();
		assertEquals(new BigInteger("43"), dh.getG());
		assertEquals(new BigInteger("43"), dh.getP());
		assertEquals(new BigInteger("43"), dh.getPrivateA());
	}

	@Test
	void testDiffieHellmanBigIntegerBigInteger() {
		DiffieHellman dh = new DiffieHellman(new BigInteger("1"), new BigInteger("2"));
		assertEquals(new BigInteger("1"), dh.getG());
		assertEquals(new BigInteger("2"), dh.getP());
		assertEquals(new BigInteger("43"), dh.getPrivateA());
	}

	@Test
	void testGetA() {
		DiffieHellman dh = new DiffieHellman(new BigInteger("2"), new BigInteger("4"));
		assertEquals(new BigInteger("43"), dh.getA());
		dh.addG(new BigInteger("2"));
		dh.addP(new BigInteger("10"));
		assertEquals(new BigInteger("35"), dh.getA());
	}

	@Test
	void testAddB() {
		DiffieHellman dh = new DiffieHellman(new BigInteger("2"), new BigInteger("4"));
		dh.addB(new BigInteger("1"));
		assertEquals(new BigInteger("1"), dh.getB());
		assertEquals(new BigInteger("1"), dh.getPrivateA());
	}

}
