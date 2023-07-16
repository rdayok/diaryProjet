package data.repositories;

import data.models.Diary;
import data.models.Entry;

import java.util.ArrayList;
import java.util.Objects;

public class EntryRepositoryImplementation implements EntryRepository{
    private ArrayList<Entry> entries = new ArrayList<>();
    private long counter;
    @Override
    public Entry save(Entry entry) {
        boolean isANewEntry = entry.getEntryID() == 0;
        Entry foundEntry = findBy(entry);
        boolean entryExist = foundEntry != null;
        if(entryExist)update(entry, foundEntry);
        else{
            entry.setEntryID(++counter);
            entries.add(entry);
        }
        return entry;
    }

    private void update(Entry entry, Entry foundEntry) {
        entries.set(entries.indexOf(foundEntry), entry);
    }

    @Override
    public Entry findBy(long givenID) {
        for (Entry entry : entries){
            boolean foundEntryWithTheGivenID = Objects.equals(entry.getEntryID(), givenID);
            if(foundEntryWithTheGivenID) return entry;
        }
        return null;
    }

    @Override
    public ArrayList<Entry> findAllEntriesFor(Diary givenDiary) {
        ArrayList<Entry> entriesForUserDiary = new ArrayList<>();
        for (Entry entry : entries){
            boolean entryIsForUserDiary = Objects.equals(entry.getUsername().toLowerCase(), givenDiary.getUsername().toLowerCase()) &&
                    Objects.equals(entry.getDiaryName().toLowerCase(), givenDiary.getDiaryName().toLowerCase());
            if(entryIsForUserDiary) entriesForUserDiary.add(entry);
        }
        return entriesForUserDiary;
    }


    @Override
    public Entry findBy(Entry givenEntry) {
        for (Entry entry: entries){
            boolean givenEntryIsFoundInEntries = Objects.equals(entry.getUsername().toLowerCase(), givenEntry.getUsername().toLowerCase()) &&
                    Objects.equals(entry.getDiaryName().toLowerCase(), givenEntry.getDiaryName().toLowerCase()) && Objects.equals(entry.getEntryTitle().toLowerCase(), givenEntry.getEntryTitle().toLowerCase());
            if(givenEntryIsFoundInEntries) return entry;
        }
        return null;
    }

    @Override
    public void deleteBy(Entry entry) {
        entries.remove(entry);
    }

    @Override
    public long count() {
        return entries.size();
    }
}
