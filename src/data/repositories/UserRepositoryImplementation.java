package data.repositories;

import data.models.User;

import java.util.ArrayList;
import java.util.Objects;

public class UserRepositoryImplementation implements UserRepository{
    private ArrayList<User> users = new ArrayList<>();

    @Override
    public User save(User user) {
        User foundUser = findBy(user.getUsername());
        boolean userExist = foundUser != null;
        if(userExist) update(users.indexOf(foundUser), foundUser);
        else users.add(user);
        return user;
    }

    private void update(int index, User foundUser) {
        users.set(index, foundUser);
    }

    @Override
    public User findBy(String username) {
        for (User user : users){
            boolean foundUser = Objects.equals(user.getUsername().toLowerCase(), username.toLowerCase());
            if (foundUser) return user;
        } return null;
    }

    @Override
    public User findBy(User givenUser) {
        for(User user : users){
            boolean foundUser = Objects.equals(user.getUsername().toLowerCase(), givenUser.getUsername()) && Objects.equals(user.getPassword(), givenUser.getPassword());
            if(foundUser) return user;
        } return null;
    }

    @Override
    public void deleteBy(User user) {
        deleteBy(user.getUsername());
    }

    @Override
    public void deleteBy(String username) {
        User foundUser = findBy(username);
        users.remove(foundUser);
    }

    @Override
    public long count() {
        return users.size();
    }
}
