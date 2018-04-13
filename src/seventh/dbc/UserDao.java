package seventh.dbc;


public class UserDao extends DAO<User>{
	
	/**
	 * �����û���Ϣ
	 */
	public void insertUserInformation(String name,String sex,String idCard,String phone,String address) {
		String sql = "insert into users(name,sex,idCard,phone,address) values(?,?,?,?,?)";
		update(sql, name,sex,idCard,phone,address);
	}
	
	/**
	 * �޸��û���Ϣ
	 */
	public void updateUserInformation(String name,String sex,String idCard,String phone,String address) {
		String sql = "update users set name=?,sex=?,phone=?,address=? where idCard=?";
		update(sql, name,sex,phone,address,idCard);
	}
	
	/**
	 * �����û���Ϣ
	 * @return
	 */
	public String[] getUserInformation(String idCard) {
		String[] userInformation = new String[5];
		String sql = "select * from users where idCard = ?";
		User users= get(sql, idCard);
		userInformation[0] = users.getName();
		userInformation[1] = users.getSex();
		userInformation[2] = users.getIdCard();
		userInformation[3] = users.getPhone();
		userInformation[4] = users.getAddress();
		return userInformation;
	}
}
