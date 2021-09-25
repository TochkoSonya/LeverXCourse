package leverXCourse.models;

public enum Role {
	ADMIN("admin"),
	ANON ("anon"),
	TRADER("trader");

	private String code;
	Role(String code){
		this.code = code;
	}
	public String getCode(){ return code;}
}
