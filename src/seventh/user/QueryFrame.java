package seventh.user;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;

/**
 * ²éÑ¯Óà¶î
 *
 */
public class QueryFrame {

	private JFrame frameQuery;
	private String File = "E:\\Code\\java\\CCB_ATM";
	// private String File = ".";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryFrame window = new QueryFrame();
					window.frameQuery.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public JFrame getFrameQuery() {
		return frameQuery;
	}
	/**
	 * Create the application.
	 */
	public QueryFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameQuery = new JFrame();
		frameQuery.setTitle("\u5EFA\u8BBE\u94F6\u884CATM");
<<<<<<< HEAD:src/seventh/user/QueryFrame.java
		frameQuery.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Code\\java\\CCB_ATM\\img\\CCB.png"));
=======
		frameQuery.setIconImage(Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
>>>>>>> Jachin:src/seventh/user/QueryFrame.java
		frameQuery.setResizable(false);
		frameQuery.setBounds(360, 150, 1095, 750);
		frameQuery.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameQuery.getContentPane().setLayout(null);

		ATMButton button_1 = new ATMButton("<html><center>ÍË³ö<br>Confirm</center></html>");
		button_1.addActionListener(new Back());
		button_1.setBounds(875, 550, 200, 80);
		frameQuery.getContentPane().add(button_1);

		JLabel label = new JLabel("ÄúµÄÓà¶îÐÅÏ¢£º");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Ó×Ô²", Font.BOLD, 24));
		label.setBounds(421, 246, 157, 40);
		frameQuery.getContentPane().add(label);

		JLabel lblBg = new JLabel("");
<<<<<<< HEAD:src/seventh/user/QueryFrame.java
		lblBg.setIcon(new ImageIcon("E:\\Code\\java\\CCB_ATM\\img\\ATM_bg.png"));
=======
		lblBg.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
>>>>>>> Jachin:src/seventh/user/QueryFrame.java
		lblBg.setBounds(3, 0, 1086, 715);
		frameQuery.getContentPane().add(lblBg);
	}

	class Back implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.frameMain.setVisible(true);
			frameQuery.dispose();
		}
	}

	
}
