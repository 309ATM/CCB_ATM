package seventh.dbc;

import org.junit.Test;

public class UserDao extends DAO<User> {

	/**
	 * 插入用户信息
	 */
	public void insertUserInformation(String name, String sex, String idCard, String phone, String address) {
		String sql = "insert into users(name,sex,idCard,phone,address) values(?,?,?,?,?)";
		update(sql, name, sex, idCard, phone, address);
	}

	/**
	 * 修改用户信息
	 */
	public void updateUserInformation(String[] info) {
		String sql = "update users set name=?,sex=?,idCard=?,phone=?,address=? where idCard=?";
		update(sql, info[1], info[2], info[3], info[4], info[5], info[0]);
	}

	/**
	 * 返回用户信息
	 * 
	 * @return
	 */
	public String[] getUserInformation(String idCard) {
		String[] userInformation = new String[5];
		String sql = "select * from users where idCard = ?";
		User users = get(sql, idCard);
		userInformation[0] = users.getName();
		userInformation[1] = users.getSex();
		userInformation[2] = users.getIdCard();
		userInformation[3] = users.getPhone();
		userInformation[4] = users.getAddress();
		return userInformation;
	}

	/**
	 * 根据 id 返回用户信息
	 * 
	 * @param id
	 * @return
	 */
	public String[] getUserMessageId(int id) {
		String[] userInformation = new String[5];
		String sql = "select name,sex,idcard,phone,address from users where id = ?";
		User users = get(sql, id);
		userInformation[0] = users.getName();
		userInformation[1] = users.getSex();
		userInformation[2] = users.getIdCard();
		userInformation[3] = users.getPhone();
		userInformation[4] = users.getAddress();
		return userInformation;
	}

	/**
	 * 根据身份证号，判断用户是否存在
	 * 
	 * @param idCard
	 * @return
	 */
	public boolean checkIdCardExit(String idCard) {
		String sql = "select count(*) from users where idcard = ?";
		long number = getForValue(sql, idCard);
		if (number > 0) {
			return true;
		} else {
			return false;
		}
	}

}
