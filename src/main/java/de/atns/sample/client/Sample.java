package de.atns.sample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import de.atns.sample.model.EntityA;
import org.gwt.beansbinding.core.client.util.GWTBeansBinding;
import org.gwt.mosaic.ui.client.WindowPanel;


public class Sample implements EntryPoint {
// -------------------------- STATIC METHODS --------------------------

    static {
        GWTBeansBinding.init();
    }

// ------------------------ INTERFACE METHODS ------------------------


// --------------------- Interface EntryPoint ---------------------

    public void onModuleLoad() {
        final TextBox name = new TextBox();
        name.setValue("test");
        RootPanel.get().add(name);
        RootPanel.get().add(new Button("Edit", new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                SampleRemote._.getInstance().loadAllByProp1AndB(name.getValue(), new AsyncCallback<EntityA>() {
                    public void onFailure(Throwable caught) {
                        Window.alert("Exception: " + caught);
                    }

                    public void onSuccess(EntityA result) {
                        if (result == null) {
                            Window.alert("no entitya found");
                        } else {
                            final EditModel model = new EditModel(result);
                            final WindowPanel rootPanel = new EditWindow(model);
                            rootPanel.show();
                        }
                    }
                });
            }
        }

        ));


        RootPanel.get("splash").setVisible(false);
    }
}
