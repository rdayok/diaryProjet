package services;

import data.models.User;
import data.repositories.UserRepository;
import data.repositories.UserRepositoryImplementation;
import dto.requests.*;
import dto.responses.*;
import exceptions.WrongUsernameAndPasswordException;
import exceptions.WrongUsernameException;
import utils.Mapper;
import utils.Validate;

public class UserServiceImplementation implements UserService{
    private UserRepository userRepository = new UserRepositoryImplementation();
    private User user;
    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest) {
        user = new User();
        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        User foundUser = userRepository.findBy(registerUserRequest.getUsername());
        Validate.validateNotNull(foundUser);
        Mapper.map(user, registerUserRequest);
        userRepository.save(user);
        return registerUserResponse;
    }

    @Override
    public void login(LoginRequest loginRequest) {
        user = new User();
        Mapper.map(user, loginRequest);
        User foundUser = findUserAndValidate(user);
        foundUser.setIsLoggedIn(true);
        userRepository.save(foundUser);
    }

    @Override
    public ChangePasswordResponse changePassword(ChangePasswordRequest changePasswordRequest) {
        ChangePasswordResponse changePasswordResponse = new ChangePasswordResponse();
        user = new User();
        Mapper.map(user, changePasswordRequest);
        User foundUser = findUserAndValidate(user);
        foundUser.setPassword(changePasswordRequest.getNewPassword());
        userRepository.save(foundUser);
        return changePasswordResponse;
    }

    private User findUserAndValidate(User user) {
        User foundUser = userRepository.findBy(user);
        Validate.validateNull(foundUser);
        return foundUser;
    }

    @Override
    public boolean isLoggedIn(String username) {
        User foundUser = userRepository.findBy(username);
        return foundUser.isLoggedIn();
    }

    @Override
    public CreateDiaryResponse createDiary(CreateDiaryRequest createDiaryRequest) {
        return null;
    }

    @Override
    public void createEntry(CreateEntryRequest createEntryRequest) {
    }

    @Override
    public void deleteDiary(DeleteDiaryRequest deleteDiaryRequest) {
    }

    @Override
    public long count() {
        return userRepository.count();
    }
}
