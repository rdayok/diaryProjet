package data.repositories;

import data.models.User;

public interface UserRepository {
    User save(User user);
    User findBy(String username);
    User findBy(User user);
    void deleteBy(User user);
    void deleteBy(String username);
    long count();
}
