package utils;

import data.models.Diary;
import data.models.User;
import dto.requests.*;
import dto.responses.CreateDiaryResponse;
import dto.responses.FindDiaryResponse;

public class Mapper {

    public static void map(Diary diary, CreateDiaryRequest createDiaryRequest) {
        diary.setDiaryName(createDiaryRequest.getDiaryName());
        diary.setUsername(createDiaryRequest.getUsername());

    }
    public static void map(Diary diary, CreateDiaryResponse createDiaryResponse, String dateAndTime){
        createDiaryResponse.setDiaryName(diary.getDiaryName());
        createDiaryResponse.setDateAndTimeDiaryCreated(dateAndTime);
    }

    public static void map(User user, RegisterUserRequest registerUserRequest) {
        user.setUsername(registerUserRequest.getUsername());
        user.setPassword(registerUserRequest.getPassword());
        user.setEmail(registerUserRequest.getEmail());
    }

    public static void map(User user, LoginRequest loginRequest) {
        user.setUsername(loginRequest.getUsername());
        user.setPassword(loginRequest.getPassword());
    }

    public static void map(User user, ChangePasswordRequest changePasswordRequest) {
        user.setUsername(changePasswordRequest.getUsername());
        user.setPassword(changePasswordRequest.getOldPassword());
    }

    public static void map(Diary diary, FindDiaryRequest findDiaryRequest) {
        diary.setDiaryName(findDiaryRequest.getDiaryName());
        diary.setUsername(findDiaryRequest.getUsername());
    }

    public static void map(Diary foundDiary, FindDiaryResponse findDiaryResponse) {
        findDiaryResponse.setDiaryName(foundDiary.getDiaryName());
        findDiaryResponse.setUsername(foundDiary.getUsername());
    }
}
