package cinema.service.impl;

import java.time.LocalDate;
import java.util.List;

import cinema.dao.MovieSessionDao;
import cinema.model.MovieSession;
import cinema.service.MovieSessionService;
import cinema.lib.Inject;
import cinema.lib.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class MovieSessionServiceImpl implements MovieSessionService {
    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);
    @Inject
    private MovieSessionDao sessionDao;

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        logger.info("Finding movie by id {} on {}", movieId, date);
        return sessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public MovieSession get(Long id) {
        return sessionDao.get(id).get();
    }

    @Override
    public MovieSession add(MovieSession session) {
        return sessionDao.add(session);
    }
}
