package my.company.repository;

import my.company.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User getByFirstName(String s);

   List<User> getAllByRoleRole(String role);
}