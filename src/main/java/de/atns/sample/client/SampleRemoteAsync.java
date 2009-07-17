package de.atns.sample.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import de.atns.sample.model.EntityA;

/**
 * Async Callback for User remote service
 *
 * @author bruno.marchesson
 */
public interface SampleRemoteAsync {
// -------------------------- OTHER METHODS --------------------------

    public void loadAllByProp1(String s, AsyncCallback<EntityA> callback);

    public void loadAllByProp1AndB(String s, AsyncCallback<EntityA> callback);

    public void save(EntityA entityA, AsyncCallback<EntityA> callback);
}
