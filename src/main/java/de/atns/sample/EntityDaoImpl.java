package de.atns.sample;

import de.atns.sample.model.EntityA;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;
import static org.springframework.transaction.annotation.Propagation.SUPPORTS;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * @author tbaum
 * @since 10.06.2009 21:36:37
 */
@Service public class EntityDaoImpl extends HibernateTemplate implements EntityDao {
// --------------------------- CONSTRUCTORS ---------------------------

    @Autowired
    public EntityDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

// ------------------------ INTERFACE METHODS ------------------------


// --------------------- Interface EntityDao ---------------------

    @Transactional(propagation = SUPPORTS) public Long countAll() {
        return (Long) execute(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                return session.createQuery("select count(*) from EntityA a").uniqueResult();
            }
        });
    }

    @Transactional(propagation = SUPPORTS) public EntityA load(final long s) {
        return (EntityA) execute(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                final Object o = session
                        .createQuery("from EntityA a left join fetch a.list where a.id =:id")
                        .setParameter("id", s)
                        .uniqueResult();
                System.err.println(o);
                return o;
            }
        });
    }

    @Transactional(propagation = SUPPORTS) public EntityA load(final String s) {
        return (EntityA) execute(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                final Object o = session
                        .createQuery("from EntityA a left join fetch a.list where a.prop1 =:prop1")
                        .setParameter("prop1", s)
                        .uniqueResult();
                System.err.println(o);
                return o;
            }
        });
    }

    @Transactional(propagation = SUPPORTS) public List<EntityA> loadAll() {
        return (List<EntityA>) execute(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                return session.createQuery("from EntityA a").list();
            }
        });
    }

    @Transactional(propagation = SUPPORTS) public EntityA save(final EntityA entityA) {
        return (EntityA) execute(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                System.err.println(entityA);
                return session.merge(entityA);
            }
        });
    }
}
