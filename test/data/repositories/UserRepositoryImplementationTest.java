package data.repositories;

import data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplementationTest {
    UserRepository userRepository;
    User userOne;
    User userTwo;
    @BeforeEach
    void beforeEach(){
        userOne = new User();
        userTwo = new User();
        userOne.setUsername("darda");
        userOne.setPassword("password");
        userTwo.setUsername("username");
        userTwo.setPassword("password");
        userRepository = new UserRepositoryImplementation();
        userRepository.save(userOne);
    }

    @Test
    void testSaveOneUser_countIsOne() {
        assertEquals(1, userRepository.count());
    }

    @Test
    void testSaveTwoUsers_countIsTwo(){
        userOne.setUsername("man");
        userRepository.save(userOne);
        userRepository.save(userTwo);

        assertEquals(2, userRepository.count());
    }

    @Test
    void testSaveOneUser_findByUserNameReturnSameSavedUser() {
        User expectedUser = userRepository.findBy("darda");

        assertSame(expectedUser, userOne);
    }

    @Test
    void testSaveUserOne_updateUserOne_countIsOne(){
        userTwo.setUsername("darda");
        userRepository.save(userTwo);

        assertEquals(1, userRepository.count());
    }

    @Test
    void testSaveUserReturnsTheUser(){
        User returnedUser = userRepository.save(userOne);
        assertSame(returnedUser, userOne);
    }

    @Test
    void testSaveTwoUsers_deleteUserOneByUsername_countIsOne() {
        userRepository.save(userTwo);
        userRepository.deleteBy("darda");

        assertEquals(1, userRepository.count());
    }

    @Test
    void testSaveTwoUsers_deleteUserOne_countIsOne() {
        userRepository.save(userTwo);
        userRepository.deleteBy(userOne);

        assertEquals(1, userRepository.count());
    }

    @Test
    void testFindByUsernameThatDoesNotExist_returnsNull() {
        userRepository.save(userTwo);
        assertNull(userRepository.findBy("oyi"));
    }
    @Test
    void testDeleteByUsername_countIsOne(){
        userRepository.deleteBy("man");
        assertEquals(1, userRepository.count());
    }
}
