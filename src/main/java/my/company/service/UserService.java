package my.company.service;

import my.company.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void deletedById(Integer id);

    List<User> selectAll();

    User get(Integer id);
}
