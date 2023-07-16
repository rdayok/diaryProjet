package services;

import dto.requests.CreateDiaryRequest;
import dto.requests.FindDiaryRequest;
import dto.responses.CreateDiaryResponse;
import dto.responses.FindDiaryResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryServiceImplementationTest {
    DiaryService diaryService = new DiaryServiceImplementation();
    CreateDiaryRequest requestOne;
    CreateDiaryRequest requestTwo;

    @BeforeEach
    void beforeEach(){
        requestOne = new CreateDiaryRequest();
        requestTwo = new CreateDiaryRequest();
        requestOne.setDiaryName("My love story");
        requestOne.setUsername("darda");
        diaryService.createDiary(requestOne);
        requestTwo.setDiaryName("Life");
        requestTwo.setUsername("darda");
    }


    @Test
    void testDiaryServiceExist(){
        assertNotNull(diaryService);
    }

    @Test
    void testCreateDiary_countIsOne(){
        assertEquals(1, diaryService.count());
    }

    @Test
    void testCreateTwoDiaries_countIsTwo(){
        diaryService.createDiary(requestTwo);

        assertEquals(2, diaryService.count());
    }

    @Test
    void testCreateADiary_aResponseIsReturned(){
        CreateDiaryResponse expectedResponse = diaryService.createDiary(requestOne);
        String stringExpectedResponse = expectedResponse.toString();
        assertEquals(stringExpectedResponse, expectedResponse.toString());
    }
    @Test
    void testFindDiaryByDiaryName_returnsTheDiarySpecified(){
        FindDiaryRequest findDiaryRequest = new FindDiaryRequest();
        findDiaryRequest.setDiaryName("My love story");
        findDiaryRequest.setUsername("darda");

        FindDiaryResponse findDiaryResponse = diaryService.findDiary(findDiaryRequest);

        assertEquals("My love story", findDiaryResponse.getDiaryName());
    }

}