package cinema.service.impl;

import java.util.List;

import cinema.dao.CinemaHallDao;
import cinema.lib.Inject;
import cinema.lib.Service;
import cinema.model.CinemaHall;
import cinema.service.CinemaHallService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class CinemaHallServiceImpl implements CinemaHallService {
    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);
    @Inject
    private CinemaHallDao cinemaHallDao;

    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        logger.info("Cinema hall by id {} was added to DB", cinemaHall.getId());
        return cinemaHallDao.add(cinemaHall);
    }

    @Override
    public CinemaHall get(Long id) {
        return cinemaHallDao.get(id).get();
    }

    @Override
    public List<CinemaHall> getAll() {
        return cinemaHallDao.getAll();
    }
}
