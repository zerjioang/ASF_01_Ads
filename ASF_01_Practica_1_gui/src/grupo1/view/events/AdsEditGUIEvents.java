package grupo1.view.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import grupo1.view.AdminWindow;
import grupo1.view.AdsEditWindow;

public enum AdsEditGUIEvents {
	
	BUTTON_CANCEL {
		@Override
		public ActionListener event(AdsEditWindow window) {
			return new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		System.out.println("cancel button event detected");
	        		window.cancelButtonEvent();
	        	}
	        };
		};
	}, BUTTON_SAVE_CHANGES {
		@Override
		public ActionListener event(AdsEditWindow window) {
			return new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		System.out.println("save button event detected");
	        		window.saveChangesButtonEvent();
	        	}
	        };
		}
	};

	public abstract ActionListener event(AdsEditWindow window);
}
