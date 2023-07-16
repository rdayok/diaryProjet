package services;

import data.models.Entry;

public interface EntryService {
    Entry save(Entry entry);
    Entry update(Entry entry);
    Entry find(Entry entry);
    void delete(Entry entry);
    long count();
}
