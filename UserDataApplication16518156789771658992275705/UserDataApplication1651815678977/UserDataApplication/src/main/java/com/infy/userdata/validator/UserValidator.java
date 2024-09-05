package com.infy.userdata.validator;

import com.infy.userdata.dto.UserDTO;
import com.infy.userdata.exception.UserDataException;

public class UserValidator
{

    public void validate(UserDTO userDTO) throws UserDataException
    {
	if (Boolean.FALSE.equals(validatePassword(userDTO.getPassword())))
	{
	    throw new UserDataException("Validator.INVALID_PASSWORD");
	}

    }

    public Boolean validatePassword(String password)
    {
        
	return (password.matches("[A-Za-z0-9]{10}"));
    }

    public void validate2(UserDTO userDTO) throws UserDataException{
        if (!validateEmail(userDTO.getUserName())){
            throw new UserDataException("Validator.INVALID_USERNAME");

        }

    }

    public boolean validateEmail(String userName){
        return userName.matches("US \\d{2} JC \\d{4}");
    }

}
