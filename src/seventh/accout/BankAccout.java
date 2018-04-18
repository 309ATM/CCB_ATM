package seventh.accout;

import seventh.dbc.AccountDAO;
import seventh.dbc.AdminDAO;
import seventh.dbc.TradingrecDAO;
import seventh.dbc.UserDao;
import seventh.dbc.ConnectTable;

public class BankAccout {
	private long cardNum;
	private String status;
	private String accountType;
	// �ж��Ƿ�Ϊ����
	private boolean blank;
	private float balance;
	
	//͸֧���
	private float overdraft;
	// ÿ�մ���޶�
	private float depositLimit;
	// ÿ��ȡ���޶�
	private float withdrawalsLimit;
	// ÿ��ת���޶�
	private float transferLimit;
	// Ŀ���˺�
	private long targetCard;

	//���ݿ��������
	private AccountDAO accountDAO;
	private AdminDAO adminDAO;
	private TradingrecDAO tradingrecDAO; 
	private UserDao userDao;
	private ConnectTable connectTable;
	
	// ���õ���ģʽ
	private BankAccout() {
		accountDAO = new AccountDAO();
		adminDAO = new AdminDAO();
		tradingrecDAO = new TradingrecDAO();
		userDao = new UserDao();
		connectTable = new ConnectTable(); 
	}

	private static class LazyHolder {
		private static final BankAccout INSTANCE = new BankAccout();
	}
	
	public static final BankAccout getInstance() {
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

	public boolean getBlank() {
		return blank;
	}

	public void setBlank(boolean blank) {
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

	public float getTransferLimit() {
		return transferLimit;
	}


	public void setTransferLimit(float transferLimit) {
		this.transferLimit = transferLimit;
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

	public TradingrecDAO getTradingrecDAO() {
		return tradingrecDAO;
	}

	public UserDao getUserDao() {
		return userDao;
	}


	public ConnectTable getConnectTable() {
		return connectTable;
	}


}
