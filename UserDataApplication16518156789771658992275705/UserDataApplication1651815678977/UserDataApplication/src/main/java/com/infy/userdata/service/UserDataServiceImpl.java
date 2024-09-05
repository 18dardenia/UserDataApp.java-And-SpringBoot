package com.infy.userdata.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.userdata.dto.UserDTO;
import com.infy.userdata.entity.User;
import com.infy.userdata.exception.UserDataException;
import com.infy.userdata.repository.UserDataRepository;
import com.infy.userdata.validator.UserValidator;

import jakarta.transaction.Transactional;

@Service(value = "userDataService")
@Transactional
public class UserDataServiceImpl implements UserDataService {

	@Autowired
	private UserDataRepository userDataRepository;

	@Override
	public Integer addUser(UserDTO userDTO) throws UserDataException  {
		UserValidator valid = new UserValidator();
		valid.validate(userDTO);
		User user = new User();
		
		user.setUserName(userDTO.getUserName());
		user.setPassword(userDTO.getPassword());
		user.setPhoneNo(userDTO.getPhoneNo());
		user.setCity(userDTO.getCity());
		userDataRepository.save(user);
		return user.getUserId();

	}

	@Override
	public List<UserDTO> getDetailsByUserName(String userName) throws UserDataException {
		List<User> users = userDataRepository.findByUserName(userName);
		if(users.isEmpty()){
			throw new UserDataException("Service.NO_USER_FOUND");
		}
		List<UserDTO> userDTO = new ArrayList<>();
		for (User user : users){
			UserDTO dto = new UserDTO();
			dto.setUserId(user.getUserId());
			dto.setUserName(user.getUserName());
			dto.setPassword(user.getPassword());
			dto.setPhoneNo(user.getPhoneNo());
			dto.setCity(user.getCity());
			userDTO.add(dto);
		}
		
		return userDTO;
	}

	public UserDTO addUser2(UserDTO userDTO) throws UserDataException{
		UserValidator valid = new UserValidator();
		valid.validate2(userDTO);

		User user = new User();
		user = UserDTO.prepareEntity(userDTO);

		User UserId = userDataRepository.save(user);
		userDTO.setUserId(UserId.getUserId());


		return userDTO;
	}

	public List<UserDTO> getListByPassword(String password) throws UserDataException{
		//This repository is getting the List of User details based on the password and throwing an exception if the list is empty
		List<User> users = userDataRepository.findByPassword(password);
		if (users.isEmpty()){
			throw new UserDataException("Service.NO_USER_FOUND");
		}

		// Sort users in descending order by userName
		users.sort(Comparator.comparing(User::getUserName).reversed());
		// Creating a new UserDTO object to store the user details we got from above into DTO Objects
		List<UserDTO> userDTOs = new ArrayList<>();
		
		//Creating an enhance for loop from the data we got from the repository 
    for (User user : users) {
        UserDTO dto = UserDTO.prepareDTO(user); // Creating a new DTO object and storing the data we got from the repository
		userDTOs.add(dto); // Adding the DTO object to the list
    }

    return userDTOs; // Returning the list of DTO objects


		
	}

	
	
}



