package jachin;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HistoryFrame {

	private JFrame frameHistory;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistoryFrame window = new HistoryFrame();
					window.frameHistory.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HistoryFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameHistory = new JFrame();
		frameHistory.setTitle("\u5EFA\u8BBE\u94F6\u884CATM");
		frameHistory.setIconImage(
				Toolkit.getDefaultToolkit().getImage(".\\img\\CCB.png"));
		frameHistory.setResizable(false);
		frameHistory.setBounds(360, 150, 1095, 750);
		frameHistory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameHistory.setLayout(null);

		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Back();
			}
		});
		button_1.setIcon(new ImageIcon(".\\img\\btnExit.png"));
		button_1.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		button_1.setBounds(875, 550, 200, 80);
		frameHistory.add(button_1);
		
		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(".\\img\\ATM_bg.png"));
		lblBg.setBounds(3, 0, 1086, 715);
		frameHistory.add(lblBg);
	}
	
	public void Back(){
		MainFrame.main(null);
		frameHistory.dispose();
	}
}
