package seventh.dbc;

/**
 * 交易记录类
 * @author blue
 *
 */
public class Tradingrec {
	private int tradeNum;
	private long cardNum;
	private String tradeDate;
	private float tradeMoney;
	private String tradeType;
	private long tradeTarget;
	private float fee;
	
	public int getTradeNum() {
		return tradeNum;
	}
	public void setTradeNum(int tradeNum) {
		this.tradeNum = tradeNum;
	}
	public long getCardNum() {
		return cardNum;
	}
	public void setCardNum(long cardnum) {
		this.cardNum = cardnum;
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
	public long getTradeTarget() {
		return tradeTarget;
	}
	public void setTradeTarget(long tradeTarget) {
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
		return "tradingrec [tradeNum=" + tradeNum + ", cardnum=" + cardNum + ", tradeDate=" + tradeDate
				+ ", tradeMoney=" + tradeMoney + ", tradeType=" + tradeType + ", tradeTarget=" + tradeTarget + ", fee="
				+ fee + "]";
	}
}
