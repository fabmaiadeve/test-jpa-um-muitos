package com.fabdev.testjpaummuitos.enums;

public enum TypeAdress {
	
	RESIDENTIAL(1),
	INDUSTRIAL(2),
	COMMERCIAL(3);
	
	private int code;
	
	private TypeAdress(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	public static TypeAdress valueOf(int code){
		for(TypeAdress value : TypeAdress.values()) {
			if (code == value.getCode()) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid TypeAdress code!");
	}

}
