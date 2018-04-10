package seventh.user;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

<<<<<<< HEAD
=======
/**
 * 查询历史记录
 *
 */
>>>>>>> Jachin
public class HistoryFrame {

	private JFrame frameHistory;
	private JTable table;
<<<<<<< HEAD
=======
	private String File = "E:\\Code\\java\\CCB_ATM";
	// private String File = ".";
>>>>>>> Jachin

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

	public JFrame getFrameHistory() {
		return frameHistory;
	}

	public HistoryFrame() {
		initialize();
	}

	private void initialize() {
		frameHistory = new JFrame();
		frameHistory.setTitle("\u5EFA\u8BBE\u94F6\u884CATM");
		frameHistory.setIconImage(
<<<<<<< HEAD
				Toolkit.getDefaultToolkit().getImage("E:\\Code\\java\\Eclipse-ATM\\CCB_ATM\\img\\CCB.png"));
=======
				Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
>>>>>>> Jachin
		frameHistory.setResizable(false);
		frameHistory.setBounds(360, 150, 1095, 750);
		frameHistory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameHistory.getContentPane().setLayout(null);

		ATMButton button_1 = new ATMButton("<html>退出<br>Exit</html>");
		button_1.addActionListener(new Back());
		button_1.setBounds(919, 550, 156, 70);
		frameHistory.getContentPane().add(button_1);

		final String[] columnNames = { "日期", "交易类型", "交易金额", "目标账户", "手续费" };
		String[][] rowData = { { "03/24/1985", "转账", "1200", "62218858000005086", "0" },
				{ "xx/xx/1985", "转账", "1300", "62218858000005086", "0" },
				{ "12/08/1985", "转账", "100", "62218858000005086", "1" },
				{ "xx/xx/1986", "转账", "200", "62218858000005086", "2" },
				{ "xx/xx/1985", "转账", "400", "62218858000005086", "4" } };

		JLabel label = new JLabel("\u4EA4\u6613\u8BB0\u5F55:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("幼圆", Font.BOLD, 24));
		label.setBounds(171, 179, 150, 44);
		frameHistory.getContentPane().add(label);
		
		JPanel panel = new JPanel();
		panel.setBounds(217, 252, 689, 365);
		frameHistory.getContentPane().add(panel);
		table = new JTable(rowData, columnNames);
		table.setRowHeight(0, 20);// 设置第1行的高度为15
		table.setPreferredScrollableViewportSize(new Dimension(600, 100));// 设置表格的大小
		table.setRowHeight(30);// 设置每行的高度为20
		table.setRowHeight(0, 30);// 设置第1行的高度为15
		table.setRowMargin(5);// 设置相邻两行单元格的距离
		table.setRowSelectionAllowed(true);// 设置可否被选择.默认为false
		table.setSelectionBackground(Color.white);// 设置所选择行的背景色
		table.setSelectionForeground(Color.red);// 设置所选择行的前景色
		table.setGridColor(Color.black);// 设置网格线的颜色
		table.selectAll();// 选择所有行
		table.setRowSelectionInterval(0, 2);// 设置初始的选择行,这里是1到3行都处于选择状态
		table.clearSelection();// 取消选择
		table.setDragEnabled(false);// 不懂这个
		table.setShowGrid(false);// 是否显示网格线
		table.setShowHorizontalLines(false);// 是否显示水平的网格线
		table.setShowVerticalLines(true);// 是否显示垂直的网格线
		table.setValueAt("tt", 0, 0);// 设置某个单元格的值,这个值是一个对象
		table.doLayout();
		panel.setLayout(null);
		table.setBackground(Color.lightGray);
		
				JScrollPane JSP = new JScrollPane(table);
				JSP.setBounds(0, 0, 689, 365);
				panel.add(JSP);
				

				table.setBounds(171, 236, 700, 700);
		
		JLabel lblBg = new JLabel("");
<<<<<<< HEAD
		lblBg.setIcon(new ImageIcon("E:\\Code\\java\\CCB_ATM\\img\\ATM_bg.png"));
=======
		lblBg.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
>>>>>>> Jachin
		lblBg.setBounds(3, 0, 1086, 715);
		frameHistory.getContentPane().add(lblBg);
		
	}

	class Back implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.frameMain.setVisible(true);
			frameHistory.dispose();

		}
	}
}
