package ru.sgu.hell.dh.model;

import java.math.BigInteger;

public class DiffieHellman {

	// По ходу добавлять приватные поля
	// Генерировать все значения только через SimpleCryptGenerator

	public DiffieHellman() {
		// Должен генерировать приватное число (а)
		// Должен генерировать общие числа p, g
	}

	public DiffieHellman(BigInteger g, BigInteger p) {
		// Должен генерировать приватное число (а)
	}

	public BigInteger getP() {
		return null;
	}

	public BigInteger getG() {
		return null;
	}

	public BigInteger getA() {
		return null;
	}

	public BigInteger getB() {
		return null;
	}

	public BigInteger getPrivateA() {
		return null;
	}

	public void addP(BigInteger p) {
		// Должен пересчитывать A
	}

	public void addG(BigInteger g) {
		// Должен пересчитывать A
	}

	public void addB(BigInteger b) {
		// Должен генерировать приватный ключ
	}

	public BigInteger getSecretKey() {
		// Возвращает приватный ключ (K)
		return null;
	}

	private BigInteger calculate(BigInteger g) {
		// Вычисляет A = g^a mod p
		// или K = B^a mod p
		// тут можно делать что угодно!
		// можно вообще этот vtnjl удалить и считать значения в других методах
		return null;
	}

}
