package data.models;

import java.time.LocalDateTime;

public class Entry {
    private String entryTitle;
    private String entryBody;
    private long entryID;
    private String username;
    private String diaryName;
    private LocalDateTime dateAndTimeOfCreatingEntry = LocalDateTime.now();

    public String getEntryTitle() {
        return entryTitle;
    }

    public void setEntryTitle(String entryTitle) {
        this.entryTitle = entryTitle;
    }

    public String getEntryBody() {
        return entryBody;
    }

    public void setEntryBody(String entryBody) {
        this.entryBody = entryBody;
    }

    public long getEntryID() {
        return entryID;
    }

    public void setEntryID(long entryID) {
        this.entryID = entryID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDiaryName() {
        return diaryName;
    }

    public void setDiaryName(String diaryName) {
        this.diaryName = diaryName;
    }

    public LocalDateTime getDateAndTimeOfCreatingEntry() {
        return dateAndTimeOfCreatingEntry;
    }

    public void setDateAndTimeOfCreatingEntry(LocalDateTime dateAndTimeOfCreatingEntry) {
        this.dateAndTimeOfCreatingEntry = dateAndTimeOfCreatingEntry;
    }
}
