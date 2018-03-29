package jachin;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ATM {

	private JFrame frmatm;
	 private JPanel panelMain;
	 private JPanel panelTake;
	 private JPanel panelSave;
	 private JPanel panelTransfor;
	 private JPanel panelQuery;
	 private JPanel panelHistory;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					ATM window = new ATM();
					window.frmatm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ATM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmatm = new JFrame();
		frmatm.setTitle("\u5EFA\u8BBE\u94F6\u884CATM");
		frmatm.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\CCB.png"));
		frmatm.setResizable(false);
		frmatm.setBounds(100, 100, 1095, 750);
		frmatm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmatm.getContentPane().setLayout(null);

		panelMain = new JPanel();
		panelMain.setBounds(0, 0, 1089, 747);
		frmatm.getContentPane().add(panelMain);
		panelMain.setLayout(null);
		

		JButton btnQu = new JButton("");
		btnQu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ToTake();
			}
		});
		btnQu.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\btn_qu.png"));
		btnQu.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		btnQu.setBounds(10, 350, 200, 80);
		panelMain.add(btnQu);

		JButton btnSave = new JButton("");
		btnSave.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\btn_save.png"));
		btnSave.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		btnSave.setBounds(10, 500, 200, 80);
		panelMain.add(btnSave);

		JButton btnZhuan = new JButton("");
		btnZhuan.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\btn_zhuan.png"));
		btnZhuan.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		btnZhuan.setBounds(875, 250, 200, 80);
		panelMain.add(btnZhuan);

		JButton button = new JButton("");
		button.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\btn_query.png"));
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		button.setBounds(875, 400, 200, 80);
		panelMain.add(button);

		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\btn_history.png"));
		button_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		button_1.setBounds(875, 550, 200, 80);
		panelMain.add(button_1);
		
		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\ATM_bg.png"));
		lblBg.setBounds(3, 0, 1086, 715);
		panelMain.add(lblBg);

		
		panelTake = new JPanel();
		panelTake.setBounds(0, 0, 1089, 747);
		frmatm.getContentPane().add(panelTake);
		panelTake.setLayout(null);

		JButton btnFlash = new JButton("\u6D3B\u671F\u53D6\u6B3E");
		btnFlash.setBounds(423, 158, 200, 80);
		panelTake.add(btnFlash);
		
		JButton btnStable = new JButton("\u5B9A\u671F\u53D6\u6B3E");
		btnStable.setBounds(423, 279, 200, 80);
		panelTake.add(btnStable);
		
		JButton btnTou = new JButton("\u900F\u652F\u53D6\u6B3E");
		btnTou.setBounds(423, 393, 200, 80);
		panelTake.add(btnTou);
		
		JButton btnBack = new JButton("\u9000\u51FA");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Back(panelTake);
			}
		});
		btnBack.setBounds(55, 338, 113, 27);
		panelTake.add(btnBack);
		
		JLabel lblBg2 = new JLabel("");
		lblBg2.setBounds(3, 0, 1086, 716);
		lblBg2.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\ATM_bg.png"));
		panelTake.add(lblBg2);

		
	}

	public void ToTake() {
		panelMain.setVisible(false);
		panelTake.setVisible(true);
	}

	public void ToSave() {
		
	}

	public void ToTransfor() {

	}

	public void ToQuery() {

	}
	
	public void ToHistory() {

	}
	
	
	public void Back(JPanel temp){
		temp.setVisible(false);
		panelMain.setVisible(true);
	}
	

}
