package ru.sgu.hell.dh.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Person {
	private DiffieHellman diffieHellman;
	private Crypt crypt;

	public Person(DiffieHellman diffieHellman) {
		this.diffieHellman = diffieHellman;
		crypt = new XorCrypt(diffieHellman.getSecretKey());
	}

	public Long getP() {
		return diffieHellman.getP();
	}

	public Long getG() {
		return diffieHellman.getG();
	}

	public Long getA() {
		return diffieHellman.getA();
	}

	public Long getB() {
		return diffieHellman.getB();
	}

	public Long getPrivateKey() {
		return diffieHellman.getPrivateA();
	}

	public Long getSercretKey() {
		return diffieHellman.getSecretKey();
	}

	public String encrypt(String text) {
		log.trace("Person crypt = {}", crypt);
		log.trace("Person encrypt. text = {}", text);
		String encryptedText = crypt.encode(text);
		log.trace("Person encrypted. text = {}", encryptedText);
		return encryptedText;
	}

	public String decrypt(String text) {
		return encrypt(text);
	}
}
