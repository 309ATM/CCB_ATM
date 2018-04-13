package seventh.dbc;
import org.junit.Test;
public class AccountDAO extends DAO<Account>{
	
	/**验证卡号密码匹配
	 * @param card
	 * @param pawd
	 * @return
	 */
	public boolean checkPawd(long card, long pawd){
		//输入账号密码，返回对错
		//long card, long pawd
		//long card = 65688552136697452L; 
		//long pawd = 123456L;
		String sql = "select * from account where cardnum = ? and passwd = ?";
		//System.out.println(get(sql,card,pawd));
		if(get(sql,card,pawd) != null){
			//System.out.println("true");
			return true;
		}else{
			//System.out.println("false");
			return false;
		}
	}
	
	/**判断卡号是否存在
	 * @param card
	 * @return
	 */
	public boolean getCardExit(long card) {
		//输入卡号，返回对错
		//long card
		//long card = 656885452136697452L;
		String sql = "select * from account where cardnum = ?";
		//System.out.println(get(sql,card));
		if(get(sql,card) != null){
			//System.out.println("true");
			return true;
		}else{
			//System.out.println("false");
			return false;
		}
	}
	
	
	/**查询所属银行
	 * @param Card
	 * @return
	 */
	public boolean getBanks(long card) {
		//输入卡号，返回对错
		//long card
		//long card = 656885452136697452L;
		String sql = "select bank from account where cardnum = ?";
		//String n = getForValue(sql,card);
		String bank = getForValue(sql,card);
		//System.out.println(bank);	
		if(bank.equals("建设银行")){
			//System.out.println("true");
			return true;
		}else{
			//System.out.println("false");
			return false;
		}


	}
	
	/**查询卡号的状态
	 * @param Card
	 * @return
	 */
	public String getCardStatu(long card) {
		//输入卡号，返回状态
		//long card
		//long card = 656885452136697452L;
		String sql = "select stat from account where cardnum = ?";
		String stat = getForValue(sql,card);
		//System.out.println(stat);
		if(stat != null){
			return stat;
		}else{
			return null;
		}
	}
	
	/**查询余额
	 * @param Card
	 * @return
	 */
	public float getCardBalance(long card) {
		//输入卡号，返回余额
		String sql = "select balance from account where cardnum = ?";
		float balance = getForValue(sql,card);
		//System.out.println(stat);
		return balance;

	}
	
	/**查询透支额度
	 * @param Card
	 * @return
	 */
	public float getCardOverdraft(long card) {
		//输入卡号，返回透支
		String sql = "select overdraft from account where cardnum = ?";
		float overdraft = getForValue(sql,card);
		return overdraft;
	}
	
	/**查询银行卡类型
	 * @param Card
	 * @return
	 */
	public String getCardType(long card){
		//输入卡号，返回银行卡类型
		String sql = "select accType from account where cardnum = ?";
		String accType = getForValue(sql,card);
		return accType;
	}
	
	/**修改账户余额
	 * @param Card
	 * @param balance
	 * @return
	 */
	public boolean setCardBalance(long card,float balance) {
		//输入卡号，修改余额,返回修改成功失败
		//long card,float balance
		//long card = 656885452136697452L;
		//float balance = 100;
		try{
		String sql = "update account set balance = ? where cardnum = ?";
		update(sql,balance,card);
		return true;
		}catch(Exception e){
			return false;
		}
	}


//	private float balance;
//
//	private float overdraft;
//	
//	private int loginTime;
	/**插入账户表
	 * @param idCard(用身份证去获取用户id)
	 * @param cardnum
	 * @param passwd
	 * @param stat
	 * @param accType
	 * @param bank
	 * @param balance
	 * @param overdraft
	 * @param loginTime
	 * @return
	 */
	public boolean setAccount(String idCard,long cardnum,long passwd,String stat,String accType,String bank,float balance,float overdraft,int loginTime){
		String sql = "select id from users where idcard = ?";
		int id = getForValue(sql, idCard);
		String sql1 = "insert into account values(?,?,?,?,?,?,?,?,?)";
		update(sql1,cardnum,id,passwd,stat,accType,bank,balance,overdraft,loginTime);
		return true;
	}
	
	/**修改账户信息
	 * @param oldCardnum
	 * @param cardnum
	 * @param id
	 * @param passwd
	 * @param stat
	 * @param accType
	 * @param bank
	 * @param balance
	 * @param overdraft
	 * @param loginTime
	 * @return
	 */
	public boolean updateAccountAllMessage(long oldCardnum,long cardnum,int id,long passwd,String stat,String accType,String bank,float balance,float overdraft,int loginTime){
		//oldCardnum是原卡号，寻找记录的
		String sql = "update account set cardnum = ?,id = ?,passwd = ?,stat = ?,accType = ?,bank = ?,balance = ?,overdraft = ?,logintime = ? where cardnum = ?";
		update(sql,cardnum,id,passwd,stat,accType,bank,balance,overdraft,loginTime,oldCardnum);
		return true;		
	}
	
	/**修改账户状态
	 * @param card
	 * @param accType(修改后的状态)
	 * @return
	 */
	public boolean updateAccountType(long card,String accType){
			String sql = "update account set accType = ? where cardnum = ?";
			update(sql,accType,card);
			return true;
	}
	
	/**修改账户密码
	 * @param card
	 * @param newPasswd
	 * @param oldPasswd
	 * @return
	 */
	public boolean updatePasswd(long card,long newPasswd,long oldPasswd){
		String sql = "update account set passwd = ? where cardnum = ? and passwd = ?";
		update(sql,newPasswd,card,oldPasswd);
		return true;
	}
	
	/**用户存款
	 * @param card
	 * @param balance(存款数)
	 * @return
	 */
	public void saveBalance(long card,float Money){
		try{
			String sql = "update account set balance = balance+? where cardnum = ? ";
			update(sql,Money,card);
		}catch(Exception e){
			System.out.println("出错");
		}
	}
	
	/**
	 * @param card
	 * @param balance(取款数)
	 */
	public void loadBalance(long card,float Money){
		try{
			String sql = "update account set balance = balance-? where cardnum = ?";
			update(sql,Money,card);
		}catch(Exception e){
			System.out.println("出错");
		}
	}
	
	/**转账
	 * @param card
	 * @param targetCard
	 * @param money(已计算手续费)
	 */
	public void transferAccount(long card,long targetCard,float money){
		String sql = "update account set balance = balance-? where card = ?";
		update(sql,money,card);
		String sql1 = "update account set balance = balance+? where card = ?";
		update(sql,money,targetCard);
	}
}
