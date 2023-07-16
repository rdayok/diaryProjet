package services;

import dto.requests.*;
import dto.responses.*;

public interface DiaryService {
    CreateDiaryResponse createDiary(CreateDiaryRequest createDiaryRequest);
    DeleteDiaryResponse deleteDiary(DeleteDiaryRequest deleteDiaryRequest);
    FindDiaryResponse findDiary(FindDiaryRequest findDiaryRequest);
    CreateEntryResponse createEntry(CreateEntryRequest createEntryRequest);
    FindEntryResponse findEntry(FindEntryRequest findEntryRequest);
    UpdateEntryResponse updateEntry(UpdateEntryRequest updateEntryRequest);
    DeleteEntryResponse deleteEntry(DeleteDiaryRequest deleteDiaryRequest);
    long count();
}
