package seventh.dbc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TradingrecDAO extends DAO<Tradingrec> {

	/**
	 * 插入一条交易记录
	 * 
	 * @param cardnum
	 * @param tradeDate
	 * @param tradeMoney
	 * @param tradeType
	 * @param tradeTarget
	 * @param fee
	 * @return
	 */
	public void insertRecording(long card, float money, String tradeType, long tradeTarget, float fee) {
		String sql = "insert into tradingrec(cardnum,tradeDate,tradeMoney,tradeType,tradeTarget,fee) values (?,?,?,?,?,?)";
		// 自动获取当前日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date());
		update(sql, card, date, money, tradeType, tradeTarget, fee);
	}

	/**
	 * 获取存款限额
	 * 
	 * @param card
	 * @return
	 */
	public float getDepositLimit(long card) {
		// 存款限额为 4 万元
		float depositLimit = 40000;
		// 记录当天已经存款的金额
		float depositNum = 0;
		String sql = "select * from tradingrec where cardnum = ? " + " and tradeType = ? and tradeDate like ?";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String tradedate = sdf.format(new Date());
		List<Tradingrec> tradingrecs = getForList(sql, card, "存款", "%" + tradedate + "%");
		// 计算当天该卡号的所有存款金额
		for (Tradingrec t : tradingrecs) {
			depositNum += t.getTradeMoney();
		}
		return depositLimit - depositNum;
	}

	// 获取取款限额
	public float getWithdrawalsLimit(long card) {

		float withdrawalsLimit = 20000;
		float withdrawalsNum = 0;
		String sql = "select * from tradingrec where cardnum = ? " + " and tradeType = ? and tradeDate like ?";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String tradedate = sdf.format(new Date());
		List<Tradingrec> tradingrecs = getForList(sql, card, "取款", "%" + tradedate + "%");

		// 计算当天该卡号的所有取款金额
		for (Tradingrec t : tradingrecs) {
			withdrawalsNum += t.getTradeMoney();
		}
		return withdrawalsLimit - withdrawalsNum;
	}
	
	public float getTransferLimit(long card){
		float transferLimit = 50000;
		float transferNum = 0;
		String sql = "select * from tradingrec where cardnum = ? " + " and tradeType = ? and tradeDate like ?";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String tradedate = sdf.format(new Date());
		
		List<Tradingrec> tradingrecs = getForList(sql, card, "转账转出", "%" + tradedate + "%");
		for (Tradingrec t : tradingrecs) {
			transferNum += t.getTradeMoney();
		}
		return transferLimit - transferNum;
	}

	/**
	 * 获取指定时间段内的交易记录
	 * 
	 * @param cardNumber
	 * @param date
	 * @return
	 */
	public String[][] getSpecifiedRecording(long card, String[] date) {

		String sql = "select * from tradingrec where cardnum = ? "
				+ " and tradeDate > ? and tradeDate < ? order by tradeDate desc";
		List<Tradingrec> tradingrecs = getForList(sql, card, SQLDate(date[0]), SQLDate(date[1]));
		String[][] records = new String[tradingrecs.size()][7];
		for (int i = 0; i < tradingrecs.size(); i++) {
			records[i][0] = String.valueOf(tradingrecs.get(i).getCardNum());
			records[i][1] = String.valueOf(tradingrecs.get(i).getTradeDate());
			records[i][2] = String.valueOf(tradingrecs.get(i).getTradeMoney());
			records[i][3] = String.valueOf(tradingrecs.get(i).getTradeType());
			records[i][4] = String.valueOf(tradingrecs.get(i).getTradeTarget());
			records[i][5] = String.valueOf(tradingrecs.get(i).getFee());
		}
		return records;
	}

	//将获取记录的日期自动加一天
	private static String SQLDate(String source) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			date = simpleDateFormat.parse(source);
		} catch (Exception e) {
			System.out.println("fas");
		}
		Calendar calendar = Calendar.getInstance(); // 得到日历
		calendar.setTime(date);// 把当前时间赋给日历
		calendar.add(Calendar.DATE, 1);
		date = calendar.getTime();
		return simpleDateFormat.format(date);
	}
}
