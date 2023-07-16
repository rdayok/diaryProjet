package exceptions;

import com.sun.nio.sctp.AbstractNotificationHandler;

public class UserDoesNotExistException extends RuntimeException{
    public UserDoesNotExistException (String exception){
        super(exception);
    }
}
