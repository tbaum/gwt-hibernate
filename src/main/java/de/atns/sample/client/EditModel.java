package de.atns.sample.client;

import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import de.atns.sample.model.EntityA;
import de.atns.sample.model.EntityB;

import static java.math.BigDecimal.valueOf;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author tbaum
 * @since 17.07.2009 14:37:04
 */
public class EditModel {
// ------------------------------ FIELDS ------------------------------

    private final Set<EditListener> listener = new HashSet<EditListener>();
    private EntityA entity;

// --------------------------- CONSTRUCTORS ---------------------------

    public EditModel(EntityA entity) {
        this.entity = entity;
    }

// -------------------------- OTHER METHODS --------------------------

    public void add(String value) {
        entity.add(new EntityB(value, valueOf(Random.nextDouble()), new Date(), entity));
    }

    public void addListener(EditListener editWindow) {
        listener.add(editWindow);
    }

    public void refresh() {
        SampleRemote._.getInstance().loadAllByProp1AndB(entity.getProp1(), new AsyncCallback<EntityA>() {
            public void onFailure(Throwable caught) {
                Window.alert("Exception: " + caught);
            }

            public void onSuccess(EntityA result) {
                EditModel.this.entity = result;
                updateDisplay();
            }
        });
    }

    public void updateDisplay() {
        for (EditListener editWindow : listener) {
            editWindow.setProp1(entity.getProp1());
            editWindow.setProp2(entity.getProp2());
            editWindow.setList(entity.getList());
        }
    }

    public void removeListener(EditListener editWindow) {
        listener.remove(editWindow);
    }

    public void save() {
        SampleRemote._.getInstance().save(entity, new AsyncCallback<EntityA>() {
            public void onFailure(Throwable caught) {
                Window.alert("Exception: " + caught);
            }

            public void onSuccess(EntityA result) {
                entity = result;
                updateDisplay();

                Window.alert("saved: " + result);
            }
        });
    }

    public void setProp1(String value) {
        entity.setProp1(value);
    }

    public void setProp2(String value) {
        entity.setProp2(value);
    }

    public EntityB findItem(long id) {
        for (EntityB entityB : entity.getList()) {
            if (entityB.getId() == id) return entityB;
        }
        return null;

    }
}
