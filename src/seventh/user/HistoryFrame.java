package seventh.user;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import seventh.accout.BankAccout;
import seventh.until.ATMButton;
import seventh.until.CountdownThread;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.awt.event.ItemEvent;

/**
 * ATM��ѯ������ʷ��¼����
 *
 */
public class HistoryFrame {

	private JFrame frameHistory;
	private JTable table;
	// private String File = "E:\\Code\\java\\CCB_ATM";
	private String File = ".";

	// �����̱߳���
	private JLabel countdownLabel;
	private CountdownThread time;

	// ��ʼ����ʱ
	public void startCountdown() {
		time = new CountdownThread();
		time.setCom(frameHistory, countdownLabel);
		time.start();
	}

	// ֹͣ����ʱ
	public void stopCountdown() {
		time.stopThread();
		time = null;
	}

	
	/**
	 * ������
	 */
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

	/**
	 * ��ʼ��Ӧ�ý���
	 */
	public HistoryFrame() {
		initialize();
		WriteData(1);
	}

	/**
	 * ��ӿؼ�
	 */
	private void initialize() {
		frameHistory = new JFrame();
		frameHistory.setTitle("\u5EFA\u8BBE\u94F6\u884CATM");
		frameHistory.setIconImage(Toolkit.getDefaultToolkit().getImage(File + "\\img\\CCB.png"));
		frameHistory.setResizable(false);
		frameHistory.setBounds(360, 150, 1095, 750);
		frameHistory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameHistory.getContentPane().setLayout(null);

		countdownLabel = new JLabel("");
		countdownLabel.setForeground(Color.RED);
		countdownLabel.setFont(new Font("����", Font.BOLD, 40));
		countdownLabel.setBounds(1020, 61, 55, 53);
		frameHistory.getContentPane().add(countdownLabel);

		ATMButton button_1 = new ATMButton("<html>�˳�<br>Exit</html>");
		button_1.setForeground(Color.RED);
		button_1.addActionListener(new Back());
		button_1.setBounds(919, 590, 156, 70);
		frameHistory.getContentPane().add(button_1);

		JLabel label = new JLabel("���׼�¼:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("��Բ", Font.BOLD, 24));
		label.setBounds(63, 155, 150, 44);
		frameHistory.getContentPane().add(label);

		JLabel lblSelectTime = new JLabel("Select Time");
		lblSelectTime.setForeground(Color.WHITE);
		lblSelectTime.setFont(new Font("��Բ", Font.BOLD, 24));
		lblSelectTime.setBounds(729, 155, 150, 44);
		frameHistory.getContentPane().add(lblSelectTime);

		String[] s = { "1����", "3����", "6����" };
		@SuppressWarnings("unchecked")
		JComboBox comboBox = new JComboBox(s);
		comboBox.addItemListener(new SelectTime());
		comboBox.setFont(new Font("��Բ", Font.PLAIN, 18));
		comboBox.setBounds(925, 164, 102, 27);
		frameHistory.getContentPane().add(comboBox);

		JPanel panel = new JPanel();
		panel.setBounds(73, 212, 954, 365);
		frameHistory.getContentPane().add(panel);

		table = new JTable();
		// ���ñ��ĸ�ʽ
		table.setRowHeight(50); // �����и�
		table.getTableHeader().setFont(new Font("��Բ", Font.BOLD, 18)); // ���ñ�ͷ����
		table.setFont(new Font("��Բ", Font.BOLD, 18)); // ���ñ������

		table.setRowMargin(5);// �����������е�Ԫ��ľ���
		table.setRowSelectionAllowed(true);// ���ÿɷ�ѡ��.Ĭ��Ϊfalse
		table.setSelectionBackground(Color.white);// ������ѡ���еı���ɫ
		table.setSelectionForeground(new Color(135, 136, 250));// ������ѡ���е�ǰ��ɫ
		table.setGridColor(Color.black);// ���������ߵ���ɫ
		table.setDragEnabled(false);// �������
		table.setShowGrid(false);// �Ƿ���ʾ������
		table.setShowHorizontalLines(true);// �Ƿ���ʾˮƽ��������
		table.setShowVerticalLines(true);// �Ƿ���ʾ��ֱ��������
		table.getTableHeader().setResizingAllowed(false);// ���ñ�񲻿������ƶ�
		table.getTableHeader().setReorderingAllowed(false);// ���ñ���п��ɸ�

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

	/** ���û���ѯ�Ľ�����ʷ��¼��Ϣ��д����ά���
	 * @param month �û�ѡ���ѯmonth�����ڵĽ�����ʷ��¼
	 */
	public void WriteData(int month) {
		final String[] columnNames = { "�˻�", "����", "���׽��", "��������", "Ŀ���˻�", "������" };
		if (month == 1) {
			// �������ݿⷽ����ȡ��¼
			String[][] rowData = BankAccout.getInstance().getTradingrecDAO()
					.getSpecifiedRecording(BankAccout.getInstance().getCardNum(), getDate(1));
			table.setModel(new DefaultTableModel(rowData, columnNames));
		}
		if (month == 3) {
			// �������ݿⷽ����ȡ��¼
			String[][] rowData = BankAccout.getInstance().getTradingrecDAO()
					.getSpecifiedRecording(BankAccout.getInstance().getCardNum(), getDate(3));
			table.setModel(new DefaultTableModel(rowData, columnNames));
		}
		if (month == 6) {
			// �������ݿⷽ����ȡ��¼
			String[][] rowData = BankAccout.getInstance().getTradingrecDAO()
					.getSpecifiedRecording(BankAccout.getInstance().getCardNum(), getDate(6));
			table.setModel(new DefaultTableModel(rowData, columnNames));
		}
		// �������־���
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		render.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumn("�˻�").setCellRenderer(render);
		table.getColumn("����").setCellRenderer(render);
		table.getColumn("��������").setCellRenderer(render);
		table.getColumn("���׽��").setCellRenderer(render);
		table.getColumn("Ŀ���˻�").setCellRenderer(render);
		table.getColumn("������").setCellRenderer(render);
		// �����п�
		table.getColumnModel().getColumn(0).setPreferredWidth(180);
		table.getColumnModel().getColumn(1).setPreferredWidth(180);
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(40);
		table.getColumnModel().getColumn(4).setPreferredWidth(180);
		table.getColumnModel().getColumn(5).setPreferredWidth(20);
	}

	/** �ж��û�ѡ��鿴��һ��ʱ���ڵĽ�����ʷ��¼
	 * @author Jachin
	 *
	 */
	class SelectTime implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getItem().equals("1����"))
				WriteData(1);
			else if (e.getItem().equals("3����"))
				WriteData(3);
			else if (e.getItem().equals("6����"))
				WriteData(6);
		}

	}

	/** ��ȡ�û�ѡ��ʱ�������һ������
	 * @param month ��ѯmonth�����ڵļ�¼
	 * @return String[] date = {month����ǰ�Ľ�������ڣ����������}
	 */
	public String[] getDate(int month) {
		Date dNow = new Date(); // ��ǰʱ��
		Date dBefore = new Date();
		Calendar calendar = Calendar.getInstance(); // �õ�����
		dNow = calendar.getTime();
		calendar.setTime(dNow);// �ѵ�ǰʱ�丳������
		calendar.add(calendar.MONTH, -month); // ����Ϊǰmonth��
		dBefore = calendar.getTime(); // �õ�ǰ3�µ�ʱ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // HH:mm:ss");
																	// //����ʱ���ʽ
		String[] date = { sdf.format(dBefore), sdf.format(dNow) };
		return date;
	}

	/** �˳���ť�¼�������
	 * @author Jachin
	 *
	 */
	class Back implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.frameMain.setVisible(true);

			// ��ʼ�����浹��ʱ
			MainFrame.startCountdown();
			// ֹͣ��ǰ����ʱ
			stopCountdown();

			frameHistory.dispose();

		}
	}
}
