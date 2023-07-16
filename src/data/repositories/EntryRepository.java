package data.repositories;

import data.models.Diary;
import data.models.Entry;

import java.util.ArrayList;

public interface EntryRepository {
    Entry save(Entry entry);
    Entry findBy(long entryID);
    ArrayList<Entry> findAllEntriesFor(Diary diary);
    Entry findBy(Entry entry);
    void deleteBy(Entry entry);
    long count();
}
