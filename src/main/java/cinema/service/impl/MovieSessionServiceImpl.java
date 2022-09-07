package cinema.service.impl;

import cinema.dao.MovieSessionDao;
import cinema.model.MovieSession;
import cinema.service.MovieSessionService;
import java.time.LocalDate;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class MovieSessionServiceImpl implements MovieSessionService {
    private static final Logger logger =
            LogManager.getLogger(MovieSessionServiceImpl.class);
    private final MovieSessionDao movieSessionDao;

    public MovieSessionServiceImpl(MovieSessionDao movieSessionDao) {
        this.movieSessionDao = movieSessionDao;
    }

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        logger.debug("Method findAvailableSessions was called. Params: movieId = {}, date = {}",
                movieId, date);
        return movieSessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public MovieSession add(MovieSession session) {
        logger.info("Method add was called. Params: session = {}",
                session.getId());
        return movieSessionDao.add(session);
    }

    @Override
    public MovieSession get(Long id) {
        logger.debug("Method get was called. Params: id = {}", id);
        return movieSessionDao.get(id).orElseThrow(
                () -> new RuntimeException("Session with id " + id + " not found"));
    }

    @Override
    public MovieSession update(MovieSession movieSession) {
        logger.debug("Method update was called. Params: movieSession = {}",
                movieSession.getId());
        return movieSessionDao.update(movieSession);
    }

    @Override
    public void delete(Long id) {
        logger.info("Method delete was called. Params: id = {}", id);
        movieSessionDao.delete(id);
    }
}
