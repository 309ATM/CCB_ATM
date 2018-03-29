package jachin;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class TakeFrame {

	public JFrame frameTake;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		frameTake.setBounds(100, 100, 1095, 750);
		frameTake.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameTake.getContentPane().setLayout(null);

		JButton btnFlash = new JButton("");
		btnFlash.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\btnHuoQi.png"));
		btnFlash.setBounds(410, 250, 200, 80);
		frameTake.getContentPane().add(btnFlash);

		JButton btnStable = new JButton("");
		btnStable.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\btnDingQi.png"));
		btnStable.setBounds(420, 400, 200, 80);
		frameTake.getContentPane().add(btnStable);

		JButton btnTou = new JButton("");
		btnTou.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\btnTouZhi.png"));
		btnTou.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTou.setBounds(420, 550, 200, 80);
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

		JLabel lblBg2 = new JLabel("");
		lblBg2.setBounds(3, 0, 1086, 716);
		lblBg2.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\ATM_bg.png"));
		frameTake.getContentPane().add(lblBg2);

	}

	public void Back() {
		MainFrame.main(null);
		frameTake.dispose();
	}

}
