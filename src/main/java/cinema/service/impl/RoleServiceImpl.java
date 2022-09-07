package cinema.service.impl;

import cinema.dao.RoleDao;
import cinema.model.Role;
import cinema.service.RoleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private static final Logger logger =
            LogManager.getLogger(RoleServiceImpl.class);
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role add(Role role) {
        logger.info("Method add was called. Params: role = {}", role.getRoleName());
        return roleDao.add(role);
    }

    @Override
    public Role getByName(String roleName) {
        logger.debug("Method getByName was called. Params: role = {}",
                roleName);
        return roleDao.getByName(Role.RoleName.valueOf(roleName)).get();
    }
}
