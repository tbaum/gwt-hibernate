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

    private static final String[] silben = {"de", "kor", "al", "dar", "slev", "lu", "e", "dus", "thar", "ce", "in",
            "ir", "lot", "wirk", "em", "ger", "da", "rin", "tur", "er", "mo", "fe", "shad", "gun", "tas", "i", "tar",
            "ko", "rim", "le", "fen", "lo", "ban", " der", " dak", " me", " ro", " kir", " nol", " rol", " mi", " ral",
            " mon", " mor", " tim", " mik", " ni", " bor", " o", " kos", " ri", " kon", " ort", " mund", " pe", " ne",
            " dol", " raz", " hook", " rog", " len", " ron", " rouk", " rus", " so", " ak", " do", "sol", "cu", "lus",
            "solk", "su", "lurd", "nek", "sek", "ta", "rek", "tark", "ter", "rul", "tha", "dron", "rov", "trod", "turg",
            "u", "ve", "rud", "lun", "zheek", "na", "ie", "ren", "di", "ki", "ma", "no", "la", "ra", "se", "el",
            "si", "ke", "a", "bra", "ti", "re", "ga"};

    @Autowired private EntityDao entityDao;

// ------------------------ INTERFACE METHODS ------------------------


// --------------------- Interface InitializingBean ---------------------

    public void afterPropertiesSet() throws Exception {
        if (entityDao.countAll() == 0) {
            for (int j = 0; j < 30; j++) {
                EntityA entityA = new EntityA(gen(), gen());
                entityA.add(new EntityB(gen(), BigDecimal.valueOf(123), new Date(), entityA));
                entityA.add(new EntityB(gen(), BigDecimal.valueOf(456), new Date(), entityA));
                entityDao.save(entityA);
            }
        }
    }

// -------------------------- OTHER METHODS --------------------------

    private String gen() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(silben[((int) (Math.random() * silben.length))]);
        }
        return sb.toString().trim();
    }
}
