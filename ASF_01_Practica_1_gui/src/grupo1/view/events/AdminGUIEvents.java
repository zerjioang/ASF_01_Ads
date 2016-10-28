package grupo1.view.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import grupo1.view.AdminWindow;

public enum AdminGUIEvents {
	
    MENU_CONFIGURE {
        @Override
        public ActionListener event(AdminWindow window) {
            return new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("Configure tracker event detected");
		            window.configureAnuncius();
				}
			};
        }
    }, MENU_ABOUT {
        @Override
        public ActionListener event(AdminWindow window) {
            return new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("menu about event detected");
		            window.openMenuAbout();
				}
			};
        }
    }, MENU_EXIT {
        @Override
        public ActionListener event(AdminWindow window) {
            return new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("Menu exit event detected");
		            window.openMenuExit();
				}
			};
        }
    },QUERY_ENTER {
		@Override
		public ActionListener event(AdminWindow window) {
			return new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("query entered");
					window.queryEnterEvent();
				}
			};
		}
	}, EDIT_ADVERTISEMENT {
		@Override
		public ActionListener event(AdminWindow window) {
			return new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("ad selected for edition");
					window.editAdvertisement();
				}
			};
		}
	};

    public abstract ActionListener event(AdminWindow window);
}
