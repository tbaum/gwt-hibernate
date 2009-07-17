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

    EntityA loadA(Integer id);

    EntityA loadA(String login);

    EntityA loadAfull(String login);

    List<EntityA> loadAll();

    EntityA save(EntityA entityA);
}
