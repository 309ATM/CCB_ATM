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

	/**
	 * 验证卡号密码匹配
	 * 
	 * @param card
	 * @param pawd
	 * @return
	 */
	@Test
	public boolean checkPawd(long card, long pawd) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();

		// Long型转String型，用于setParameter
		String stcard = String.valueOf(card);
		String stpawd = String.valueOf(pawd);
		String hql = "from account a where cardnum = ? and passwd = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, stcard);
		query.setParameter(1, stpawd);
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
	 * 判断卡号是否存在
	 * 
	 * @param card
	 * @return
	 */
	public static boolean cardExit(long card) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		// 如果卡号不存在则为 0
		long CARD = 0;
		String stcard = String.valueOf(card);
		String hql = "from accunt where cardnum = ?";
		Query<account> query = session.createQuery(hql);
		query.setParameter(0, stcard);

		java.util.List<account> list = query.list();
		for (account a : list) {
			CARD = a.getCardnum();
		}
		// 如果卡号不存在则为空，返回 true，否则返回 false
		if (card == CARD) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 返回所属银行
	 * 
	 * @param Card
	 * @return
	 */
	public static String banks(long Card) {

		// String Card = "656885452136697452";
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		String BANK = "";
		String stCard = String.valueOf(Card);
		String hql = "from account a where cardnum = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, stCard);
		java.util.List<account> list = query.list();
		for (account a : list) {
			BANK = a.getBank();
		}
		return BANK;
	}

}
