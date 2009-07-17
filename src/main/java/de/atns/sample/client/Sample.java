package de.atns.sample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.gen2.table.event.client.RowSelectionEvent;
import com.google.gwt.gen2.table.event.client.RowSelectionHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import de.atns.sample.model.EntityA;
import org.gwt.beansbinding.core.client.util.GWTBeansBinding;
import org.gwt.mosaic.ui.client.ListBox;
import org.gwt.mosaic.ui.client.WindowPanel;
import org.gwt.mosaic.ui.client.list.DefaultListModel;

import java.util.List;


public class Sample implements EntryPoint {
// -------------------------- STATIC METHODS --------------------------

    static {
        GWTBeansBinding.init();
    }

// ------------------------ INTERFACE METHODS ------------------------


// --------------------- Interface EntryPoint ---------------------

    public void onModuleLoad() {
        final ListBox<EntityA> listBox = new ListBox<EntityA>(new String[]{"Prop1", "Prop2"});
 
        listBox.setWidth("500px");
        listBox.setHeight("200px");
        listBox.setCellRenderer(new ListBox.CellRenderer<EntityA>() {
            public void renderCell(ListBox<EntityA> listBox, int row, int column, EntityA item) {
                switch (column) {
                    case 0:
                        listBox.setText(row, column, item.getProp1());
                        break;
                    case 1:
                        listBox.setText(row, column, item.getProp2());
                        break;

                    default:
                        throw new RuntimeException("Should not happen");
                }
            }
        });
        final DefaultListModel<EntityA> model = (DefaultListModel<EntityA>) listBox.getModel();
        listBox.addRowSelectionHandler(new RowSelectionHandler() {
            public void onRowSelection(RowSelectionEvent rowSelectionEvent) {
                final int selectedIndex = listBox.getSelectedIndex();

                final EntityA entityA = model.getElementAt(selectedIndex);
                final EditModel model1 = new EditModel(entityA);
                final WindowPanel rootPanel = new EditWindow(model1);
                model1.refresh();
                rootPanel.show();
            }
        });

        refreshList(listBox);

        RootPanel.get().add(listBox);

        RootPanel.get().add(new Button("Refresh", new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                refreshList(listBox);
            }
        }

        ));

        /*
final TextBox name = new TextBox();
name.setValue("test");
RootPanel.get().add(name);
RootPanel.get().add(new Button("Edit", new ClickHandler() {
public void onClick(ClickEvent clickEvent) {
SampleRemote._.getInstance().load(name.getValue(), new AsyncCallback<EntityA>() {
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

        */
        RootPanel.get("splash").setVisible(false);
    }

// -------------------------- OTHER METHODS --------------------------

    private void refreshList(final ListBox<EntityA> listBox) {
        SampleRemote._.getInstance().loadAll(new AsyncCallback<List<EntityA>>() {
            public void onFailure(Throwable caught) {
                Window.alert("Exception " + caught.toString());
            }

            public void onSuccess(final List<EntityA> result) {
                DefaultListModel<EntityA> md = (DefaultListModel<EntityA>) listBox.getModel();
                md.clear();
                md.addAll(result);
            }
        });
    }
}
