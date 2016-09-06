package com.nsf.traqtion.model.common;

public class LookupDTO {

	public Long id;
	
	public String name;
	public String code;
	public String description;
	
	
	public LookupDTO(Long id, String code, String description) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
	}
	
	public LookupDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "LookupDTO [id=" + id + ", name=" + name + ", code=" + code + ", description=" + description + "]";
	}
	
	
}