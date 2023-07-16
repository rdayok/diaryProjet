package data.repositories;

import data.models.Diary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DiaryRepositoryImplementationTest {
    DiaryRepository diaryRepository;
    Diary diaryOne;
    Diary diaryTwo;
    Diary diaryThree;

    @BeforeEach
    void setUp(){
        diaryRepository = new DiaryRepositoryImplementation();
        diaryOne = new Diary();
        diaryTwo = new Diary();
        diaryThree = new Diary();
        diaryOne.setDiaryName("My love diary");
        diaryOne.setUsername("darda");
        diaryRepository.save(diaryOne);
    }

    @Test
    void testSaveOneDiaryForOneUser_countIsOne() {
        assertEquals(1, diaryRepository.count());
    }

    @Test
    void testSaveTwoDiaryForOneUser_countIsTwo(){
        diaryTwo.setDiaryName("Truth");
        diaryTwo.setUsername("darda");
        diaryRepository.save(diaryTwo);

        assertEquals(2, diaryRepository.count());
    }

    @Test
    void testSaveDiary_findDiaryReturnsGottenDiary(){
        Diary foundDiary = diaryRepository.findBy(diaryOne);

        assertEquals("My love diary", foundDiary.getDiaryName());
    }

    @Test
    void testFindAllForAParticularUser(){
        diaryTwo.setDiaryName("Truth");
        diaryTwo.setUsername("darda");
        diaryRepository.save(diaryTwo);
        diaryThree.setUsername("Jayb");
        diaryThree.setDiaryName("My love diary");
        diaryRepository.save(diaryThree);



        ArrayList<Diary> foundDiaries = diaryRepository.findAllDiariesFor("Darda");
        assertNotNull(foundDiaries);
        assertEquals(2, foundDiaries.size());
    }

    @Test
    void testSaveDiaryOneForOneUser_updateTheDiaryOne_countIsOne(){
        diaryTwo.setDiaryName("My love diary");
        diaryTwo.setUsername("darda");
        diaryRepository.save(diaryTwo);

        assertEquals(1, diaryRepository.count());
    }
    @Test
    void testDifferentUsersCanSaveDiariesWithSameNameEach(){
        diaryTwo.setDiaryName("My love diary");
        diaryTwo.setUsername("max");
        diaryRepository.save(diaryTwo);

        assertEquals(2, diaryRepository.count());
    }

    @Test
    void testDiaryForTwoDifferentUsersCanBeSaved(){
        diaryTwo.setDiaryName("Truth");
        diaryTwo.setUsername("Oyi");
        diaryRepository.save(diaryTwo);
        diaryThree.setUsername("Jayb");
        diaryThree.setDiaryName("My love diary");
        diaryRepository.save(diaryThree);

        diaryRepository.save(diaryThree);

        assertEquals(3, diaryRepository.count());
    }

    @Test
    void testSaveDiaryReturnsTheDiary(){
        Diary returnedDiary = diaryRepository.save(diaryOne);
        assertSame(returnedDiary, diaryOne);
    }

    @Test
    void testSaveTwoDiaries_deleteDiaryOne_countIsZero() {
        diaryRepository.deleteBy(diaryOne);

        assertEquals(0, diaryRepository.count());
    }

    @Test
    void testDeletingDiaryThaDoesNotExist(){
        diaryRepository.deleteBy(diaryTwo);

        assertEquals(1, diaryRepository.count());
    }

    @Test
    void testSaveTwoDiaries_deleteTwoDiaries_countIsOne() {
        diaryRepository.deleteBy(diaryOne);

        assertEquals(0, diaryRepository.count());
    }


    @Test
    void testFindDiaryThatDoesNotExist_returnsNull() {
        diaryTwo.setUsername("JayB");
        diaryTwo.setDiaryName("My life");
        assertNull(diaryRepository.findBy(diaryTwo));
    }

}