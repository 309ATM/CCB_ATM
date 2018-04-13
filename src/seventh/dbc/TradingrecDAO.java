package seventh.dbc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TradingrecDAO extends DAO<Tradingrec>{

	/** 
	 * ����һ�����׼�¼
	 * @param cardnum
	 * @param tradeDate
	 * @param tradeMoney
	 * @param tradeType
	 * @param tradeTarget
	 * @param fee
	 * @return
	 */
	public void insertRecording(long card, float money, String tradeType, long tradeTarget, float fee){
		String sql = "insert into tradingrec(cardnum,tradeDate,tradeMoney,tradeType,tradeTarget,fee) values (?,?,?,?,?,?)";
		// �Զ���ȡ��ǰ����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sdf.format(new Date());
		Object[] param = {card,date,money,tradeType,tradeTarget, fee};
		
		update(sql, param);
	}
	
	
	/**
	 * ��ȡ����޶�
	 * @param card
	 * @return
	 */
	public float getDepositLimit(long card){
		// ����޶�Ϊ 4 ��Ԫ
		float depositLimit = 40000;
		// ��¼�����Ѿ����Ľ��
		float depositNum = 0;
		String sql = "select * from tradingrec where cardnum = ? "
				+ " and tradeType = ? and tradeDate like ?";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String tradedate = sdf.format(new Date());
		List<Tradingrec> tradingrecs = getForList(sql, card,"���","%"+tradedate+"%");
		// ���㵱��ÿ��ŵ����д����
		for(Tradingrec t:tradingrecs) {
			depositNum += t.getTradeMoney();
		}
		return depositLimit - depositNum;
	}
	
	//��ȡȡ���޶�
	public float getWithdrawalsLimit(long card){
		
		float withdrawalsLimit = 20000;
		float withdrawalsNum = 0;
		String sql = "select * from tradingrec where cardnum = ? "
				+ " and tradeType = ? and tradeDate like ?";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String tradedate = sdf.format(new Date());
		List<Tradingrec> tradingrecs = getForList(sql, card,"ȡ��","%"+tradedate+"%");
		
		// ���㵱��ÿ��ŵ�����ȡ����
		for(Tradingrec t:tradingrecs) {
			withdrawalsNum += t.getTradeMoney();
		}
		return withdrawalsLimit - withdrawalsNum;
	}
	
	
	/**
	 * ��ȡָ��ʱ����ڵĽ��׼�¼
	 * @param cardNumber
	 * @param date
	 * @return 
	 */
	public String[][] getSpecifiedRecording(long card,String[] date){
		String sql = "select * from tradingrec where cardnum = ? "
				+ " and tradeDate > ? and tradeDate < ?";
		List<Tradingrec> tradingrecs = getForList(sql, card,date[0],date[1]);
		String[][] records = new String[tradingrecs.size()][7];
		for (int i=0;i<tradingrecs.size();i++) {
			records[i][0] = String.valueOf(tradingrecs.get(i).getTradeNum());
			records[i][1] = String.valueOf(tradingrecs.get(i).getCardNum());
			records[i][2] = String.valueOf(tradingrecs.get(i).getTradeDate());
			records[i][3] = String.valueOf(tradingrecs.get(i).getTradeMoney());
			records[i][4] = String.valueOf(tradingrecs.get(i).getTradeType());
			records[i][5] = String.valueOf(tradingrecs.get(i).getTradeTarget());
			records[i][6] = String.valueOf(tradingrecs.get(i).getFee());
		}
		return records;
	}	
}
