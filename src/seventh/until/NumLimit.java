package seventh.until;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/** �����ı���ֻ����������
 * @author Jachin
 *
 */
public class NumLimit implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		int keyChar = e.getKeyChar();
		if (keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9) {
		} else {
			e.consume(); // �ؼ������ε��Ƿ�����
		}
	}

}
