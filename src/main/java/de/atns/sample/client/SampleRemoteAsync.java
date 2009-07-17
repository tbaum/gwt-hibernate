package de.atns.sample.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import de.atns.sample.model.EntityA;

import java.util.List;

/**
 * Async Callback for User remote service
 *
 * @author bruno.marchesson
 */
public interface SampleRemoteAsync {
// -------------------------- OTHER METHODS --------------------------

    public void load(long s, AsyncCallback<EntityA> callback);

    public void load(String s, AsyncCallback<EntityA> callback);

    public void loadAll(AsyncCallback<List<EntityA>> callback);

    public void save(EntityA entityA, AsyncCallback<EntityA> callback);
}
