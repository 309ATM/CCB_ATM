package seventh.dbc;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Test;

import seventh.dbc.HibernateUtils;

public class admin {
	private String adminId;
	private String passwd;
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	@Override
	public String toString() {
		return "admin [adminId=" + adminId + ", passwd=" + passwd + "]";
	}
	private static Session session;
	private static Transaction tr;
	
	
	//添加
	@Test
	public void insertMess(){
		admin ad = new admin();
		ad.setAdminId("test");
		ad.setPasswd("123");
		Session session = HibernateUtils.openSession();
		Transaction tr = session.beginTransaction();
		session.save(ad);
		tr.commit();
		session.close();
	}
	
	/** 检查账号和密码是否一致
	 * @param adminid
	 * @param passWd
	 * @return
	 */
	public static boolean checkadmin(String adminid,String passWd){
		session = HibernateUtils.getCurrentSession();
		tr = session.beginTransaction();
		String hql = "from admin where adminId = ? and passwd = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, adminid);
		query.setParameter(1, passWd);
		java.util.List<admin> list = query.list();
		for(admin a : list){
			System.out.println(a.toString());
		}
		
		if(list != null){
			return true;
		}
		else{
		return false;
		}
	}
}
	
	


