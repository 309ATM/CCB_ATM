package seventh.dbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	//使用一个静态块创建SessionFactory对象
	public static final Configuration CONFIG;//CONFIG;
	public static final SessionFactory FACTORY;
	
	static{
		CONFIG = new Configuration().configure();
		FACTORY = CONFIG.buildSessionFactory(); 
	}
	
	//从连接池中获取连接池
	public static Session openSession(){
		return FACTORY.openSession();		
	}
	
	//session绑定线程
	public static Session getCurrentSession(){
		return FACTORY.getCurrentSession();
	}
}
