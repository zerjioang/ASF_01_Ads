package grupo1.view;

import javax.swing.*;
import org.apache.axis2.AxisFault;

import grupo1.controller.UsersEditController;
import grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException;
import grupo1.dao.AdvertisementEndpointSQLExceptionException;
import grupo1.dto.xsd.User;
import grupo1.pojo.UserPOJO;
import grupo1.view.base.AnunciusJFrame;
import grupo1.view.events.UserEditGUIEvents;

import java.awt.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.rmi.RemoteException;

@SuppressWarnings("serial")
public class UsersEditWindow extends AnunciusJFrame {
	
	@SuppressWarnings("unused")
	private JTextField textField;
	private int id;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtPassword;
	private JTextField txtDate;
	private AdminWindow adminWindow;
	private UsersEditController controller;
	private UserPOJO user;

    /**
     * Create the frame.
     */
    public UsersEditWindow() {
        init();
        populate();
    }
    
    public UsersEditWindow(AdminWindow adminWindow){
		this.adminWindow = adminWindow;
		init();
		populate();
    }

    private void populate() {
    	new Thread(new Runnable() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				try {
					controller = new UsersEditController();
				} catch (AxisFault e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        try {
					if(id > 0){
						user = controller.getUser(id);
						if(user!=null){
							txtEmail.setText(user.getEmail());
							txtId.setText(String.valueOf(user.getId()));
							txtName.setText(user.getName());
							txtPassword.setText(user.getPassword());
							txtDate.setText(user.getSignupDate().toGMTString());
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

	public UsersEditWindow(int id) {
    	this.id = id;
    	init();
    	populate();
	}
    
    public UsersEditWindow(int id, AdminWindow adminWindow) {
    	this.id = id;
    	this.adminWindow = adminWindow;
    	init();
    	populate();
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
        
        txtId = new JTextField();
        txtId.setEditable(false);
        txtId.setColumns(10);
        
        txtName = new JTextField();
        txtName.setColumns(10);
        
        txtEmail = new JTextField();
        txtEmail.setColumns(10);
        
        txtPassword = new JTextField();
        txtPassword.setColumns(10);
        
        txtDate = new JTextField();
        txtDate.setColumns(10);
        txtDate.setEditable(false);
        
        JButton btnSaveChanges = new JButton("Save changes");
        btnSaveChanges.addActionListener(UserEditGUIEvents.BUTTON_SAVE_CHANGES.event(this));
        
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(UserEditGUIEvents.BUTTON_CANCEL.event(this));
        configureLayout(
        		panelWindowContent,
        		lblAdvertisementId,
        		lblTitle, lblDescription, lblCreatedBy, lblPrice,
				btnSaveChanges, btnCancel);
        
      //set location to center of the screen
        setLocationRelativeTo(null);
        
        contentPane.setBorder(null);
        
        //set visible
        setVisible(true);
    }

	private void configureLayout(JPanel panelWindowContent, JLabel lblAdvertisementId, JLabel lblTitle,
			JLabel lblDescription, JLabel lblCreatedBy, JLabel lblPrice, JButton btnSaveChanges, JButton btnCancel) {
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
        						.addComponent(txtName, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
        						.addComponent(txtId, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
        						.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
        						.addComponent(txtPassword, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
        						.addComponent(txtDate, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)))
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
        				.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_panelWindowContent.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblTitle)
        				.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_panelWindowContent.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblDescription)
        				.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_panelWindowContent.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblCreatedBy)
        				.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_panelWindowContent.createParallelGroup(Alignment.TRAILING)
        				.addComponent(lblPrice)
        				.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(gl_panelWindowContent.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnSaveChanges)
        				.addComponent(btnCancel))
        			.addContainerGap(133, Short.MAX_VALUE))
        );
        panelWindowContent.setLayout(gl_panelWindowContent);
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
		if(id > 0){
			user.setName(txtName.getText());
			user.setEmail(txtEmail.getText());
			user.setPassword(txtPassword.getText());
			
			try {
				controller.updateUser(user);
			} catch (RemoteException | AdvertisementEndpointClassNotFoundExceptionException
					| AdvertisementEndpointSQLExceptionException e) {
				e.printStackTrace();
			}
		}
		else{
			User user = new User();
			user.setName(txtName.getText());
			user.setEmail(txtEmail.getText());
			user.setPassword(txtPassword.getText());
			try {
				controller.insertUser(user);
			} catch (RemoteException | AdvertisementEndpointClassNotFoundExceptionException
					| AdvertisementEndpointSQLExceptionException e) {
				JOptionPane.showMessageDialog(this, e.getLocalizedMessage(), "Error on "+e.getClass().getSimpleName(), JOptionPane.ERROR_MESSAGE);
			}
		}
		adminWindow.updateTables();
		this.dispose();
	}
}
