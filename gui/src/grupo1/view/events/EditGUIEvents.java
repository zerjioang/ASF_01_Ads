package grupo1.view.events;

import java.awt.event.ActionEvent;

import grupo1.view.EditWindow;

public enum EditGUIEvents {
	
	EDIT_TABLE_ELEMENT {
        @Override
        public void event(ActionEvent event) {
            System.out.println(event.toString() + "edit table element event detected");
            EditWindow win = new EditWindow();
        }
    };

    public abstract void event(ActionEvent event);
}
