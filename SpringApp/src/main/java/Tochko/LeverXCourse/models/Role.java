package Tochko.LeverXCourse.models;

public enum Role {
	admin("admin"),
	anon ("anon"),
	trader("trader");

	private String code;
	Role(String code){
		this.code = code;
	}
	public String getCode(){ return code;}
}
