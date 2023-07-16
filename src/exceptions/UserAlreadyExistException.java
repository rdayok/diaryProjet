package exceptions;

public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException(String exception){
        super(exception);
    }
}
