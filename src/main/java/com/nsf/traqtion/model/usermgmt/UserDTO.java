package com.nsf.traqtion.model.usermgmt;
/**
 * UserDTO is data transfer object which carries properties across Business and Service layer.
 * @author HTC Global Services
 *
 */
public class UserDTO {

	private Integer userId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String password;
	
	public UserDTO(Integer userId, String firstName, String lastName, String email) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public UserDTO(Integer userId, String firstName, String lastName) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public UserDTO() {
		super();
	}

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + ", password=" + password + "]";
	}
	
	
}