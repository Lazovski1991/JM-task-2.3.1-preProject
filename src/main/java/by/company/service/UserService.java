package by.company.service;

import by.company.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    void save(User user);

    void delete(Long id);

    User get(Long id);
}
