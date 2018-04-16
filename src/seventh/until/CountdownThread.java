package seventh.until;

import javax.swing.JFrame;
import javax.swing.JLabel;

import seventh.user.UsersLogin;

/**
 * ���е���ʱ���̣߳��� 60s �ڲ����в������ͻ����ؿ�ʼ����
 */
public class CountdownThread extends Thread {
	private JFrame frame;
	private JLabel label;

	public void setCom(JFrame frame, JLabel label) {
		this.frame = frame;
		this.label = label;
	}

	private boolean runFlag = true;
	// TODO ���õ���ʱʱ��
	private int time = 60;

	public void run() {
		runFlag = true;
		while (runFlag) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (runFlag) { // TODO �������Ҫ�߳�ִ�е��¼�
				time--;
				label.setText(time + "");
			}
			// ���ʱ��ľ���������ô��ڣ��ص�������
			if (time <= 0) {
				stopThread();
				frame.dispose();
				// TODO �޸�Ϊ ATM ����
				UsersLogin.main(null);
			}
		}
	}

	// ��ֹ�߳�
	public void stopThread() {
		runFlag = false;
	}

}
