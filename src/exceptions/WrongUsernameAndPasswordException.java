package exceptions;

public class WrongUsernameAndPasswordException extends RuntimeException{
    public WrongUsernameAndPasswordException(String exception){
        super(exception);
    }
}
