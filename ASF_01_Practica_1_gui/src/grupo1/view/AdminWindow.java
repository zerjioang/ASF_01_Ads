package grupo1.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.JAXBException;

import org.apache.axis2.AxisFault;

import grupo1.controller.AdminController;
import grupo1.controller.AdsEditController;
import grupo1.controller.CategoriesEditController;
import grupo1.controller.UsersEditController;
import grupo1.dao.AdvertisementEndpointClassNotFoundExceptionException;
import grupo1.dao.AdvertisementEndpointSQLExceptionException;
import grupo1.pojo.AdvertisementPOJO;
import grupo1.pojo.CategoryPOJO;
import grupo1.pojo.UserPOJO;
import grupo1.view.base.AnunciusJFrame;
import grupo1.view.events.AdminGUIEvents;
import grupo1.view.events.AdsEditGUIEvents;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AdminWindow extends AnunciusJFrame {
	
	private static final int ID_COLUMN_POSITION = 0;
	private JTextField textField;
	private JTable tableAdsList;
	private AdminController controller;
	private JTable tableCategoryList;
	private JTable tableUserList;
	
	/**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
            	AdminWindow frame = new AdminWindow();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    private AdminWindow() {
        setTitle("Anuncius Admin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setMinimumSize(new Dimension(800, 400));

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);

        JMenuItem mntmBackupData = new JMenuItem("Backup data");
        mntmBackupData.addActionListener(AdminGUIEvents.MENU_BACKUP.event(this));
        mnFile.add(mntmBackupData);
        
        JMenuItem mntmExit = new JMenuItem("Exit");
        mntmExit.addActionListener(AdminGUIEvents.MENU_EXIT.event(this));
        mnFile.add(mntmExit);

        JMenu mnSettings = new JMenu("Settings");
        menuBar.add(mnSettings);

        JMenuItem mntSettings = new JMenuItem("Anuncius settings");
        mntSettings.addActionListener(AdminGUIEvents.MENU_CONFIGURE.event(this));
        mnSettings.add(mntSettings);
        
        JMenuItem mntmRestoreFromBackup = new JMenuItem("Restore from backup");
        mntmRestoreFromBackup.addActionListener(AdminGUIEvents.MENU_RESTORE.event(this));
        mnSettings.add(mntmRestoreFromBackup);

        JMenu mnHelp = new JMenu("Help");
        menuBar.add(mnHelp);

        JMenuItem mntmAbout = new JMenuItem("About");
        mntmAbout.addActionListener(AdminGUIEvents.MENU_ABOUT.event(this));
        mnHelp.add(mntmAbout);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panelCentre = new JPanel();
        contentPane.add(panelCentre, BorderLayout.CENTER);
        panelCentre.setLayout(new BorderLayout(0, 0));

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        panelCentre.add(tabbedPane);

        JPanel panel = new JPanel();
        tabbedPane.addTab("Search", null, panel, null);
        panel.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane_1 = new JScrollPane();
        panel.add(scrollPane_1, BorderLayout.CENTER);

        tableAdsList = new JTable();
        tableAdsList.setShowVerticalLines(false);
        tableAdsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableAdsList.setAutoCreateRowSorter(true);
        
        scrollPane_1.setViewportView(tableAdsList);
        
        JPanel panelNorthSearch = new JPanel();
        panelNorthSearch.setBorder(new EmptyBorder(4, 4, 4, 4));
        panel.add(panelNorthSearch, BorderLayout.NORTH);
        panelNorthSearch.setLayout(new BorderLayout(0, 0));
        
        JLabel lblSearchQuery = new JLabel("Search query ");
        panelNorthSearch.add(lblSearchQuery, BorderLayout.WEST);
        
        JPanel panel_2 = new JPanel();
        panelNorthSearch.add(panel_2, BorderLayout.CENTER);
        panel_2.setLayout(new BorderLayout(0, 0));
        
        textField = new JTextField();
        textField.addActionListener(AdminGUIEvents.QUERY_ENTER.event(this));
        panel_2.add(textField);
        textField.setColumns(10);
        
        JPanel panel_1 = new JPanel();
        tabbedPane.addTab("Administration", null, panel_1, null);
        
        JScrollPane scrollPane = new JScrollPane();
        
        JScrollPane scrollPane_2 = new JScrollPane();
        
        JLabel lblCategoryList = new JLabel("Category list");
        
        JLabel lblUserList = new JLabel("User list");
        
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
        	gl_panel_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(lblCategoryList)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addComponent(lblUserList, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap(381, Short.MAX_VALUE))
        				.addComponent(scrollPane)))
        );
        gl_panel_1.setVerticalGroup(
        	gl_panel_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblCategoryList)
        				.addComponent(lblUserList))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(scrollPane, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
        				.addComponent(scrollPane_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)))
        );
        
        tableUserList = new JTable();
        
        scrollPane.setViewportView(tableUserList);
        
        tableCategoryList = new JTable();
        scrollPane_2.setViewportView(tableCategoryList);
        panel_1.setLayout(gl_panel_1);

        JPanel panelBottom = new JPanel();
        contentPane.add(panelBottom, BorderLayout.SOUTH);

        JLabel lblVersion = new JLabel("Version 1.0-alpha");
        panelBottom.add(lblVersion);
        
        //add popup menus
        
        JPopupMenu popUpMenu = createPopUpMenuAds();
        
        tableAdsList.setComponentPopupMenu(popUpMenu);
        
        JPopupMenu popUpMenu1 = createPopUpCategories();
        
        tableCategoryList.setComponentPopupMenu(popUpMenu1);	
        
        JPopupMenu popUpMenu2 = createPopUpUsers();
        
        tableUserList.setComponentPopupMenu(popUpMenu2);
        
        //set location to center of the screen
        setLocationRelativeTo(null);
        
        //load window data
        initController();
    }
    
    private JPopupMenu createPopUpMenuAds() {
    	
    	JPopupMenu popUpMenu = new JPopupMenu();
        JMenuItem editItem = new JMenuItem("New");
        editItem.addActionListener(AdminGUIEvents.NEW_ADVERTISEMENT.event(this));
        popUpMenu.add(editItem);
        
        JMenuItem editItem1 = new JMenuItem("Edit");
        editItem1.addActionListener(AdminGUIEvents.EDIT_ADVERTISEMENT.event(this));
        popUpMenu.add(editItem1);	
        
        JMenuItem editItem2 = new JMenuItem("Delete");
        editItem2.addActionListener(AdminGUIEvents.DELETE_ADVERTISEMENT.event(this));
        popUpMenu.add(editItem2);	
        
        return popUpMenu;
    }
    
	private JPopupMenu createPopUpCategories() {
	    	
    	JPopupMenu popUpMenu = new JPopupMenu();
        JMenuItem editItem = new JMenuItem("New");
        editItem.addActionListener(AdminGUIEvents.NEW_CATEGORY.event(this));
        popUpMenu.add(editItem);
        
        JMenuItem editItem1 = new JMenuItem("Edit");
        editItem1.addActionListener(AdminGUIEvents.EDIT_CATEGORY.event(this));
        popUpMenu.add(editItem1);	
        
        JMenuItem editItem2 = new JMenuItem("Delete");
        editItem2.addActionListener(AdminGUIEvents.DELETE_CATEGORY.event(this));
        popUpMenu.add(editItem2);	
        
        return popUpMenu;
    }

	private JPopupMenu createPopUpUsers() {
	
		JPopupMenu popUpMenu = new JPopupMenu();
	    JMenuItem editItem = new JMenuItem("New");
	    editItem.addActionListener(AdminGUIEvents.NEW_USER.event(this));
	    popUpMenu.add(editItem);
	    
	    JMenuItem editItem1 = new JMenuItem("Edit");
	    editItem1.addActionListener(AdminGUIEvents.EDIT_USER.event(this));
	    popUpMenu.add(editItem1);	
	    
	    JMenuItem editItem2 = new JMenuItem("Delete");
	    editItem2.addActionListener(AdminGUIEvents.DELETE_USER.event(this));
	    popUpMenu.add(editItem2);	
	    
	    return popUpMenu;
	}

	private void initController(){
		System.out.println("Loading window data...");
		new Thread(new Runnable() {
			public void run() {
				try {
					controller = new AdminController();
					updateTables();
				} catch (AxisFault e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
    
    //eventos de la interfaz

	public void configureAnuncius() {
		JOptionPane.showMessageDialog(this, "Configuration is not currently available in this version.");
	}

	public void openMenuAbout() {
		JOptionPane.showMessageDialog(this, "Anuncius administration GUI");
	}

	public void openMenuExit() {	
		this.dispose();
	}

	public void queryEnterEvent() {
		try {
			tableAdsList.setModel(controller.searchAds(textField.getText()));
		} catch (RemoteException | AdvertisementEndpointClassNotFoundExceptionException
				| AdvertisementEndpointSQLExceptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void editAdvertisement() {
		int id = getSelectedTableElementId(tableAdsList);
		AdsEditWindow editWindow = new AdsEditWindow(id, this);
		editWindow.setVisible(true);
	}
	
	public void openMenuBackup() {
		try {
			controller.backupData();
			JOptionPane.showMessageDialog(this, "Backup created successfully. Check 'files' folder to view the data.");
		} catch (JAXBException | IOException | AdvertisementEndpointClassNotFoundExceptionException
				| AdvertisementEndpointSQLExceptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Error occurred while saving data.");
		}
	}

	public void editCategory() {
		int id = getSelectedTableElementId(tableCategoryList);
		CategoriesEditWindow editWindow = new CategoriesEditWindow(id, this);
		editWindow.setVisible(true);
	}

	public void editUser() {
		int id = getSelectedTableElementId(tableUserList);
		UsersEditWindow editWindow = new UsersEditWindow(id, this);
		editWindow.setVisible(true);
	}
	
	//metodos auxiliares

	private int getSelectedTableElementId(JTable table) {
		int row = table.getSelectedRow();
		System.out.println(row);
		return  (int) table.getModel().getValueAt(row, ID_COLUMN_POSITION);
	}

	public void updateTables() {
		try {
			tableAdsList.setModel(controller.getAllAdsInTable());
			tableCategoryList.setModel(controller.getAllCategoriesInTable());
			tableUserList.setModel(controller.getAllUsersInTable());
		} catch (RemoteException | AdvertisementEndpointClassNotFoundExceptionException
				| AdvertisementEndpointSQLExceptionException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "An error occurred while loading system data");
		}
	}

	public void newAdvertisement() {
		AdsEditWindow editWindow = new AdsEditWindow();
		editWindow.setVisible(true);
	}

	public void deleteAdvertisement() {
		int id = getSelectedTableElementId(tableAdsList);
		//TODO borrar el elemento del sistema
		AdsEditController controller;
		try {
			controller = new AdsEditController();
			controller.deleteAds(new AdvertisementPOJO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void newUser() {
		UsersEditWindow editWindow = new UsersEditWindow();
		editWindow.setVisible(true);
	}

	public void deleteUser() {
		int id = getSelectedTableElementId(tableUserList);
		//TODO borrar el elemento del sistema
		UsersEditController controller;
		try {
			controller = new UsersEditController();
			controller.deleteUser(new UserPOJO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public void newCategory() {
		CategoriesEditWindow editWindow = new CategoriesEditWindow();
		editWindow.setVisible(true);
	}

	public void deleteCategory() {
		int id = getSelectedTableElementId(tableCategoryList);
		//TODO borrar el elemento del sistema
		CategoriesEditController controller;
		try {
			controller = new CategoriesEditController();
			controller.deleteCategory(new CategoryPOJO());
		} catch (RemoteException | AdvertisementEndpointClassNotFoundExceptionException | AdvertisementEndpointSQLExceptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void menuRestore() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					controller.restoreData();
				} catch (JAXBException | IOException | AdvertisementEndpointClassNotFoundExceptionException
						| AdvertisementEndpointSQLExceptionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(getWindow(), "An error occurred while loading system data");
				}
			}
		}).start();
	}
	
	public AdminWindow getWindow(){
		return this;
	}
}
