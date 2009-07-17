package de.atns.sample.client;

import de.atns.sample.model.EntityB;

import java.util.Set;

/**
 * @author tbaum
 * @since 17.07.2009 15:13:36
 */
public interface EditListener {
    // -------------------------- OTHER METHODS --------------------------
    void setList(Set<EntityB> list);

    void setProp1(String prop1);

    void setProp2(String prop2);
}
