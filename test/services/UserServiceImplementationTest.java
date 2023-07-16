package services;

import dto.requests.ChangePasswordRequest;
import dto.requests.LoginRequest;
import dto.requests.RegisterUserRequest;
import dto.responses.ChangePasswordResponse;
import dto.responses.RegisterUserResponse;
import exceptions.UserAlreadyExistException;
import exceptions.WrongUsernameAndPasswordException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplementationTest {

    UserService userService;
    RegisterUserRequest registerUserRequestOne;
    RegisterUserRequest registerUserRequestTwo;
    ChangePasswordRequest changePasswordRequest;
    ChangePasswordResponse changePasswordResponse;
    LoginRequest loginRequest;

    @BeforeEach
    void beforeEach(){
        userService = new UserServiceImplementation();
        registerUserRequestOne = new RegisterUserRequest();
        registerUserRequestTwo = new RegisterUserRequest();
        changePasswordRequest = new ChangePasswordRequest();
        changePasswordResponse = new ChangePasswordResponse();
        registerUserRequestOne.setUsername("darda");
        registerUserRequestOne.setPassword("password");
        registerUserRequestOne.setEmail("email");
        userService.registerUser(registerUserRequestOne);
        registerUserRequestTwo.setUsername("oyi");
        registerUserRequestTwo.setPassword("password");
        registerUserRequestTwo.setEmail("email");
        loginRequest = new LoginRequest();
    }

    @Test
    void testUserServiceImplementationExist(){
        assertNotNull(userService);
    }

    @Test
    void testRegisterUser_countIsOne(){
        assertEquals(1, userService.count());
    }

    @Test
    void testRegisterTwoUsers_countIsTwo(){
        userService.registerUser(registerUserRequestTwo);
        assertEquals(2, userService.count());
    }

    @Test
    void testRegisterUser_whenSuccessful_returnsResponse(){
        RegisterUserResponse registrationResponse = userService.registerUser(registerUserRequestTwo);
        assertEquals("""
                ******************************************
                       ** Registration successful **
                ******************************************
                """, registrationResponse.toString());
    }

    @Test
    void testRegisterUsernameMustBeUnique(){
        registerUserRequestTwo.setUsername("darda");
        assertThrows(UserAlreadyExistException.class, () -> userService.registerUser(registerUserRequestTwo));
        try {
            userService.registerUser(registerUserRequestTwo);
        }catch (Exception exception){
            assertEquals(UserAlreadyExistException.class, exception.getClass());
            assertEquals("A username darda already exist.", exception.getMessage());
        }
    }

    @Test
    void testUserLogin_isLoggedInIsTrue(){
        assertFalse(userService.isLoggedIn("darda"));
        loginRequest.setUsername("darda");
        loginRequest.setPassword("password");

        userService.login(loginRequest);
        assertTrue(userService.isLoggedIn("darda"));
    }

    @Test
    void testUserLoginWithWrongPassword_wrongUsernameExceptionIsThrown(){
        assertFalse(userService.isLoggedIn("darda"));
        loginRequest.setUsername("man");
        loginRequest.setPassword("password");

        assertThrows(WrongUsernameAndPasswordException.class, () -> userService.login(loginRequest));
        try {
            userService.login(loginRequest);
        }catch (Exception exception){
            assertEquals("You entered wrong username and password", exception.getMessage());
            assertEquals(WrongUsernameAndPasswordException.class, exception.getClass());
        }
    }

    @Test
    void testUserLoginWithWrongPassword_wrongPasswordExceptionIsThrown(){
        assertFalse(userService.isLoggedIn("darda"));
        loginRequest.setUsername("darda");
        loginRequest.setPassword("pa");

        assertThrows(WrongUsernameAndPasswordException.class, () -> userService.login(loginRequest));
        try {
            userService.login(loginRequest);
        }catch (Exception exception){
            assertEquals(WrongUsernameAndPasswordException.class, exception.getClass());
            assertEquals("You entered wrong username and password", exception.getMessage());
        }
    }

    @Test
    void testRegisteredUserOneToChangesPassword(){
        changePasswordRequest.setUsername("darda");
        changePasswordRequest.setNewPassword("mynewP");
        changePasswordRequest.setOldPassword("password");

        userService.changePassword(changePasswordRequest);

        assertEquals("""
                *********************************************
                       ** Password change successful **
                *********************************************
                """, changePasswordResponse.toString());
    }

    @Test
    void testRegisterUserOneToChangePasswordWithWrongOldPassword(){
        changePasswordRequest.setUsername("darda");
        changePasswordRequest.setNewPassword("mynewP");
        changePasswordRequest.setOldPassword("pass");

        assertThrows(WrongUsernameAndPasswordException.class, () -> userService.changePassword(changePasswordRequest));
    }

}