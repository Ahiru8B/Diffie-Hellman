package ru.sgu.hell.dh.model;

import java.math.BigInteger;

public class Person {
	private DiffieHellman diffieHellman;
	private Crypt crypt;

	public Person(DiffieHellman diffieHellman) {
		this.diffieHellman = diffieHellman;
		crypt = new XorCrypt(diffieHellman.getSecretKey());
	}

	public BigInteger getP() {
		return diffieHellman.getP();
	}

	public BigInteger getG() {
		return diffieHellman.getG();
	}

	public BigInteger getA() {
		return diffieHellman.getA();
	}

	public BigInteger getB() {
		return diffieHellman.getB();
	}

	public BigInteger getPrivateKey() {
		return diffieHellman.getPrivateA();
	}

	public BigInteger getSercretKey() {
		return diffieHellman.getSecretKey();
	}

	public String encrypt(String text) {
		return crypt.encode(text);
	}

	public String decrypt(String text) {
		return decrypt(text);
	}
}
