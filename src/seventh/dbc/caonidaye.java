package seventh.dbc;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class caonidaye {
	@Test
	public void caonima(){
		//��ȡhibernate.cfg.xml�ļ���Ϣ
		Configuration con = new Configuration();
		con.configure();
		//���ݿ����ӳ�
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
