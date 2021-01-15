package by.company.dao;

import by.company.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();

    void save(User user);

    void delete(Long id);

    User get(Long id);
}
