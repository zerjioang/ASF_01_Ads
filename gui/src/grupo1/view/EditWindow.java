package grupo1.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import grupo1.view.base.AnunciusJFrame;
import grupo1.view.events.AdminGUIEvents;

import java.awt.*;
import javax.swing.GroupLayout.Alignment;

public class EditWindow extends AnunciusJFrame {
	
	private JTextField textField;

    /**
     * Create the frame.
     */
    public EditWindow() {

        //set system theme
        setSystemTheme();

        setTitle("Anuncius Admin | Edit");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setMinimumSize(new Dimension(400, 400));
        
        JPanel panelBannerWarning = new JPanel();
        panelBannerWarning.setBackground(Color.RED);
        getContentPane().add(panelBannerWarning, BorderLayout.NORTH);
        
        JLabel lblWarningYouAre = new JLabel("Warning: you are editing a user message");
        lblWarningYouAre.setBackground(Color.RED);
        lblWarningYouAre.setForeground(Color.WHITE);
        panelBannerWarning.add(lblWarningYouAre);
        
        JPanel panelWindowContent = new JPanel();
        getContentPane().add(panelWindowContent, BorderLayout.CENTER);
        GroupLayout gl_panelWindowContent = new GroupLayout(panelWindowContent);
        gl_panelWindowContent.setHorizontalGroup(
        	gl_panelWindowContent.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 432, Short.MAX_VALUE)
        );
        gl_panelWindowContent.setVerticalGroup(
        	gl_panelWindowContent.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 327, Short.MAX_VALUE)
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
            	EditWindow frame = new EditWindow();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
