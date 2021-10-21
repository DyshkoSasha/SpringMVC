package my.company.service;

import my.company.model.User;
import my.company.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.management.relation.RoleNotFoundException;
import java.util.List;

public interface UserService extends UserDetailsService{
    void addUser(User user);

    void deletedById(Long id);

    User getById(Long id);

    List<User> findAllUser();

//    List<User> loadColectionByRole(String role);

}
