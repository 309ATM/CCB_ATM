package seventh.dbc;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class caonidaye {
	@Test
	public void caonima(){
		//获取hibernate.cfg.xml文件信息
		Configuration con = new Configuration();
		con.configure();
		//数据库连接池
		SessionFactory fac = con.buildSessionFactory();
		System.out.println(fac);
		
		/*admin ad = new admin();
		ad.setAdminId("test");
		ad.setPasswd("123");
		Session session = HibernateUtils.openSession();
		Transaction tr = session.beginTransaction();
		session.save(ad);
		tr.commit();
		session.close();*/
	}
}
