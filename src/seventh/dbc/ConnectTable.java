package seventh.dbc;

import java.util.List;

import seventh.accout.BlankAccout;
import seventh.dbc.AccountDAO;
import seventh.dbc.UserDao;
import org.junit.Test;
import seventh.dbc.DAO;
/**都TM是联表查询的方法
 * @author SAM
 *
 */
public class ConnectTable{
	@Test
	public String[] getUserMessage(long card){
		String[] userRecords = new String[5];
		String[] accountRecords = new String[2];
		String[] allRecords = new String[7];
		//获取id
		int id = BlankAccout.getInstance().getAccountDAO().getAccountId(card);
		//获取用户消息,用id查询
		userRecords = BlankAccout.getInstance().getUserDao().getUserMessageId(id);
		//获取账户状态和类型,用卡号查询
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
