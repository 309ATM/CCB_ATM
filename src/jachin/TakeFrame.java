package jachin;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class TakeFrame {

	public JFrame frameTake;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.out.println("Take"+MainFrame.card);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					TakeFrame window = new TakeFrame();
					window.frameTake.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TakeFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameTake = new JFrame();
		frameTake.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\CCB.png"));
		frameTake.setTitle("中国建设银行ATM");
		frameTake.setResizable(false);
		frameTake.setBounds(360, 150, 1095, 750);
		frameTake.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameTake.getContentPane().setLayout(null);

		JButton btnFlash = new JButton("");
		btnFlash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				withdrawal("100");
			}
		});
		btnFlash.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\btn_100.png"));
		btnFlash.setBounds(14, 250, 200, 80);
		frameTake.getContentPane().add(btnFlash);

		JButton btnStable = new JButton("");
		btnStable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdrawal("300");
			}
		});
		btnStable.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\btn_300.png"));
		btnStable.setBounds(14, 402, 200, 80);
		frameTake.getContentPane().add(btnStable);

		JButton btnTou = new JButton("");
		btnTou.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\btn_500.png"));
		btnTou.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdrawal("500");
			}
		});
		btnTou.setBounds(14, 550, 200, 80);
		frameTake.getContentPane().add(btnTou);

		JButton btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\btnExit.png"));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Back();
			}
		});
		btnBack.setBounds(875, 550, 200, 80);
		frameTake.getContentPane().add(btnBack);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdrawal("1000");
			}
		});
		button.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\btn_1000.png"));
		button.setBounds(875, 250, 200, 80);
		frameTake.getContentPane().add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdrawal("2000");
			}
		});
		button_1.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\btn_2000.png"));
		button_1.setBounds(875, 402, 200, 80);
		frameTake.getContentPane().add(button_1);

		JLabel lblBg2 = new JLabel("");
		lblBg2.setBounds(3, 0, 1086, 716);
		lblBg2.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\ATM_bg.png"));
		frameTake.getContentPane().add(lblBg2);

	}
	
	public void withdrawal(String money){
		JOptionPane.showMessageDialog(null, "取款"+money, "提示", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void Back() {
		MainFrame.main(null);
		frameTake.dispose();
	}

}
