package ru.sgu.hell.dh.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DiffieHellmanTest {

	@Test
	void testDiffieHellman() {
		DiffieHellman dh = new DiffieHellman();
		assertEquals(43, dh.getG());
		assertEquals(43, dh.getP());
		assertEquals(43, dh.getPrivateA());
	}

	@Test
	void testDiffieHellmanBigIntegerBigInteger() {
		DiffieHellman dh = new DiffieHellman(1L, 2L);
		assertEquals(1, dh.getG());
		assertEquals(2, dh.getP());
		assertEquals(43, dh.getPrivateA());
	}

	@Test
	void testGetA() {
		DiffieHellman dh = new DiffieHellman(2l, 4l);
		dh.addG(2l);
		dh.addP(10l);
		assertEquals(6, dh.getA());
	}

	@Test
	void testAddB() {
		DiffieHellman dh = new DiffieHellman(2l, 4l);
		dh.addB(1l);
		assertEquals(1, dh.getSecretKey());
	}

}
