package seventh.dbc;

import java.util.List;
import seventh.dbc.AccountDAO;
import seventh.dbc.UserDao;
import org.junit.Test;
import seventh.dbc.DAO;
/**都TM是联表查询的方法
 * @author SAM
 *
 */
public class connectTable{
	@Test
	public void getUserMessage(){
		long card = 656885452136697452L;
		String idCard = "440682199812125634";
		UserDao user = new UserDao();
		AccountDAO account = new AccountDAO();
		
		user.getUserInformation(idCard);
		
		
	}
	
}
