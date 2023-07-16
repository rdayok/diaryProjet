package data.repositories;

import data.models.Diary;
import data.models.Entry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EntryRepositoryImplementationTest {
    EntryRepository entryRepository;
    Entry entryOne;
    Entry entryTwo;

    @BeforeEach
    void setUp(){
        entryRepository = new EntryRepositoryImplementation();
        entryOne = new Entry();
        entryTwo = new Entry();
        entryOne.setUsername("Darda");
        entryOne.setDiaryName("Love diary");
        entryOne.setEntryTitle("My love life");
        entryRepository.save(entryOne);
        entryTwo.setEntryTitle("My love life");

    }

    @Test
    void testSaveOneEntry_countIsOne() {
        assertEquals(1, entryRepository.count());
    }

    @Test
    void testSaveTwoEntryInTwoSeparateDiariesForAParticularUser_countIsTwo(){
        entryTwo.setUsername("Darda");
        entryTwo.setDiaryName("Love life");

        entryRepository.save(entryTwo);

        assertEquals(2, entryRepository.count());
    }

    @Test
    void testTwoDifferentUsersCanHaveEntriesWithSameTitle(){
        entryTwo.setUsername("Oyi");
        entryTwo.setDiaryName("My diary");
        entryRepository.save(entryTwo);

        assertEquals(2, entryRepository.count());
    }

    @Test
    void testSaveEntryOneForUserInAParticularDiary_titledMyLoveLife_updateEntryOne_countIsOne(){
        entryTwo.setUsername("Darda");
        entryTwo.setDiaryName("love diary");

        entryRepository.save(entryOne);
        entryRepository.save(entryTwo);

        assertEquals(1, entryRepository.count());
    }

    @Test
    void testFindEntryReturnsSameEntry(){
        entryTwo.setUsername("Darda");
        entryTwo.setDiaryName("Love diary");
        Entry foundEntry = entryRepository.findBy(entryTwo);

        assertSame(entryOne, foundEntry);
        assertEquals(1, foundEntry.getEntryID());
    }

    @Test
    void testFindByEntryReturnsANullWhenGivenEntryDoesNotExist(){
        entryTwo.setUsername("Max");
        entryTwo.setDiaryName("Love diary");

        Entry foundEntry = entryRepository.findBy(entryTwo);

        assertNull(foundEntry);
    }

    @Test
    void testSaveEntryReturnsTheEntry(){
        entryTwo.setUsername("Darda");
        entryTwo.setDiaryName("love diary");
        Entry returnedEntry = entryRepository.save(entryTwo);
        assertSame(returnedEntry, entryTwo);
    }

    @Test
    void testSaveTwoEntries_deleteEntryOne_countIsOne() {
        entryTwo.setUsername("Darda");
        entryTwo.setDiaryName("love diary");
        entryRepository.save(entryTwo);
        entryRepository.deleteBy(entryOne);

        assertEquals(1, entryRepository.count());
    }

    @Test
    void testDeletingEntryThatDoesNotExist(){
        entryRepository.deleteBy(entryTwo);

        assertEquals(1, entryRepository.count());
    }

    @Test
    void testFindEntryByIDThatDoesNotExist(){
        Entry foundEntry = entryRepository.findBy(3);

        assertNull(foundEntry);
    }

    @Test
    void testFindEntriesForAUserSpecificDiary(){
        entryTwo.setEntryTitle("I am");
        entryTwo.setUsername("Darda");
        entryTwo.setDiaryName("love diary");
        entryRepository.save(entryTwo);
        Diary diary = new Diary();
        diary.setUsername("darda");
        diary.setDiaryName("Love Diary");

        ArrayList<Entry> userSpecificDiaryEntries = entryRepository.findAllEntriesFor(diary);

        assertNotNull(userSpecificDiaryEntries);
        assertEquals(2, userSpecificDiaryEntries.size());
    }

}