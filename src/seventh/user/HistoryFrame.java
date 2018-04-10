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
 * ��ѯ��ʷ��¼
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

		ATMButton button_1 = new ATMButton("<html>�˳�<br>Exit</html>");
		button_1.addActionListener(new Back());
		button_1.setBounds(919, 550, 156, 70);
		frameHistory.getContentPane().add(button_1);

		final String[] columnNames = { "����", "��������", "���׽��", "Ŀ���˻�", "������" };
		String[][] rowData = { { "03/24/1985", "ת��", "1200", "62218858000005086", "0" },
				{ "xx/xx/1985", "ת��", "1300", "62218858000005086", "0" },
				{ "12/08/1985", "ת��", "100", "62218858000005086", "1" },
				{ "xx/xx/1986", "ת��", "200", "62218858000005086", "2" },
				{ "xx/xx/1985", "ת��", "400", "62218858000005086", "4" } };

		JLabel label = new JLabel("\u4EA4\u6613\u8BB0\u5F55:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("��Բ", Font.BOLD, 24));
		label.setBounds(171, 179, 150, 44);
		frameHistory.getContentPane().add(label);
		
		JPanel panel = new JPanel();
		panel.setBounds(217, 252, 689, 365);
		frameHistory.getContentPane().add(panel);
		table = new JTable(rowData, columnNames);
		table.setRowHeight(0, 20);// ���õ�1�еĸ߶�Ϊ15
		table.setPreferredScrollableViewportSize(new Dimension(600, 100));// ���ñ��Ĵ�С
		table.setRowHeight(30);// ����ÿ�еĸ߶�Ϊ20
		table.setRowHeight(0, 30);// ���õ�1�еĸ߶�Ϊ15
		table.setRowMargin(5);// �����������е�Ԫ��ľ���
		table.setRowSelectionAllowed(true);// ���ÿɷ�ѡ��.Ĭ��Ϊfalse
		table.setSelectionBackground(Color.white);// ������ѡ���еı���ɫ
		table.setSelectionForeground(Color.red);// ������ѡ���е�ǰ��ɫ
		table.setGridColor(Color.black);// ���������ߵ���ɫ
		table.selectAll();// ѡ��������
		table.setRowSelectionInterval(0, 2);// ���ó�ʼ��ѡ����,������1��3�ж�����ѡ��״̬
		table.clearSelection();// ȡ��ѡ��
		table.setDragEnabled(false);// �������
		table.setShowGrid(false);// �Ƿ���ʾ������
		table.setShowHorizontalLines(false);// �Ƿ���ʾˮƽ��������
		table.setShowVerticalLines(true);// �Ƿ���ʾ��ֱ��������
		table.setValueAt("tt", 0, 0);// ����ĳ����Ԫ���ֵ,���ֵ��һ������
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
