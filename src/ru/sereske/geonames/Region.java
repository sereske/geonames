package ru.sereske.geonames;

public class Region {
	private String code;
	private String name;
	
	public Region() {}
	
	public Region(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Region [code=" + code + ", name=" + name + "]";
	}
}
