package seventh.dbc;

//import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.List;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.junit.Test;


import seventh.dbc.ibernateUtils;

public class account {
	private long cardnum;
	private int id;
	private long passwd;
	private String stat;
	private String accType;
	private String bank;
	private float balance;
	private float overdraft;
	private float depositLimit;
	private float withdrawalsLimit;
	

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
	
	public float getDepositLimit() {
		return depositLimit;
	}
	public void setDepositLimit(float depositLimit) {
		this.depositLimit = depositLimit;
	}
	public float getWithdrawalsLimit() {
		return withdrawalsLimit;
	}
	public void setWithdrawalsLimit(float withdrawalsLimit) {
		this.withdrawalsLimit = withdrawalsLimit;
	}
	
	
	
	@Override
	public String toString() {
		return "account [cardnum=" + cardnum + ", id=" + id + ", passwd=" + passwd + ", stat=" + stat + ", accType="
				+ accType + ", bank=" + bank + ", balance=" + balance + ", overdraft=" + overdraft + ", depositLimit="
				+ depositLimit + ", withdrawalsLimit=" + withdrawalsLimit + "]";
	}
	@Test
	public boolean checkPawd(long card,long pawd){
		//验证卡号密码匹配
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		//String card = "656885452136697452";
		//long pawd = 123456L;
		String hql = "from account a where cardnum = ? and passwd = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, card);
		query.setParameter(1, pawd);
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
				 Session session = HibernateUtils.getCurrentSession();
				 Transaction tr = session.beginTransaction();
				 String BANK = "";
				 String hql = "from account a where cardnum = ?";
				 Query query = session.createQuery(hql);
				 query.setParameter(0, Card);
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
	
}
