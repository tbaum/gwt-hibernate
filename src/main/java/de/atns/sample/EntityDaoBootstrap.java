package de.atns.sample;

import de.atns.sample.model.EntityA;
import de.atns.sample.model.EntityB;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author tbaum
 * @since 17.07.2009 13:28:37
 */
@Service public class EntityDaoBootstrap implements InitializingBean {
// ------------------------------ FIELDS ------------------------------

    @Autowired private EntityDao entityDao;

// ------------------------ INTERFACE METHODS ------------------------


// --------------------- Interface InitializingBean ---------------------

    public void afterPropertiesSet() throws Exception {
        if (entityDao.countAll() == 0) {
            EntityA entityA = new EntityA("test", "secret");
            entityA.add(new EntityB("First", BigDecimal.valueOf(123), new Date(), entityA));
            entityA.add(new EntityB("Another", BigDecimal.valueOf(456), new Date(), entityA));
            entityDao.save(entityA);
        }
    }
}
