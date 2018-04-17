package seventh.dbc;

import java.util.List;

import seventh.accout.BlankAccout;
import seventh.dbc.AccountDAO;
import seventh.dbc.UserDao;
import org.junit.Test;
import seventh.dbc.DAO;
/**��TM�������ѯ�ķ���
 * @author SAM
 *
 */
public class ConnectTable{
	@Test
	public String[] getUserMessage(long card){
		String[] userRecords = new String[5];
		String[] accountRecords = new String[2];
		String[] allRecords = new String[7];
		//��ȡid
		int id = BlankAccout.getInstance().getAccountDAO().getAccountId(card);
		//��ȡ�û���Ϣ,��id��ѯ
		userRecords = BlankAccout.getInstance().getUserDao().getUserMessageId(id);
		//��ȡ�˻�״̬������,�ÿ��Ų�ѯ
		accountRecords = BlankAccout.getInstance().getAccountDAO().getAccountTypeStatus(card);
		
		allRecords[0] = userRecords[0];
		allRecords[2] = userRecords[1];
		allRecords[4] = userRecords[2];
		allRecords[5] = userRecords[3];
		allRecords[6] = userRecords[4];
		allRecords[1] = accountRecords[0];
		allRecords[3] = accountRecords[1];
		
		return allRecords;
	
	}
}
