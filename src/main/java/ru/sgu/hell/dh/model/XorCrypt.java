package ru.sgu.hell.dh.model;

import java.math.BigInteger;

public class XorCrypt implements Crypt {
	private BigInteger key;

	public XorCrypt(BigInteger key) {
		super();
		this.key = key;
	}

	public String encode(String input) {
		// надо чтобы оно шифровало через xor. Сейчас тут костыль с длиной ключа. Типа
		// если взять ключ больше чем из одного числа то не будет правильно шифроваться

		System.err.println("byteKey lenth = " + key.toByteArray().length);
		System.err.println("output lenth = " + input.getBytes().length);
		byte[] byteKey = key.toByteArray();
		byte[] output = new byte[input.getBytes().length];
		byte[] inputBytes = input.getBytes();
		for (int i = 0; i < input.getBytes().length; i++) {
			output[i] = (byte) (byteKey[0] ^ inputBytes[i]);
		}

		return new String(output);
	}

	public String decode(String input) {
		// Этот метод просто надо создать
		return null;
	}
}
