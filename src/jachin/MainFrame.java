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
import javax.swing.UIManager;

public class MainFrame {

	public static String card;
	private JFrame frameMain;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.out.println("main"+card);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					MainFrame window = new MainFrame();
					window.frameMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameMain = new JFrame();
		frameMain.setTitle("\u5EFA\u8BBE\u94F6\u884CATM");
		frameMain.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\CCB.png"));
		frameMain.setResizable(false);
		frameMain.setBounds(360, 150, 1095, 750);
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMain.getContentPane().setLayout(null);
		

		JButton btnQu = new JButton("");
		btnQu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ToTake();
			}
		});
		btnQu.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\btn_qu.png"));
		btnQu.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		btnQu.setBounds(10, 250, 200, 80);
		frameMain.getContentPane().add(btnQu);

		JButton btnSave = new JButton("");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ToSave();
			}
		});
		btnSave.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\btn_save.png"));
		btnSave.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		btnSave.setBounds(10, 400, 200, 80);
		frameMain.getContentPane().add(btnSave);

		JButton btnZhuan = new JButton("");
		btnZhuan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ToTransfer();
			}
		});
		btnZhuan.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\btn_zhuan.png"));
		btnZhuan.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		btnZhuan.setBounds(10, 550, 200, 80);
		frameMain.getContentPane().add(btnZhuan);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ToQuery();
			}
		});
		button.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\btn_query.png"));
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		button.setBounds(875, 250, 200, 80);
		frameMain.getContentPane().add(button);

		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ToHistory();
			}
		});
		button_1.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\btn_history.png"));
		button_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		button_1.setBounds(875, 400, 200, 80);
		frameMain.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Exit();
			}
		});
		button_2.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\btnExit.png"));
		button_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		button_2.setBounds(875, 550, 200, 80);
		frameMain.getContentPane().add(button_2);
		
		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\ATM_bg.png"));
		lblBg.setBounds(3, 0, 1086, 715);
		frameMain.getContentPane().add(lblBg);
	}
	
	public void ToTake() {
		TakeFrame.main(null);
		frameMain.dispose();
	}

	public void ToSave() {
		SaveFrame.main(null);
		frameMain.dispose();
	}

	public void ToTransfer() {
		TransferFrame.main(null);
		frameMain.dispose();
	}

	public void ToQuery() {
		QueryFrame.main(null);
		frameMain.dispose();
	}
	
	public void ToHistory() {
		HistoryFrame.main(null);
		frameMain.dispose();
	}
	
	public void Exit(){
		LoginUI.main(null);
		frameMain.dispose();
	}
}
