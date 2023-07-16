package data.repositories;

import data.models.Diary;

import java.util.ArrayList;

public interface DiaryRepository {
    Diary save(Diary entry);

    Diary findBy(Diary diary);

    ArrayList<Diary> findAllDiariesFor(String username);

    void deleteBy(Diary diary);

    long count();
}
