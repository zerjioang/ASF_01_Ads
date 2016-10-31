package grupo1.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.axis2.AxisFault;

import grupo1.controller.AdsEditController;
import grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException;
import grupo1.dao.AdvertisementEndpointSQLExceptionException;
import grupo1.pojo.AdvertisementPOJO;
import grupo1.view.base.AnunciusJFrame;
import grupo1.view.events.AdminGUIEvents;
import grupo1.view.events.AdsEditGUIEvents;

import java.awt.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;

public class AdsEditWindow extends AnunciusJFrame {
	
	private JTextField textField;
	private int id;
	private JTextField textFieldAdsID;
	private JTextField textFieldAdsTitle;
	private JTextField textFieldAdsDescription;
	private JTextField textFieldAdsCreator;
	private JTextField textFieldAdsPrice;
	private AdvertisementPOJO advertisement;
	private AdsEditController controller;
	private AdminWindow adminWindow;

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

    public AdsEditWindow(int id) {
    	this.id = id;
    	init();
	}
    
    public AdsEditWindow() {
    	init();
	}

	private void init(){
    	
    	setResizable(false);
    	setType(Type.POPUP);
    	setAutoRequestFocus(false);
    	
    	setTitle("Anuncius Admin | Edit Advertisement");
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 280);
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
        
        textFieldAdsID = new JTextField();
        textFieldAdsID.setColumns(10);
        textFieldAdsID.setEditable(false);
        
        textFieldAdsTitle = new JTextField();
        textFieldAdsTitle.setColumns(10);
        
        textFieldAdsDescription = new JTextField();
        textFieldAdsDescription.setColumns(10);
        
        textFieldAdsCreator = new JTextField();
        textFieldAdsCreator.setColumns(10);
        textFieldAdsCreator.setEditable(false);
        
        textFieldAdsPrice = new JTextField();
        textFieldAdsPrice.setColumns(10);
        
        JButton btnSaveChanges = new JButton("Save changes");
        btnSaveChanges.addActionListener(AdsEditGUIEvents.BUTTON_SAVE_CHANGES.event(this));
        
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(AdsEditGUIEvents.BUTTON_CANCEL.event(this));
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
        						.addComponent(lblDescription)
        						.addComponent(lblCreatedBy)
        						.addComponent(lblPrice))
        					.addGap(51)
        					.addGroup(gl_panelWindowContent.createParallelGroup(Alignment.LEADING)
        						.addComponent(textFieldAdsTitle, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
        						.addComponent(textFieldAdsID, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
        						.addComponent(textFieldAdsDescription, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
        						.addComponent(textFieldAdsCreator, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
        						.addComponent(textFieldAdsPrice, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)))
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
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_panelWindowContent.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblCreatedBy)
        				.addComponent(textFieldAdsCreator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_panelWindowContent.createParallelGroup(Alignment.TRAILING)
        				.addComponent(lblPrice)
        				.addComponent(textFieldAdsPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(gl_panelWindowContent.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnSaveChanges)
        				.addComponent(btnCancel))
        			.addContainerGap(133, Short.MAX_VALUE))
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
					advertisement = controller.getAd(id);
					textFieldAdsID.setText(String.valueOf(advertisement.getId()));
					textFieldAdsTitle.setText(advertisement.getName());
					textFieldAdsDescription.setText(advertisement.getDescription());
					textFieldAdsCreator.setText(advertisement.getAuthor().getName());
					textFieldAdsPrice.setText(String.valueOf(advertisement.getPrice()));
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
			advertisement.setName(textFieldAdsTitle.getText());
			advertisement.setDescription(textFieldAdsDescription.getText());
			advertisement.setPrice(Float.valueOf(textFieldAdsPrice.getText()));
			controller.updateAd(advertisement);
			
			adminWindow.updateTables();
			this.dispose();
		} catch (RemoteException | AdvertisementEndpointClassNotFoundExceptionException
				| AdvertisementEndpointSQLExceptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
