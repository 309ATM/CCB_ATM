package seventh.dbc;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import util.HibernateUtils;

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
	//Ìí¼Ó
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
	
}
