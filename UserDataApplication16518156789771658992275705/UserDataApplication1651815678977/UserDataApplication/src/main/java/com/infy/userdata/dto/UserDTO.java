package com.infy.userdata.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.infy.userdata.entity.User;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserDTO {
	
	private Integer userId;
	@NotNull(message = "{UserName.NOT_FOUND}")
	@Pattern(regexp = "^[a-zA-Z0-9]{3,20}$", message = "{userName.invalid}")
	private String userName;
	@NotNull(message = "{password.NOT_FOUND}")
	@Pattern(regexp = "^(Private|Transportation|Electric|Military|Rental)$", message = "{password.invalid}")
	private String password;
	private Long phoneNo;
	private String city;

	// FOr the API Exam
	@NotNull(message = "{date.NOT_FOUND}")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Pattern(regexp = "^(\\d{4})-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$", message = "{date.invalid}")
	private LocalDate date;
	
	public UserDTO() {
		super();
	}
	
	public UserDTO(Integer userId, String userName, String password, Long phoneNo, String city) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.phoneNo = phoneNo;
		this.city = city;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	
	// Converts DTO to Entity
	//ADDED for thew spring Test
	public static UserDTO prepareDTO(User user){
		
			UserDTO userDTO = new UserDTO();
			userDTO.setUserId(user.getUserId());
			userDTO.setUserName(user.getUserName());
			userDTO.setPassword(user.getPassword());
			userDTO.setPhoneNo(user.getPhoneNo());
			userDTO.setCity(user.getCity());
			return userDTO;
	
	}
	//ADDED for thew spring Test
	// Converts Entity to DTO
	public static User prepareEntity(UserDTO userDTO){
		User user = new User();
		user.setUserId(userDTO.getUserId());
		user.setUserName(userDTO.getUserName());
		user.setPassword(userDTO.getPassword());
		user.setPhoneNo(userDTO.getPhoneNo());
		user.setCity(userDTO.getCity());
		return user;
	}

	

	

}
