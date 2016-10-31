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
    }, MENU_BACKUP {
        @Override
        public ActionListener event(AdminWindow window) {
            return new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("Menu backup event detected");
		            window.openMenuBackup();
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
	}, EDIT_CATEGORY {
		@Override
		public ActionListener event(AdminWindow window) {
			return new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("category selected for edition");
					window.editCategory();
				}
			};
		}
	}, EDIT_USER {
		@Override
		public ActionListener event(AdminWindow window) {
			return new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("user selected for edition");
					window.editUser();
				}
			};
		}
	}, NEW_ADVERTISEMENT {
		@Override
		public ActionListener event(AdminWindow window) {
			return new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("new advertisement");
					window.newAdvertisement();
				}
			};
		}
	}, DELETE_ADVERTISEMENT {
		@Override
		public ActionListener event(AdminWindow window) {
			return new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("delete advertisement");
					window.deleteAdvertisement();
				}
			};
		}
	}, NEW_USER {
		@Override
		public ActionListener event(AdminWindow window) {
			return new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("new user");
					window.newUser();
				}
			};
		}
	}, DELETE_USER {
		@Override
		public ActionListener event(AdminWindow window) {
			return new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("delete user");
					window.deleteUser();
				}
			};
		}
	}, NEW_CATEGORY {
		@Override
		public ActionListener event(AdminWindow window) {
			return new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("new category");
					window.newCategory();
				}
			};
		}
	}, DELETE_CATEGORY {
		@Override
		public ActionListener event(AdminWindow window) {
			return new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("delete category");
					window.deleteCategory();
				}
			};
		}
	}, MENU_RESTORE {
		@Override
		public ActionListener event(AdminWindow window) {
			return new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("menur restore");
					window.menuRestore();
				}
			};
		}
	};

    public abstract ActionListener event(AdminWindow window);
}
