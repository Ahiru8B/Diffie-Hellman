package ru.sgu.hell.dh.model;

public class XorCrypt implements Crypt {
	private String key;

	public XorCrypt(Long key) {
		super();
		this.key = key.toString();
	}

	public String encode(String input) {
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			output.append((char) (input.charAt(i) ^ key.charAt(i % key.length())));
		}
		return output.toString();
	}

	public String decode(String input) {
		return encode(input);
	}
}
