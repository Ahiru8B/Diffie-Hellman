package ru.sgu.hell.dh.model;

public interface Crypt {
	String encode(String input);

	String decode(String input);
}
