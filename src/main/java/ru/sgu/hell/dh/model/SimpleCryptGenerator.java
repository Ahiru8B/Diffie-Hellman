package ru.sgu.hell.dh.model;

public class SimpleCryptGenerator implements CryptGenerator {

	@Override
	public Long generate() {
		return 43l;
	}

}
