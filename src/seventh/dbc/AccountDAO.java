package seventh.dbc;
import org.junit.Test;
public class AccountDAO extends DAO<Account>{
	
	/**��֤��������ƥ��
	 * @param card
	 * @param pawd
	 * @return
	 */
	public boolean checkPawd(long card, long pawd){
		//�����˺����룬���ضԴ�
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
	
	/**�жϿ����Ƿ����
	 * @param card
	 * @return
	 */
	public boolean getCardExit(long card) {
		//���뿨�ţ����ضԴ�
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
	
	
	/**��ѯ��������
	 * @param Card
	 * @return
	 */
	public boolean getBanks(long card) {
		//���뿨�ţ����ضԴ�
		//long card
		//long card = 656885452136697452L;
		String sql = "select bank from account where cardnum = ?";
		//String n = getForValue(sql,card);
		String bank = getForValue(sql,card);
		//System.out.println(bank);	
		if(bank.equals("��������")){
			//System.out.println("true");
			return true;
		}else{
			//System.out.println("false");
			return false;
		}


	}
	
	/**��ѯ���ŵ�״̬
	 * @param Card
	 * @return
	 */
	public String getCardStatu(long card) {
		//���뿨�ţ�����״̬
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
	
	/**��ѯ���
	 * @param Card
	 * @return
	 */
	public float getCardBalance(long card) {
		//���뿨�ţ��������
		String sql = "select balance from account where cardnum = ?";
		float balance = getForValue(sql,card);
		//System.out.println(stat);
		return balance;

	}
	
	/**��ѯ͸֧���
	 * @param Card
	 * @return
	 */
	public float getCardOverdraft(long card) {
		//���뿨�ţ�����͸֧
		String sql = "select overdraft from account where cardnum = ?";
		float overdraft = getForValue(sql,card);
		return overdraft;
	}
	
	/**��ѯ���п�����
	 * @param Card
	 * @return
	 */
	public String getCardType(long card){
		//���뿨�ţ��������п�����
		String sql = "select accType from account where cardnum = ?";
		String accType = getForValue(sql,card);
		return accType;
	}
	
	/**�޸��˻����
	 * @param Card
	 * @param balance
	 * @return
	 */
	public boolean setCardBalance(long card,float balance) {
		//���뿨�ţ��޸����,�����޸ĳɹ�ʧ��
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
	/**�����˻���
	 * @param idCard(�����֤ȥ��ȡ�û�id)
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
	
	/**�޸��˻���Ϣ
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
		//oldCardnum��ԭ���ţ�Ѱ�Ҽ�¼��
		String sql = "update account set cardnum = ?,id = ?,passwd = ?,stat = ?,accType = ?,bank = ?,balance = ?,overdraft = ?,logintime = ? where cardnum = ?";
		update(sql,cardnum,id,passwd,stat,accType,bank,balance,overdraft,loginTime,oldCardnum);
		return true;		
	}
	
	/**�޸��˻�״̬
	 * @param card
	 * @param accType(�޸ĺ��״̬)
	 * @return
	 */
	public boolean updateAccountType(long card,String accType){
			String sql = "update account set accType = ? where cardnum = ?";
			update(sql,accType,card);
			return true;
	}
	
	/**�޸��˻�����
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
	
	/**�û����
	 * @param card
	 * @param balance(�����)
	 * @return
	 */
	public void saveBalance(long card,float Money){
		try{
			String sql = "update account set balance = balance+? where cardnum = ? ";
			update(sql,Money,card);
		}catch(Exception e){
			System.out.println("����");
		}
	}
	
	/**
	 * @param card
	 * @param balance(ȡ����)
	 */
	public void loadBalance(long card,float Money){
		try{
			String sql = "update account set balance = balance-? where cardnum = ?";
			update(sql,Money,card);
		}catch(Exception e){
			System.out.println("����");
		}
	}
	
	/**ת��
	 * @param card
	 * @param targetCard
	 * @param money(�Ѽ���������)
	 */
	public void transferAccount(long card,long targetCard,float money){
		String sql = "update account set balance = balance-? where card = ?";
		update(sql,money,card);
		String sql1 = "update account set balance = balance+? where card = ?";
		update(sql,money,targetCard);
	}
}
