package dto.responses;

import java.time.LocalDateTime;

public class CreateDiaryResponse {

    private String diaryName;
    private String dateAndTimeDiaryCreated;

    public String getDiaryName() {
        return diaryName;
    }

    public void setDiaryName(String diaryName) {
        this.diaryName = diaryName;
    }

    public String getDateAndTimeDiaryCreated() {
        return dateAndTimeDiaryCreated;
    }

    public void setDateAndTimeDiaryCreated(String dateAndTimeDiaryCreated) {
        this.dateAndTimeDiaryCreated = dateAndTimeDiaryCreated;
    }

    @Override
    public String toString() {
        return String.format("""
                %s was created on
                %s
                successfully.
                """,diaryName, dateAndTimeDiaryCreated);

    }
}
