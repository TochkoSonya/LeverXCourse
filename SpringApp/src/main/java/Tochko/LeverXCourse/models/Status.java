package Tochko.LeverXCourse.models;

public enum Status {
	PROCESSING("processing"),
	ACTIVE("active"),
	INACTIVE("inactive");

	private String code;
	Status(String code){
		this.code = code;
	}
	public String getCode(){ return code;}
}