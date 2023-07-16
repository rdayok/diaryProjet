package utils;

import data.models.User;
import exceptions.UserAlreadyExistException;
import exceptions.UserDoesNotExistException;
import exceptions.WrongUsernameAndPasswordException;

public class Validate {
    public static void validateNull(User user) {
        boolean userDoesNotExist = user == null;
        if(userDoesNotExist) throw new WrongUsernameAndPasswordException("You entered wrong username and password");
    }

    public static void validateNotNull(User foundUser) {
        boolean userExist = foundUser != null;
        if(userExist) throw new UserAlreadyExistException("A username "+ foundUser.getUsername() + " already exist.");
    }

}
