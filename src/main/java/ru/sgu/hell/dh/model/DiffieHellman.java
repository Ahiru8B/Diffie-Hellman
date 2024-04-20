package ru.sgu.hell.dh.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DiffieHellman {
	private CryptGenerator cryptGenerator = new SimpleCryptGenerator();
	private Long privateA;
	private Long publicP;
	private Long publicG;
	private Long publicB;

	public DiffieHellman() {
		log.trace("DiffieGellman constructor without parameters");
		privateA = cryptGenerator.generate();
		publicP = cryptGenerator.generate();
		publicG = cryptGenerator.generate();
	}

	public DiffieHellman(Long g, Long p) {
		log.trace("DiffieGellman constructor. g = {}, p = {}", g, p);
		privateA = cryptGenerator.generate();
		publicP = p;
		publicG = g;
	}

	public Long getP() {
		return publicP;
	}

	public Long getG() {
		return publicG;
	}

	public Long getA() {
		log.trace("getA. publicG = {}", publicG);
		return calculate(publicG);
	}

	public Long getB() {
		return publicB;
	}

	public Long getPrivateA() {
		return privateA;
	}

	public void addP(Long p) {
		log.trace("DH, addP. p = {}", p);
		publicP = p;
	}

	public void addG(Long g) {
		log.trace("DH, addG. g = {}", g);
		publicG = g;
	}

	public void addB(Long b) {
		log.trace("addB. b = {}", b);
		publicB = b;
	}

	public Long getSecretKey() {
		log.trace("getSecretKey. b = {}, p = {}", publicB, publicP);
		return calculate(publicB) % publicP;
	}

	private Long calculate(Long g) {
		log.trace("calculate. g = {}", g);
		return pow(g, privateA) % publicP;
	}

	private Long pow(Long a, Long b) {
		log.trace("pow. a = {}, b = {}", a, b);
		if (b == 0) {
			return 1l;
		}
		Long temp = a;
		for (int i = 0; i < b; i++) {
			temp *= a;
		}
		return temp;
	}
}
