package grupo1.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import grupo1.view.base.AnunciusJFrame;
import grupo1.view.events.AdminGUIEvents;
import grupo1.view.events.AdsEditGUIEvents;
import grupo1.view.events.UserEditGUIEvents;

import java.awt.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UsersEditWindow extends AnunciusJFrame {
	
	private JTextField textField;
	private int id;
	private JTextField textFieldAdsID;
	private JTextField textFieldAdsTitle;
	private JTextField textFieldAdsDescription;
	private JTextField textFieldAdsCreator;
	private JTextField textFieldAdsPrice;

    /**
     * Create the frame.
     */
    public UsersEditWindow() {
    	
        init();
    }

    public UsersEditWindow(int id) {
    	this.id = id;
    	init();
	}
    
    private void init(){
    	setResizable(false);
    	setType(Type.POPUP);
    	setAutoRequestFocus(false);
    	
    	setTitle("Anuncius Admin | Edit User");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 280);
        setMinimumSize(new Dimension(450, 280));
        
        JPanel panelBannerWarning = new JPanel();
        panelBannerWarning.setBackground(Color.RED);
        getContentPane().add(panelBannerWarning, BorderLayout.NORTH);
        
        JLabel lblWarningYouAre = new JLabel("Warning: you are editing a User profile");
        lblWarningYouAre.setBackground(Color.RED);
        lblWarningYouAre.setForeground(Color.WHITE);
        panelBannerWarning.add(lblWarningYouAre);
        
        JPanel panelWindowContent = new JPanel();
        getContentPane().add(panelWindowContent, BorderLayout.CENTER);
        
        JLabel lblAdvertisementId = new JLabel("User ID");
        
        JLabel lblTitle = new JLabel("Name");
        
        JLabel lblDescription = new JLabel("Email");
        
        JLabel lblCreatedBy = new JLabel("Password");
        
        JLabel lblPrice = new JLabel("Registration date");
        
        textFieldAdsID = new JTextField();
        textFieldAdsID.setColumns(10);
        
        textFieldAdsTitle = new JTextField();
        textFieldAdsTitle.setColumns(10);
        
        textFieldAdsDescription = new JTextField();
        textFieldAdsDescription.setColumns(10);
        
        textFieldAdsCreator = new JTextField();
        textFieldAdsCreator.setColumns(10);
        
        textFieldAdsPrice = new JTextField();
        textFieldAdsPrice.setColumns(10);
        
        JButton btnSaveChanges = new JButton("Save changes");
        btnSaveChanges.addActionListener(UserEditGUIEvents.BUTTON_SAVE_CHANGES.event(this));
        
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(UserEditGUIEvents.BUTTON_CANCEL.event(this));
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
    }

	/**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
            	UsersEditWindow frame = new UsersEditWindow();
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
		
	}
}
