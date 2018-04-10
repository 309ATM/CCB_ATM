package seventh.dbc;



import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.List;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.junit.Test;


import util.HibernateUtils;

public class account {
	private long cardnum;
	private int id;
	private long passwd;
	private String stat;
	private String accType;
	private String bank;
	private float balance;
	private float overdraft;
	

	public long getCardnum() {
		return cardnum;
	}
	public void setCardnum(long cardnum) {
		this.cardnum = cardnum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getPasswd() {
		return passwd;
	}
	public void setPasswd(long passwd) {
		this.passwd = passwd;
	}
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	public float getOverdraft() {
		return overdraft;
	}
	public void setOverdraft(float overdraft) {
		this.overdraft = overdraft;
	}
	
	
	@Override
	public String toString() {
		return "account [cardnum=" + cardnum + ", id=" + id + ", passwd=" + passwd + ", stat=" + stat + ", accType="
				+ accType + ", bank=" + bank + ", balance=" + balance + ", overdraft=" + overdraft + "]";
	}
	
	
	public boolean checkPawd(long card,long pawd){
		//验证卡号密码匹配
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		//String card = "656885452136697452";
		//long pawd = 123456L;
		String stcard = String.valueOf(card);
		String stpasswd = String.valueOf(pawd);
		String hql = "from account a where cardnum = ? and passwd = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, stcard);
		query.setParameter(1, stpasswd);
		java.util.List<account> list = query.list();
		for(account a : list){
			System.out.println(a.getCardnum()+":"+a.getPasswd());
		}
		
		if(list != null){
			return true;
		}else{
			return false;
		}
		
	}
	
	public Boolean cardExit(long card){
		//判断卡号是否存在
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		long CARD = 0;
		String hql = "from accunt where cardnum = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, card);
		java.util.List<account> list = query.list();
		for(account a : list){
			System.out.println(a.getCardnum());
			CARD = a.getCardnum();
			System.out.println(a.getCardnum());
		}
		
		if(CARD == card){
			return true;
		}else{
			return false;
		}
		
	}
	
	public boolean banks(long Card){
		//判断所属银行
	    //String Card = "656885452136697452";
				 String stcard = String.valueOf(Card);
				 Session session = HibernateUtils.getCurrentSession();
				 Transaction tr = session.beginTransaction();
				 String BANK = "";
				 String hql = "from account a where cardnum = ?";
				 Query query = session.createQuery(hql);
				 query.setParameter(0, stcard);
				 java.util.List<account> list = query.list();
				 for(account a : list){
					BANK = a.getBank();
					System.out.println(BANK);
				 }
				 System.out.println(BANK);
				 if(BANK.equals("建设银行")){
					 return false;
					 //System.out.println("true");
					 }
				 else{
					 return true;
					 //System.out.println("false");
					 }
	    
		//System.out.print(query);
		
		//return bank;
	}
	
//	private long cardnum;
//	private int id;
//	private long passwd;
//	private String stat;
//	private String accType;
//	private String bank;
//	private float balance;
//	private float overdraft;
	//插入数据
	public boolean inserMess(long CARDNUM,int ID,long PASSWD,String STAT,String ACCTYPE,String BANK,float BALANCE,float OVERDRAFT){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		account a = new account();
		a.setCardnum(CARDNUM);
		a.setId(ID);
		a.setPasswd(PASSWD);
		a.setStat(STAT);
		a.setAccType(ACCTYPE);
		a.setBank(BANK);
		a.setBalance(BALANCE);
		a.setOverdraft(OVERDRAFT);
		session.save(a);
		tr.commit();
		return true;
	}
	
	//设置用户状态为"销户"
	@Test
	public boolean setcloseAc(long CARDNUM){
		//long CARDNUM = 656885452136697452L;
		String sr = String.valueOf(CARDNUM);
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//account a = (account)session.get(account.class,CARDNUM);
		String hql = "update account a set a.stat = ? where a.cardnum = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, "销户");
		query.setParameter(1, sr);
		int n = query.executeUpdate();
		tr.commit();
		
		if(n != 0){
			return true;
		}else{
			return false;
		}
		
		
		
	}
}
