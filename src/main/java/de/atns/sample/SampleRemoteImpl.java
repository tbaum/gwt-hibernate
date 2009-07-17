package de.atns.sample;

import de.atns.common.gwt.PersistentGwtController;
import de.atns.sample.client.SampleRemote;
import de.atns.sample.model.EntityA;
import net.sf.gilead.core.PersistentBeanManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author tbaum
 * @since 12.07.2009 22:15:56
 */
@Controller("/de.atns.sample.Sample/sample.do")
public class SampleRemoteImpl extends PersistentGwtController implements SampleRemote {
// ------------------------------ FIELDS ------------------------------

    @Autowired private EntityDao entityDao;

// --------------------------- CONSTRUCTORS ---------------------------

    @Autowired
    public SampleRemoteImpl(PersistentBeanManager persistentBeanManager) {
        setBeanManager(persistentBeanManager);
    }

// ------------------------ INTERFACE METHODS ------------------------


// --------------------- Interface SampleRemoteAsync ---------------------

    public EntityA load(long id) {
        return entityDao.load(id);
    }

    public List<EntityA> loadAll() {
        return entityDao.loadAll();
    }

    public EntityA save(EntityA entityA) {
        return entityDao.save(entityA);
    }

// -------------------------- OTHER METHODS --------------------------

    public EntityA load(String s) {
        return entityDao.load(s);
    }
}
