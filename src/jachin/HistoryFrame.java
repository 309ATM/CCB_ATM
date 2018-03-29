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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HistoryFrame {

	private JFrame frameHistory;
	private JTable table;

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
				Toolkit.getDefaultToolkit().getImage("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\CCB.png"));
		frameHistory.setResizable(false);
		frameHistory.setBounds(100, 100, 1095, 750);
		frameHistory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameHistory.getContentPane().setLayout(null);

		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Back();
			}
		});
		button_1.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\btnExit.png"));
		button_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		button_1.setBounds(875, 550, 200, 80);
		frameHistory.getContentPane().add(button_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, ""},
				{null, null, null, null, ""},
			},
			new String[] {
				"\u64CD\u4F5C\u4EBA\u59D3\u540D", "\u64CD\u4F5C\u4EBA\u5361\u53F7", "\u4EA4\u6613\u7C7B\u578B", "\u4EA4\u6613\u65E5\u671F", "\u63A5\u6536\u65B9\u5361\u53F7"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(93);
		table.getColumnModel().getColumn(1).setPreferredWidth(92);
		table.getColumnModel().getColumn(3).setPreferredWidth(106);
		table.getColumnModel().getColumn(4).setPreferredWidth(98);
		table.setBounds(153, 237, 686, 391);
		frameHistory.getContentPane().add(table);

		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\ATM_bg.png"));
		lblBg.setBounds(3, 0, 1086, 715);
		frameHistory.getContentPane().add(lblBg);
	}
	
	public void Back(){
		MainFrame.main(null);
		frameHistory.dispose();
	}
}
