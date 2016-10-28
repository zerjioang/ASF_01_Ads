package grupo1.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import grupo1.view.base.AnunciusJFrame;
import grupo1.view.events.AdminGUIEvents;
import grupo1.view.events.EditGUIEvents;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminWindow extends AnunciusJFrame {
	
	private static final int ID_COLUMN_POSITION = 0;
	private JTextField textField;
	private JTable tableAnuncios;

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

        JMenuItem mntmExit = new JMenuItem("Exit");
        mntmExit.addActionListener(AdminGUIEvents.MENU_EXIT.event(this));
        mnFile.add(mntmExit);

        JMenu mnSettings = new JMenu("Settings");
        menuBar.add(mnSettings);

        JMenuItem mntmConfigurarTracker = new JMenuItem("Anuncius settings");
        mntmConfigurarTracker.addActionListener(AdminGUIEvents.MENU_CONFIGURE.event(this));
        mnSettings.add(mntmConfigurarTracker);

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

        tableAnuncios = new JTable();
        tableAnuncios.setShowVerticalLines(false);
        tableAnuncios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableAnuncios.setAutoCreateRowSorter(true);
        tableAnuncios.setModel(new DefaultTableModel(
        	new Object[][] {
        		{0, "Title", "Description", "Username", 5.5},
        		{1, "Title", "Description", "Username", 10.0},
        	},
        	new String[] {
        		"ID", "Title", "Description", "Username", "Price"
        	}
        ));
        JPopupMenu popUpMenu = new JPopupMenu();
        JMenuItem editItem = new JMenuItem("Editar");
        editItem.addActionListener(AdminGUIEvents.EDIT_ADVERTISEMENT.event(this));
        popUpMenu.add(editItem);	
        
        tableAnuncios.setComponentPopupMenu(popUpMenu);
        scrollPane_1.setViewportView(tableAnuncios);
        
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
        tabbedPane.addTab("Advanced settings", null, panel_1, null);
        panel_1.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        panel_1.add(scrollPane, BorderLayout.CENTER);

        JTable table_1 = new JTable();
        scrollPane.setViewportView(table_1);

        JPanel panelBottom = new JPanel();
        contentPane.add(panelBottom, BorderLayout.SOUTH);

        JLabel lblVersion = new JLabel("Version 1.0-alpha");
        panelBottom.add(lblVersion);
        
        //set location to center of the screen
        setLocationRelativeTo(null);
    }

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
    
    //eventos de la interfaz

	public void configureAnuncius() {		
	}

	public void openMenuAbout() {		
	}

	public void openMenuExit() {		
	}

	public void queryEnterEvent() {		
	}

	public void editAdvertisement() {
		int id = getSelectedTableElementId();
		EditWindow editWindow = new EditWindow(id);
		editWindow.setVisible(true);
	}
	
	//metodos auxiliares
	
	private int getSelectedTableElementId() {
		int row = tableAnuncios.getSelectedRow();
		System.out.println(row);
		return  (int) tableAnuncios.getModel().getValueAt(row, ID_COLUMN_POSITION);
	}
}