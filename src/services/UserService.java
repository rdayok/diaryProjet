package services;

import dto.requests.*;
import dto.responses.*;

public interface UserService {
    RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest );
    void login(LoginRequest loginRequest);
    boolean isLoggedIn(String username);
    ChangePasswordResponse changePassword(ChangePasswordRequest changePasswordRequest);
    CreateDiaryResponse createDiary(CreateDiaryRequest createDiaryRequest);
    void createEntry(CreateEntryRequest createEntryRequest);
    void deleteDiary(DeleteDiaryRequest deleteDiaryRequest);
    long count();
}
