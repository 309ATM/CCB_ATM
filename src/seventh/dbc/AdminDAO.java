package seventh.dbc;

import java.util.List;

import org.junit.Test;

public class AdminDAO extends DAO<Admin>{
	//@Test
//	public void getAll(){
//		//Test
//		String sql = "select * from admin where adminId = ?";
//		System.out.println(get(sql, "test"));
//	}
	
	//@Test
	/**����˺������Ƿ���ȷ
	 * @param adminId
	 * @param passWd
	 * @return boolean
	 */
	public boolean cheeckAdmin(String adminId,String passWd){
		//����˺ź������Ƿ�һ��
		//�����˺����룬����Դ�
		//String adminId,String passWd
		//String adminId = "test";
		//String passWd = "123";
		String sql = "select * from admin where adminId = ? and passwd = ?";
		System.out.println(get(sql,adminId,passWd));
		if(get(sql,adminId,passWd) != null){
			//System.out.println("true");
			return true;
		}else{
			//System.out.println("false");
			return false;
		}
		
	}
	
	/**����Ա�˺��Ƿ����
	 * @param adminId
	 * @return boolean
	 */
	public boolean getAccountExit(String adminId){
		String sql = "select adminId from admin where adminId = ?";
		String Target = getForValue(sql, adminId);
		if(Target.equals(adminId)){
			return true;
		}else{
			return false;
		}
	}
	
	/**�޸Ĺ���Ա����
	 * @param AdminId
	 * @param OldPasswd
	 * @param NewPasswd
	 * @return true
	 */
	public boolean updateAccountPasswd(String AdminId,String OldPasswd,String NewPasswd){
		String sql = "update admin set passwd = ? where adminId = ? and passwd = ?";
		update(sql,NewPasswd,AdminId,OldPasswd);
		return true;
	}
}
