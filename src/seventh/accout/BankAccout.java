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
	// 判断是否为本行
	private boolean blank;
	private float balance;
	
	//透支额度
	private float overdraft;
	// 每日存款限额
	private float depositLimit;
	// 每日取款限额
	private float withdrawalsLimit;
	// 每日转账限额
	private float transferLimit;
	// 目标账号
	private long targetCard;

	//数据库操作对象
	private AccountDAO accountDAO;
	private AdminDAO adminDAO;
	private TradingrecDAO tradingrecDAO; 
	private UserDao userDao;
	private ConnectTable connectTable;
	
	// 设置单例模式
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

	
	//Getter、 Setter方法
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
