package de.atns.sample;

import de.atns.sample.model.EntityA;

import java.util.List;

/**
 * @author tbaum
 * @since 13.07.2009 12:33:16
 */
public interface EntityDao {
// -------------------------- OTHER METHODS --------------------------

    Long countAll();

    EntityA load(long id);

    EntityA load(String login);

    List<EntityA> loadAll();

    EntityA save(EntityA entityA);
}
