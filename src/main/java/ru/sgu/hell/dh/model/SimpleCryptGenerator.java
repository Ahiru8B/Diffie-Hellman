package ru.sgu.hell.dh.model;

import java.math.BigInteger;

public class SimpleCryptGenerator implements CryptGenerator {

	@Override
	public BigInteger generate() {
		// TODO должно возвращать 43
	
		return new BigInteger("43");
	}

}
