package grupo1.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.rmi.RemoteException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.apache.axis2.AxisFault;

import grupo1.controller.AdsEditController;
import grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException;
import grupo1.dao.AdvertisementEndpointSQLExceptionException;
import grupo1.dto.xsd.Advertisement;
import grupo1.pojo.AdvertisementPOJO;
import grupo1.view.base.AnunciusJFrame;
import grupo1.view.events.AdsEditGUIEvents;

public class AdsEditWindow extends AnunciusJFrame {
	
	private JTextField textField;
	private int id;
	private JTextField txtId;
	private JTextField txtTitle;
	private JTextField txtDescription;
	private JTextField txtCreator;
	private JTextField txtPrice;
	private AdvertisementPOJO advertisement;
	private AdsEditController controller;
	private AdminWindow adminWindow;
	private JTextField txtCategory;

    /**
     * Create the frame.
     * @param adminWindow 
     * @param id2 
     */
    public AdsEditWindow(int id2, AdminWindow adminWindow) {
    	this.id = id2;
    	this.adminWindow = adminWindow;
        init();
    }

    public AdsEditWindow() {
    	init();
	}
    
    public AdsEditWindow(int id) {
    	this.id = id;
    	init();
	}
    
    public AdsEditWindow(AdminWindow adminWindow) {
    	this.adminWindow = adminWindow;
    	init();
	}

	private void init(){
    	
    	setResizable(false);
    	setType(Type.POPUP);
    	setAutoRequestFocus(false);
    	
    	setTitle("Anuncius Admin | Edit Advertisement");
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 312);
        setMinimumSize(new Dimension(450, 280));
        
        JPanel panelBannerWarning = new JPanel();
        panelBannerWarning.setBackground(Color.RED);
        getContentPane().add(panelBannerWarning, BorderLayout.NORTH);
        
        JLabel lblWarningYouAre = new JLabel("Warning: you are editing a user message");
        lblWarningYouAre.setBackground(Color.RED);
        lblWarningYouAre.setForeground(Color.WHITE);
        panelBannerWarning.add(lblWarningYouAre);
        
        JPanel panelWindowContent = new JPanel();
        getContentPane().add(panelWindowContent, BorderLayout.CENTER);
        
        JLabel lblAdvertisementId = new JLabel("Advertisement ID");
        
        JLabel lblTitle = new JLabel("Title");
        
        JLabel lblDescription = new JLabel("Description");
        
        JLabel lblCreatedBy = new JLabel("Created by");
        
        JLabel lblPrice = new JLabel("Price");
        
        txtId = new JTextField();
        txtId.setColumns(10);
        txtId.setEditable(false);
        
        txtTitle = new JTextField();
        txtTitle.setColumns(10);
        
        txtDescription = new JTextField();
        txtDescription.setColumns(10);
        
        txtCreator = new JTextField();
        txtCreator.setColumns(10);
        txtCreator.setEditable(false);
        
        txtPrice = new JTextField();
        txtPrice.setColumns(10);
        
        JButton btnSaveChanges = new JButton("Save changes");
        btnSaveChanges.addActionListener(AdsEditGUIEvents.BUTTON_SAVE_CHANGES.event(this));
        
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(AdsEditGUIEvents.BUTTON_CANCEL.event(this));
        
        txtCategory = new JTextField();
        txtCategory.setColumns(10);
        
        JLabel labelCategory = new JLabel("Category");
        GroupLayout gl_panelWindowContent = new GroupLayout(panelWindowContent);
        gl_panelWindowContent.setHorizontalGroup(
        	gl_panelWindowContent.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panelWindowContent.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_panelWindowContent.createParallelGroup(Alignment.LEADING)
        				.addGroup(Alignment.TRAILING, gl_panelWindowContent.createSequentialGroup()
        					.addGroup(gl_panelWindowContent.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblAdvertisementId)
        						.addComponent(lblTitle)
        						.addComponent(lblDescription)
        						.addComponent(lblCreatedBy)
        						.addComponent(lblPrice))
        					.addGap(51)
        					.addGroup(gl_panelWindowContent.createParallelGroup(Alignment.LEADING)
        						.addComponent(txtTitle, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
        						.addComponent(txtId, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
        						.addComponent(txtDescription, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
        						.addComponent(txtCreator, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
        						.addComponent(txtPrice, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)))
        				.addGroup(Alignment.TRAILING, gl_panelWindowContent.createSequentialGroup()
        					.addComponent(btnCancel)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnSaveChanges))
        				.addGroup(Alignment.TRAILING, gl_panelWindowContent.createSequentialGroup()
        					.addComponent(labelCategory, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(txtCategory, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        gl_panelWindowContent.setVerticalGroup(
        	gl_panelWindowContent.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panelWindowContent.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_panelWindowContent.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblAdvertisementId)
        				.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_panelWindowContent.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblTitle)
        				.addComponent(txtTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_panelWindowContent.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblDescription)
        				.addComponent(txtDescription, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_panelWindowContent.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblCreatedBy)
        				.addComponent(txtCreator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_panelWindowContent.createParallelGroup(Alignment.TRAILING)
        				.addComponent(lblPrice)
        				.addComponent(txtPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_panelWindowContent.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtCategory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(labelCategory))
        			.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
        			.addGroup(gl_panelWindowContent.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnSaveChanges)
        				.addComponent(btnCancel))
        			.addContainerGap())
        );
        panelWindowContent.setLayout(gl_panelWindowContent);
        
      //set location to center of the screen
        setLocationRelativeTo(null);
        
        contentPane.setBorder(null);
        
        //set visible
        setVisible(true);
        
        populate();
    }

	private void populate() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					controller = new AdsEditController();
				} catch (AxisFault e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        try {
		        	if (id > 0) {
		        		advertisement = controller.getAd(id);
						txtId.setText(String.valueOf(advertisement.getId()));
						txtTitle.setText(advertisement.getName());
						txtDescription.setText(advertisement.getDescription());
						txtCreator.setText(advertisement.getAuthor().getName());
						txtPrice.setText(String.valueOf(advertisement.getPrice()));		        		
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
            	AdsEditWindow frame = new AdsEditWindow();
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
		try {
			if (id > 0) {
				advertisement.setName(txtTitle.getText());
				advertisement.setDescription(txtDescription.getText());
				try {
					advertisement.setPrice(Float.valueOf(txtPrice.getText()));
					controller.updateAd(advertisement);		
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(this, "Please enter a valid price value", "Invalid value", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				Advertisement ad = new Advertisement();
				ad.setName(txtTitle.getText());
				ad.setDescription(txtDescription.getText());
				try {
					ad.setPrice(Float.valueOf(txtPrice.getText()));
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(this, "Please enter a valid price value", "Invalid value", JOptionPane.ERROR_MESSAGE);
				}			
				
				int creatorId;
				try {
					creatorId = Integer.valueOf(txtCreator.getText());
					try {
						int categoryId = Integer.valueOf(txtCategory.getText());
						controller.insertAd(ad, creatorId, categoryId);
						adminWindow.updateTables();
						this.dispose();
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(this, "Please enter a valid category ID", "Invalid value", JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(this, "Please enter a valid creator ID", "Invalid value", JOptionPane.ERROR_MESSAGE);
				}
			}
		} catch (RemoteException | AdvertisementEndpointClassNotFoundExceptionException
				| AdvertisementEndpointSQLExceptionException e) {
			e.printStackTrace();
		}
	}
}
