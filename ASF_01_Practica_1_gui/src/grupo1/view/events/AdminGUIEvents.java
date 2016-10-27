package grupo1.view.events;

import java.awt.event.ActionEvent;

public enum AdminGUIEvents {
    MENU_CONFIGURE_TRACKER {
        @Override
        public void event(ActionEvent event) {
            System.out.println(event.toString() + "Configure tracker event detected");
        }
    }, MENU_ABOUT {
        @Override
        public void event(ActionEvent event) {
            System.out.println("menu about event detected");
        }
    }, MENU_EXIT {
        @Override
        public void event(ActionEvent event) {
            System.out.println("Menu exit event detected");
        }
    }, MENU_FORCE_STOP {
        @Override
        public void event(ActionEvent event) {
            System.out.println("Menu force stop event detected");
        }
    };

    public abstract void event(ActionEvent event);
}
