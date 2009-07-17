/**
 *
 */
package de.atns.sample.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import de.atns.sample.model.EntityA;

import java.util.List;


/**
 * User remote service definition
 *
 * @author bruno.marchesson
 */
@RemoteServiceRelativePath("sample.do")
public interface SampleRemote extends RemoteService {
// ------------------------ INTERFACE METHODS ------------------------


// --------------------- Interface SampleRemoteAsync ---------------------

    public EntityA load(long s);

    public EntityA load(String s);

    public List<EntityA> loadAll();

    public EntityA save(EntityA entityA);

// -------------------------- INNER CLASSES --------------------------

    public static class _ {
        private static SampleRemoteAsync instance;

        public static SampleRemoteAsync getInstance() {
            if (instance == null) {
                instance = (SampleRemoteAsync) GWT.create(SampleRemote.class);
            }
            return instance;
        }
    }
}
