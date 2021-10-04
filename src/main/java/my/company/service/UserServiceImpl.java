package my.company.service;

import lombok.RequiredArgsConstructor;
import my.company.config.SpringConfig;
import my.company.exception.NoEntityException;
import my.company.model.User;
import my.company.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    Logger log = Logger.getLogger(SpringConfig.class.getName());

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
    public User get(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new NoEntityException("GAMNISCHE"));
    }
}
