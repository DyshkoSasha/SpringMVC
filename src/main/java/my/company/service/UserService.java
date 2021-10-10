package my.company.service;

import my.company.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService extends UserDetailsService{
    void addUser(User user);

    void deletedById(Integer id);

    List<User> selectAll();

    User getById(Integer id);

    List<User> findAllUser();
}
