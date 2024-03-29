package grupo1.view;

import javax.swing.*;
import org.apache.axis2.AxisFault;

import grupo1.controller.CategoriesEditController;
import grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException;
import grupo1.dao.AdvertisementEndpointSQLExceptionException;
import grupo1.dto.xsd.Category;
import grupo1.pojo.CategoryPOJO;
import grupo1.view.base.AnunciusJFrame;
import grupo1.view.events.CategoryEditGUIEvents;

import java.awt.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.rmi.RemoteException;

@SuppressWarnings("serial")
public class CategoriesEditWindow extends AnunciusJFrame {
	
	@SuppressWarnings("unused")
	private JTextField textField;
	private int id;
	private JTextField textFieldAdsID;
	private JTextField textFieldAdsTitle;
	private JTextField textFieldAdsDescription;
	private AdminWindow adminWindow;
	private CategoriesEditController controller;
	private CategoryPOJO category;

    /**
     * Create the frame.
     */
    public CategoriesEditWindow() {
        init();
    }

    public CategoriesEditWindow(int id) {
    	this.id = id;
    	init();
    	populate();
	}
    
    public CategoriesEditWindow(int id, AdminWindow adminWindow) {
    	this.id = id;
    	this.adminWindow = adminWindow;
    	init();
    	populate();
	}
    
    public CategoriesEditWindow(AdminWindow adminWindow) {
		this.adminWindow = adminWindow;
		init();
		populate();
	}

	private void init(){
    	
    	setResizable(false);
    	setType(Type.POPUP);
    	setAutoRequestFocus(false);
    	
    	setTitle("Anuncius Admin | Edit Categories");
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 205);
        setMinimumSize(new Dimension(450, 205));
        
        JPanel panelWindowContent = new JPanel();
        getContentPane().add(panelWindowContent, BorderLayout.CENTER);
        
        JLabel lblAdvertisementId = new JLabel("Category ID");
        
        JLabel lblTitle = new JLabel("Name");
        
        JLabel lblDescription = new JLabel("Description");
        
        textFieldAdsID = new JTextField();
        textFieldAdsID.setColumns(10);
        textFieldAdsID.setEditable(false);
        
        textFieldAdsTitle = new JTextField();
        textFieldAdsTitle.setColumns(10);
        
        textFieldAdsDescription = new JTextField();
        textFieldAdsDescription.setColumns(10);
        
        JButton btnSaveChanges = new JButton("Save changes");
        btnSaveChanges.addActionListener(CategoryEditGUIEvents.BUTTON_SAVE_CHANGES.event(this));
        
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(CategoryEditGUIEvents.BUTTON_CANCEL.event(this));
        GroupLayout gl_panelWindowContent = new GroupLayout(panelWindowContent);
        gl_panelWindowContent.setHorizontalGroup(
        	gl_panelWindowContent.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panelWindowContent.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_panelWindowContent.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panelWindowContent.createSequentialGroup()
        					.addGroup(gl_panelWindowContent.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblAdvertisementId)
        						.addComponent(lblTitle)
        						.addComponent(lblDescription))
        					.addGap(51)
        					.addGroup(gl_panelWindowContent.createParallelGroup(Alignment.LEADING)
        						.addComponent(textFieldAdsTitle, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
        						.addComponent(textFieldAdsID, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
        						.addComponent(textFieldAdsDescription, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)))
        				.addGroup(Alignment.TRAILING, gl_panelWindowContent.createSequentialGroup()
        					.addComponent(btnCancel)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnSaveChanges)))
        			.addContainerGap())
        );
        gl_panelWindowContent.setVerticalGroup(
        	gl_panelWindowContent.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panelWindowContent.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_panelWindowContent.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblAdvertisementId)
        				.addComponent(textFieldAdsID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_panelWindowContent.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblTitle)
        				.addComponent(textFieldAdsTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_panelWindowContent.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblDescription)
        				.addComponent(textFieldAdsDescription, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(gl_panelWindowContent.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnSaveChanges)
        				.addComponent(btnCancel))
        			.addContainerGap(88, Short.MAX_VALUE))
        );
        panelWindowContent.setLayout(gl_panelWindowContent);
        
      //set location to center of the screen
        setLocationRelativeTo(null);
        
        contentPane.setBorder(null);
        
        //set visible
        setVisible(true);
    }

	private void populate() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
		        try {
					controller = new CategoriesEditController();
				} catch (AxisFault e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        try {
		        	if (id > 0){
		        		category = controller.getCategory(id);
		        		if(category!=null){
		        			textFieldAdsID.setText(String.valueOf(category.getId()));
					        textFieldAdsTitle.setText(category.getName());
					        textFieldAdsDescription.setText(category.getDescription());
		        		}
		        	}
				} catch (RemoteException | AdvertisementEndpointClassNotFoundExceptionException
						| AdvertisementEndpointSQLExceptionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}

	/**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
            	CategoriesEditWindow frame = new CategoriesEditWindow();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

	public void cancelButtonEvent() {
		this.dispose();
	}

	public void saveChangesButtonEvent() {
		
		if(id > 0){
			updateCategory(category);
		}
		else{
			addCategory();
		}
		adminWindow.updateTables();
		this.dispose();
	}

	private void updateCategory(CategoryPOJO category) {
		category.setName(textFieldAdsTitle.getText());
		category.setDescription(textFieldAdsDescription.getText());
		try {
			controller.updateCategory(category);
		} catch (RemoteException | AdvertisementEndpointClassNotFoundExceptionException
				| AdvertisementEndpointSQLExceptionException e) {
			JOptionPane.showMessageDialog(this, e.getLocalizedMessage(), "Error on "+e.getClass().getSimpleName(), JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void addCategory() {
		Category c = new Category();
		c.setName(textFieldAdsTitle.getText());
		c.setDescription(textFieldAdsDescription.getText());
		try {
			controller.insertCategory(c);
		} catch (RemoteException | AdvertisementEndpointClassNotFoundExceptionException
				| AdvertisementEndpointSQLExceptionException e) {
			JOptionPane.showMessageDialog(this, e.getLocalizedMessage(), "Error on "+e.getClass().getSimpleName(), JOptionPane.ERROR_MESSAGE);
		}
	}
}
