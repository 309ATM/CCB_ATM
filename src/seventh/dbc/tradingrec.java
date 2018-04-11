package seventh.dbc;

import org.hibernate.Session;
import org.hibernate.Transaction;
public class tradingrec {
	private int tradeNum;
	private int cardnum;
	private String tradeDate;
	private float tradeMoney;
	private String tradeType;
	private int tradeTarget;
	private float fee;
	
	public int getTradeNum() {
		return tradeNum;
	}
	public void setTradeNum(int tradeNum) {
		this.tradeNum = tradeNum;
	}
	public int getCardnum() {
		return cardnum;
	}
	public void setCardnum(int cardnum) {
		this.cardnum = cardnum;
	}
	public String getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}
	public float getTradeMoney() {
		return tradeMoney;
	}
	public void setTradeMoney(float tradeMoney) {
		this.tradeMoney = tradeMoney;
	}
	public String getTradeType() {
		return tradeType;
	}
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}
	public int getTradeTarget() {
		return tradeTarget;
	}
	public void setTradeTarget(int tradeTarget) {
		this.tradeTarget = tradeTarget;
	}
	public float getFee() {
		return fee;
	}
	public void setFee(float fee) {
		this.fee = fee;
	}
	
	@Override
	public String toString() {
		return "tradingrec [tradeNum=" + tradeNum + ", cardnum=" + cardnum + ", tradeDate=" + tradeDate
				+ ", tradeMoney=" + tradeMoney + ", tradeType=" + tradeType + ", tradeTarget=" + tradeTarget + ", fee="
				+ fee + "]";
	}
	
	public void inserMess(int cardnum,String tradeDate,float tradeMoney,String tradeType,int tradeTarget,float fee){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		tradingrec tra = new tradingrec();
		tra.setCardnum(cardnum);
		tra.setTradeDate(tradeDate);
		tra.setTradeMoney(tradeMoney);
		tra.setTradeType(tradeType);
		tra.setTradeTarget(tradeTarget);
		tra.setFee(fee);
	}
	
	public void deleteMess(){
		
	}
}
