package my.company.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import my.company.exception.NoEntityException;
import my.company.model.User;
import my.company.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Log
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
        log.info("SAVED USERS");
    }

    @Override
    public void deletedById(Integer id) {
        userRepository.deleteById(id);
    }

       @Override
    @Transactional(readOnly = true)
    public List<User> selectAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new NoEntityException("GAMNISCHE"));
    }
}
