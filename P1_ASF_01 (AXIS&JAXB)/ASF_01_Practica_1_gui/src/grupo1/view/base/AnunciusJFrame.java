package grupo1.view.base;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public abstract class AnunciusJFrame extends JFrame {

	protected JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public AnunciusJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		//set app icon
		setIconImage(Toolkit.getDefaultToolkit().getImage(AnunciusJFrame.class.getResource("/grupo1/res/ads.png")));
		//set system theme
        setSystemTheme();
	}
	
	protected void setSystemTheme() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            System.err.println(e.getLocalizedMessage());
        }
    }

}
