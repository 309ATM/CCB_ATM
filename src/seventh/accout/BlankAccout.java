package seventh.accout;

import seventh.dbc.AccountDAO;
import seventh.dbc.AdminDAO;

public class BlankAccout {
	private long cardNum;
	private String status;
	private String accountType;
	private String blank;
	private float balance;
	
	//͸֧���
	private float overdraft;
	// ÿ�մ���޶�
	private float depositLimit;
	// ÿ��ȡ���޶�
	private float withdrawalsLimit;
	// Ŀ���˺�
	private long targetCard;

	//���ݿ����
	private AccountDAO accountDAO;
	private AdminDAO adminDAO;
	
	
	// ���õ���ģʽ
	private BlankAccout() {
		accountDAO = new AccountDAO();
	}

	private static class LazyHolder {
		private static final BlankAccout INSTANCE = new BlankAccout();
	}
	
	public static final BlankAccout getInstance() {
		return LazyHolder.INSTANCE;
	}

	
	//Getter�� Setter����
	public long getTargetCard() {
		return targetCard;
	}
	
	public void setTargetCard(long targetCard) {
		this.targetCard = targetCard;
	}
	public float getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(float overdraft) {
		this.overdraft = overdraft;
	}

	public long getCardNum() {
		return cardNum;
	}

	public void setCardNum(long cardNum) {
		this.cardNum = cardNum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String statu) {
		this.status = statu;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBlank() {
		return blank;
	}

	public void setBlank(String blank) {
		this.blank = blank;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
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
	
	public AccountDAO getAccountDAO() {
		return accountDAO;
	}


	public AdminDAO getAdminDAO() {
		return adminDAO;
	}


	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

}
