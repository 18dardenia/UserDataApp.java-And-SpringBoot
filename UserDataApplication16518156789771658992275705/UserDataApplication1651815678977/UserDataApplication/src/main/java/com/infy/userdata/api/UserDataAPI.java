package com.infy.userdata.api;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.userdata.dto.UserDTO;
import com.infy.userdata.exception.UserDataException;
import com.infy.userdata.service.UserDataService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api")
@Validated
public class UserDataAPI {
	
	@Autowired
	private UserDataService userDataService;
	
	@Autowired
	Environment environment;
	
	@PostMapping(value = "/user")
	public ResponseEntity<String> addUser(@RequestBody UserDTO user) throws UserDataException{
		Integer userId = userDataService.addUser(user);
		String successMessage = environment.getProperty("API.USER_ADDED_SUCCESS") + userId;

		return new ResponseEntity<>(successMessage,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/user/{userName}")
	public ResponseEntity<List<UserDTO>> getDetailsByUserName(@PathVariable String userName) throws UserDataException {
		List<UserDTO> userDTO = userDataService.getDetailsByUserName(userName);
		return new ResponseEntity<>(userDTO,HttpStatus.OK);
	}
		// API EXAM TEST 
	@PostMapping(value = "/user2")
	public ResponseEntity<UserDTO> addUser2 (@Valid @RequestBody UserDTO user2) throws UserDataException{
		UserDTO userDTO2 = userDataService.addUser2(user2); // In the service we are returning a UserDTO object so thats why we are using that variable here
		return new ResponseEntity<>(userDTO2,HttpStatus.CREATED);

	}

	@GetMapping(value = "/user2/{userName}")
	public ResponseEntity<List<UserDTO>> getListByPassword (@PathVariable ("userName") String password) throws UserDataException{
		List<UserDTO> userDTO = userDataService.getListByPassword(password);
		return new ResponseEntity<>(userDTO,HttpStatus.OK);
	}
}
