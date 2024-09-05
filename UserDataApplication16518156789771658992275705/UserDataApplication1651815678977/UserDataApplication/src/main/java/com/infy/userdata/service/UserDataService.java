package com.infy.userdata.service;

import java.util.List;

import com.infy.userdata.dto.UserDTO;
import com.infy.userdata.exception.UserDataException;

public interface UserDataService {
	
	public Integer addUser(UserDTO userDTO) throws UserDataException;
	public List<UserDTO>  getDetailsByUserName(String userName) throws UserDataException;
	
	public UserDTO addUser2 (UserDTO userDTO)throws UserDataException;
	public List<UserDTO> getListByPassword(String password) throws UserDataException;
	

}
