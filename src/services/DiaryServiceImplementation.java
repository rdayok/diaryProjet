package services;

import data.models.Diary;
import data.repositories.DiaryRepository;
import data.repositories.DiaryRepositoryImplementation;
import dto.requests.*;
import dto.responses.*;
import utils.Mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DiaryServiceImplementation implements DiaryService{

    private DiaryRepository diaryRepository = new DiaryRepositoryImplementation();
    private Diary diary;
    @Override
    public CreateDiaryResponse createDiary(CreateDiaryRequest createDiaryRequest) {
        diary = new Diary();
        CreateDiaryResponse createDiaryResponse = new CreateDiaryResponse();
        Mapper.map(diary, createDiaryRequest);
        LocalDateTime dateTime = diary.getDateAndTimeOfCreatingDiary();
        String dateAndTime = DateTimeFormatter.ofPattern("EEE  dd/MM/yy hh:mm a").format(dateTime);
        Mapper.map(diary, createDiaryResponse, dateAndTime);
        diaryRepository.save(diary);
        return createDiaryResponse;
    }



    @Override
    public DeleteDiaryResponse deleteDiary(DeleteDiaryRequest deleteDiaryRequest) {
        return null;
    }

    @Override
    public FindDiaryResponse findDiary(FindDiaryRequest findDiaryRequest) {
        diary = new Diary();
        FindDiaryResponse findDiaryResponse = new FindDiaryResponse();
        Mapper.map(diary, findDiaryRequest);
        Diary foundDiary = diaryRepository.findBy(diary);
        Mapper.map(foundDiary, findDiaryResponse);
        return findDiaryResponse;
    }

    @Override
    public CreateEntryResponse createEntry(CreateEntryRequest createEntryRequest) {


        return null;
    }

    @Override
    public FindEntryResponse findEntry(FindEntryRequest findEntryRequest) {
        return null;
    }

    @Override
    public UpdateEntryResponse updateEntry(UpdateEntryRequest updateEntryRequest) {
        return null;
    }

    @Override
    public DeleteEntryResponse deleteEntry(DeleteDiaryRequest deleteDiaryRequest) {
        return null;
    }

    @Override
    public long count() {
        return diaryRepository.count();
    }
}
