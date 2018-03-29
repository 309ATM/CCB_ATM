package jachin;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SaveFrame {

	private JFrame frameSave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaveFrame window = new SaveFrame();
					window.frameSave.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SaveFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameSave = new JFrame();
		frameSave.setTitle("\u5EFA\u8BBE\u94F6\u884CATM");
		frameSave.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\CCB.png"));
		frameSave.setResizable(false);
		frameSave.setBounds(100, 100, 1095, 750);
		frameSave.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSave.getContentPane().setLayout(null);
		
		
		JButton btnZhuan = new JButton("");
		btnZhuan.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\btnHuoQi.png"));
		btnZhuan.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		btnZhuan.setBounds(400, 250, 200, 80);
		frameSave.getContentPane().add(btnZhuan);

		JButton button = new JButton("");
		button.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\btnDingQi.png"));
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		button.setBounds(400, 400, 200, 80);
		frameSave.getContentPane().add(button);

		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Back();
			}
		});
		button_1.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\btnExit.png"));
		button_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		button_1.setBounds(875, 550, 200, 80);
		frameSave.getContentPane().add(button_1);
		
		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\ATM_bg.png"));
		lblBg.setBounds(3, 0, 1086, 715);
		frameSave.getContentPane().add(lblBg);
	}
	
	public void Back() {
		MainFrame.main(null);
		frameSave.dispose();
	}

}
