package data.repositories;

import data.models.Diary;

import java.util.ArrayList;
import java.util.Objects;

public class DiaryRepositoryImplementation implements DiaryRepository{
    private  ArrayList<Diary> diaries = new ArrayList<>();
    @Override
    public Diary save(Diary diary) {
        Diary foundDiary = findBy(diary);
        boolean diaryExist = foundDiary != null;
        if(diaryExist) update(diary, foundDiary);
        else diaries.add(diary);
        return diary;
    }

    private void update(Diary diary, Diary foundDiary) {
        int indexOfFountDiary = diaries.indexOf(foundDiary);
        diaries.set(indexOfFountDiary, diary);
    }

    @Override
    public Diary findBy(Diary givenDiary) {
        for (Diary diary : diaries){
            boolean diaryIsSame = Objects.equals(diary.getDiaryName().toLowerCase(), givenDiary.getDiaryName().toLowerCase()) &&
                    Objects.equals(diary.getUsername().toLowerCase(), givenDiary.getUsername().toLowerCase());
            if(diaryIsSame) return diary;
        }
        return null;
    }

    @Override
    public ArrayList<Diary> findAllDiariesFor(String username) {
        ArrayList<Diary> givenUserDiaries = new ArrayList<>();
        for (Diary diary : diaries){
            boolean diaryIsForGivenUser = Objects.equals(diary.getUsername().toLowerCase(), username.toLowerCase());
            if(diaryIsForGivenUser) givenUserDiaries.add(diary);
        }
        return givenUserDiaries;
    }

    @Override
    public void deleteBy(Diary diary) {
        diaries.remove(diary);
    }

    @Override
    public long count() {
        return diaries.size();
    }
}
