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
	public void getBanks(long card) {
		//���뿨�ţ����ضԴ�
		//long card
		//long card = 656885452136697452L;
		String sql = "select bank from account where cardnum = ?";
		//String n = getForValue(sql,card);
		String bank = getForValue(sql,card);
		//System.out.println(bank);	
		if(bank.equals("��������")){
			System.out.println("true");
			//return true;
		}else{
			System.out.println("false");
			//return false;
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
		return stat;
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

	/**�����˻���
	 * @param cardnum
	 * @param id
	 * @param passwd
	 * @param stat
	 * @param accType
	 * @param bank
	 */
	public boolean setAccountMess(long cardnum,int id,long passwd,String stat,String accType,String bank){
		String sql = "insert into account values(?,?,?,?,?,?)";
		update(sql,cardnum,id,passwd,stat,accType,bank);
		return true;
	}
}
