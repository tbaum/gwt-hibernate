/**
 *
 */
package de.atns.sample.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import de.atns.sample.model.EntityA;


/**
 * User remote service definition
 *
 * @author bruno.marchesson
 */
@RemoteServiceRelativePath("sample.do")
public interface SampleRemote extends RemoteService {
// ------------------------ INTERFACE METHODS ------------------------


// --------------------- Interface UserRemoteAsync ---------------------


    public EntityA loadAllByProp1(String s);

    public EntityA loadAllByProp1AndB(String s);


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
