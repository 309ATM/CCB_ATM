package seventh.user;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import seventh.accout.BlankAccout;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.awt.event.ItemEvent;

/**
 * 查询历史记录
 *
 */
public class HistoryFrame {

	private JFrame frameHistory;
	private JTable table;
	private String File = "E:\\Code\\java\\CCB_ATM";
	// private String File = ".";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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
		//WriteData();
	}

	private void initialize() {
		frameHistory = new JFrame();
		frameHistory.setTitle("\u5EFA\u8BBE\u94F6\u884CATM");
		frameHistory.setIconImage(Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
		frameHistory.setResizable(false);
		frameHistory.setBounds(360, 150, 1095, 750);
		frameHistory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameHistory.getContentPane().setLayout(null);

		ATMButton button_1 = new ATMButton("<html>退出<br>Exit</html>");
		button_1.setForeground(Color.RED);
		button_1.addActionListener(new Back());
		button_1.setBounds(919, 590, 156, 70);
		frameHistory.getContentPane().add(button_1);

		JLabel label = new JLabel("交易记录:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("幼圆", Font.BOLD, 24));
		label.setBounds(63, 155, 150, 44);
		frameHistory.getContentPane().add(label);

		JLabel lblSelectTime = new JLabel("Select Time");
		lblSelectTime.setForeground(Color.WHITE);
		lblSelectTime.setFont(new Font("幼圆", Font.BOLD, 24));
		lblSelectTime.setBounds(729, 155, 150, 44);
		frameHistory.getContentPane().add(lblSelectTime);

		String[] s = { "1个月", "3个月", "6个月" };
		JComboBox comboBox = new JComboBox(s);
		comboBox.addItemListener(new SelectTime());
		comboBox.setFont(new Font("幼圆", Font.PLAIN, 18));
		comboBox.setBounds(925, 164, 102, 27);
		frameHistory.getContentPane().add(comboBox);

		JPanel panel = new JPanel();
		panel.setBounds(73, 212, 954, 365);
		frameHistory.getContentPane().add(panel);

		table = new JTable();
		// 设置表格的格式
		table.setRowHeight(50); // 设置行高
		table.getTableHeader().setFont(new Font("幼圆", Font.BOLD, 20)); // 设置表头字体
		table.setFont(new Font("幼圆", Font.BOLD, 20)); // 设置表格字体
		table.setRowMargin(5);// 设置相邻两行单元格的距离
		table.setRowSelectionAllowed(true);// 设置可否被选择.默认为false
		table.setSelectionBackground(Color.white);// 设置所选择行的背景色
		table.setSelectionForeground(new Color(135, 136, 250));// 设置所选择行的前景色
		table.setGridColor(Color.black);// 设置网格线的颜色
		table.setDragEnabled(false);// 不懂这个
		table.setShowGrid(false);// 是否显示网格线
		table.setShowHorizontalLines(true);// 是否显示水平的网格线
		table.setShowVerticalLines(true);// 是否显示垂直的网格线
		table.getTableHeader().setResizingAllowed(false);// 设置表格不可整列移动
		table.getTableHeader().setReorderingAllowed(false);// 设置表格列宽不可改

		table.doLayout();
		panel.setLayout(null);
		table.setBackground(SystemColor.control);

		JScrollPane JSP = new JScrollPane(table);
		JSP.setBounds(0, 0, 954, 365);
		panel.add(JSP);
		table.setBounds(171, 236, 700, 700);

		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(File + "\\img\\ATM_bg.png"));
		lblBg.setBounds(3, 0, 1086, 715);
		frameHistory.getContentPane().add(lblBg);
	}

	public void WriteData(int month) {
		final String[] columnNames = { "日期", "交易类型", "交易金额", "目标账户", "手续费" };
		
		if(month==1){
			//调用数据库方法获取记录
			//function(BlankAccout.getInstance().getCardNum(),getDate(1));
		}
		if(month==3){
			//调用数据库方法获取记录
			//function(BlankAccout.getInstance().getCardNum(),getDate(3));
		}
		if(month==6){
			//调用数据库方法获取记录
			//function(BlankAccout.getInstance().getCardNum(),getDate(6));
		}
		//这部分数据从数据库里获取
		String[][] rowData = { { "2018.04.01 08:09:56", "转账", "￥1200", "62218858000005086", "￥0.00" },
				{ "2018.04.01 14:04:38", "转账", "￥13000", "62218858000005086", "￥0.00" },
				{ "2018.04.04 15:50:21", "转账", "￥100", "62218858000005086", "￥1.00" },
				{ "2018.04.08 11:34:23", "转账", "￥200", "62218858000005086", "￥2.00" },
				{ "2018.04.10 09:56:12", "透支取款", "￥400", "62218858000005086", "￥4.00" },
				{ "2018.04.10 09:56:12", "透支取款", "￥400", "62218858000005086", "￥4.00" },
				{ "2018.04.10 09:56:12", "透支取款", "￥400", "62218858000005086", "￥4.00" },
				{ "2018.04.10 09:56:12", "透支取款", "￥400", "62218858000005086", "￥4.00" },
				{ "2018.04.10 09:56:12", "透支取款", "￥400", "62218858000005086", "￥4.00" },
				{ "2018.04.10 09:56:12", "透支取款", "￥400", "62218858000005086", "￥4.00" } };
		
		
		table.setModel(new DefaultTableModel(rowData, columnNames));
		// 设置文字居中
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		render.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumn("日期").setCellRenderer(render);
		table.getColumn("交易类型").setCellRenderer(render);
		table.getColumn("交易金额").setCellRenderer(render);
		table.getColumn("目标账户").setCellRenderer(render);
		table.getColumn("手续费").setCellRenderer(render);
		// 设置列宽
		table.getColumnModel().getColumn(0).setPreferredWidth(180);
		table.getColumnModel().getColumn(1).setPreferredWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(20);
		table.getColumnModel().getColumn(3).setPreferredWidth(180);
		table.getColumnModel().getColumn(4).setPreferredWidth(20);
	}

	class SelectTime implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO 自动生成的方法存根
			if (e.getItem().equals("1个月"))
				WriteData(1);
			else if (e.getItem().equals("3个月"))
				WriteData(3);
			else if (e.getItem().equals("6个月"))
				WriteData(6);

		}

	}

	public String[] getDate(int month){
		Date dNow = new Date();   //当前时间
		Date dBefore = new Date();
		Calendar calendar = Calendar.getInstance(); //得到日历
		calendar.setTime(dNow);//把当前时间赋给日历
		calendar.add(calendar.MONTH, -month);  //设置为前month月
		dBefore = calendar.getTime();   //得到前3月的时间
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); // HH:mm:ss"); //设置时间格式
		String[] date = {sdf.format(dBefore),sdf.format(dNow)};
		return date;
	}
	
	class Back implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.frameMain.setVisible(true);
			frameHistory.dispose();

		}
	}
}
