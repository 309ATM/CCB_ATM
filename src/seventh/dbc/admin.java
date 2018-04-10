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
	//添加
	private Session session;
	private Transaction tr;
	//连接数据库
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
	
	//查账号密码
	public boolean checkAdmin(String ADMINID,String PASSWD){
		//查找账号和密码
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
