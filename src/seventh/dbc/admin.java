package seventh.dbc;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Before;
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
	//���
	private Session session;
	private Transaction tr;
	//�������ݿ�
	@Before
	public void init(){
		session = HibernateUtils.getCurrentSession();
		tr = session.beginTransaction();
	}
	@Test
	public void insertMess(){
		admin ad = new admin();
		ad.setAdminId("test");
		ad.setPasswd("123");
		session.save(ad);
		tr.commit();
		session.close();
	}
	
	//���˺�����
	public boolean checkAdmin(String ADMINID,String PASSWD){
		//�����˺ź�����
		String hql = "from admin where adminId = ? and passwd = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, ADMINID);
		query.setParameter(1, PASSWD);
		
		java.util.List<admin> list = query.list();
		
		if(list != null){
			return true;
		}else{
			return false;
		}
	}
}
