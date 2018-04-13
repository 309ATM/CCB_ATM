package seventh.dbc;

public class Account {
	private long cardnum;

	private int id;

	private long passwd;

	private String stat;

	private String accType;

	private String bank;

	private float balance;

	private float overdraft;
	
	private int loginTime;

	
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

	
	public int getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(int loginTime) {
		this.loginTime = loginTime;
	}

	public void setOverdraft(float overdraft) {
		this.overdraft = overdraft;
	}

	@Override
	public String toString() {
		return "Account [cardnum=" + cardnum + ", id=" + id + ", passwd=" + passwd + ", stat=" + stat + ", accType="
				+ accType + ", bank=" + bank + ", balance=" + balance + ", overdraft=" + overdraft + ", loginTime="
				+ loginTime + "]";
	}

	
}
