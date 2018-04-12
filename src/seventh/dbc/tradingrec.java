package seventh.dbc;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
/** 
 * 交易记录
 *
 */
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
	
	public static boolean inserMess(int cardnum,String tradeDate,float tradeMoney,String tradeType,int tradeTarget,float fee){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		tradingrec tra = new tradingrec();
		tra.setCardnum(cardnum);
		tra.setTradeDate(tradeDate);
		tra.setTradeMoney(tradeMoney);
		tra.setTradeType(tradeType);
		tra.setTradeTarget(tradeTarget);
		tra.setFee(fee);
		tr.commit();
		return true;
	}
	
	//删除信息
	public void deleteMess(){
		
	}
	
	//获取存款限额
	public float getdepositLimit(long card,String tradedate){
		//连接数据库
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//查找交易信息
		float depositLimit = 40000;
		float a[] = new float[10];
		int i =0;
		String hql = "select tradeMoney from tradingrec where cardnum = ? "
				+ "and tradeData = ? and tradeType = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, card);
		query.setParameter(1, tradedate);
		query.setParameter(2, "存款");
		
		java.util.List<tradingrec> list = query.list();
		//保存存款交易的数额
		for(tradingrec tra : list){
			a[i] = tra.getTradeMoney();
			i+=1;
		}
		for(int j = 0;j <= i;j++){
			depositLimit -= a[j];
		}
		return depositLimit;
		
	}
	
	//获取取款限额
	public float getwithdrawalsLimit(long card,String tradedate){
		//连接数据库
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//查找交易信息
		float depositLimit = 20000;
		float a[] = new float[10];
		int i =0;
		String hql = "select tradeMoney from tradingrec where cardnum = ? "
				+ "and tradeData = ? and tradeType = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, card);
		query.setParameter(1, tradedate);
		query.setParameter(2, "取款");
		
		java.util.List<tradingrec> list = query.list();
		//保存存款交易的数额
		for(tradingrec tra : list){
			a[i] = tra.getTradeMoney();
			i+=1;
		}
		for(int j = 0;j <= i;j++){
			depositLimit -= a[j];
		}
		return depositLimit;
	}
	public void getlmdRec(Long cardNumber,String[] date){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		String srcard = String.valueOf(cardNumber);
		String hql = "from tradingrec where cardnum = ? and tradeDate between ? and ?";
		Query query = session.createQuery(hql);
	}	
	public static String[][] getTraRec(long cardNumber,String[] date){
			//date[0]为起始日期，date[1]为结束时间
			//获取这两个时间之间的交易记录
			//返回一个String[][]
			//看看能不能按照获取记录大小动态定义数组
		String[][] s = new String[10][10];
		return s;
	}
}
