package seventh.dbc;

//import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.List;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.junit.Test;

import seventh.dbc.HibernateUtils;

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
	
	private static Session session;
	private static Transaction tr;

	/**
	 * ��֤��������ƥ��
	 * 
	 * @param card
	 * @param pawd
	 * @return
	 */
	@Test
	public static boolean checkPawd(long card, long pawd) {
		session = HibernateUtils.getCurrentSession();
		tr = session.beginTransaction();

		// Long��תString�ͣ�����setParameter
		//String stcard = String.valueOf(card);
		//String stpawd = String.valueOf(pawd);
		String hql = "from account a where cardnum = ?0 and passwd = ?1";
		Query query = session.createQuery(hql);
		query.setParameter("0", card);
		query.setParameter("1", pawd);
		java.util.List<account> list = query.list();
		// for(account a : list){
		// System.out.println(a.getCardnum()+":"+a.getPasswd());
		// }
		//
		if (list != null) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * �жϿ����Ƿ����
	 * 
	 * @param card
	 * @return
	 */
	public static boolean cardExit(Long card) {
		session = HibernateUtils.getCurrentSession();
		tr = session.beginTransaction();
		// ��ѯ������ų�ʼ��Ϊ0
		long CARD = 0;
//		String stcard = String.valueOf(card);
		String hql = "from account where cardnum = ?0";
		Query<account> query = session.createQuery(hql);
		query.setParameter("0", card);

		java.util.List<account> list = query.list();
		for (account a : list) {
			CARD = a.getCardnum();
		}
		// �жϿ����Ƿ���ڣ����Ŵ�����Ϊ���� true�����򷵻� false
		if (CARD == card ) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * ������������
	 * 
	 * @param Card
	 * @return
	 */
	public static boolean banks(long Card) {

		// String Card = "656885452136697452";
		session = HibernateUtils.getCurrentSession();
		tr = session.beginTransaction();
		String BANK = "";
		//String stCard = String.valueOf(Card);
		String hql = "from account a where cardnum = ?0";
		Query query = session.createQuery(hql);
		query.setParameter("0", Card);
		java.util.List<account> list = query.list();
		for (account a : list) {
			BANK = a.getBank();
		}
		if(BANK.equals("��������"))
			return true;
		else
			return false;
	}

}
