package cinema.service.impl;

import cinema.dao.UserDao;
import cinema.model.User;
import cinema.service.UserService;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger =
            LogManager.getLogger(UserServiceImpl.class);
    private final PasswordEncoder encoder;
    private final UserDao userDao;

    public UserServiceImpl(PasswordEncoder encoder, UserDao userDao) {
        this.encoder = encoder;
        this.userDao = userDao;
    }

    @Override
    public User add(User user) {
        logger.info("Method add was called. Params: email = {}", user.getEmail());
        user.setPassword(encoder.encode(user.getPassword()));
        return userDao.add(user);
    }

    @Override
    public User get(Long id) {
        logger.debug("Method get get called. Params: id = {}", id);
        return userDao.get(id).orElseThrow(
                () -> new RuntimeException("User with id " + id + " not found"));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        logger.debug("Method findByEmail was called. Params: email = {}", email);
        return userDao.findByEmail(email);
    }
}
