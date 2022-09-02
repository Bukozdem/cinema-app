package cinema.service.impl;

import java.util.List;
import cinema.dao.MovieDao;
import cinema.lib.Inject;
import cinema.lib.Service;
import cinema.model.Movie;
import cinema.service.MovieService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class MovieServiceImpl implements MovieService {
    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);
    @Inject
    private MovieDao movieDao;

    @Override
    public Movie add(Movie movie) {
        logger.info("Movie {} was added to DB", movie.getTitle());
        return movieDao.add(movie);
    }

    @Override
    public Movie get(Long id) {
        return movieDao.get(id).get();
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }
}
