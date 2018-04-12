package seventh.dbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	//ʹ��һ����̬�鴴��SessionFactory����
	public static final Configuration CONFIG;//CONFIG;
	public static final SessionFactory FACTORY;
	
	static{
		CONFIG = new Configuration().configure();
		FACTORY = CONFIG.buildSessionFactory(); 
	}
	
	//�����ӳ��л�ȡ���ӳ�
	public static Session openSession(){
		return FACTORY.openSession();		
	}
	
	//session���߳�
	public static Session getCurrentSession(){
		return FACTORY.getCurrentSession();
	}
}
