package exceptions;

public class WrongUsernameException extends RuntimeException {
    public WrongUsernameException(String exception){
        super(exception);
    }
}
