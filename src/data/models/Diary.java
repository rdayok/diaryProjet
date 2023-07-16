package data.models;

import java.time.LocalDateTime;

public class Diary {
    private String diaryName;
    private String username;
    private LocalDateTime dateAndTimeOfCreatingDiary = LocalDateTime.now();

    public String getDiaryName() {
        return diaryName;
    }

    public void setDiaryName(String diaryName) {
        this.diaryName = diaryName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getDateAndTimeOfCreatingDiary() {
        return dateAndTimeOfCreatingDiary;
    }

    public void setDateAndTimeOfCreatingDiary(LocalDateTime dateAndTimeOfCreatingDiary) {
        this.dateAndTimeOfCreatingDiary = dateAndTimeOfCreatingDiary;
    }
}
