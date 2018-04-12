package seventh.dbc;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;


import seventh.dbc.HibernateUtils;

public class users {
	private int id;
	private String name;
	private String sex;
	private String idcard;
	private String phone;
	private String address;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "users [id=" + id + ", name=" + name + ", sex=" + sex + ", idcard=" + idcard + ", phone=" + phone
				+ ", address=" + address + "]";
	}
	public static Session session;
	public static Transaction tr;
	
	public void init(){
		
	}
	
	//查找
	public void searchMess(){}
	//修改
	public void updateMess(){}
	//添加用户 
//	private int id;
//	private String name;
//	private String sex;
//	private String idcard;
//	private String phone;
//	private String address;
	public static boolean insertMess(int ID,String NAME,String Sex,String IDCARD,String PHONE,String ADRESS){
		
		return true;
	}
	//删除
	public void delMess(){}
	//全查
	
	public void allMess(){
		/*Session session = HibernateUtils.openSession();
		session.beginTransaction();
		String sql = "select * from users";
		NativeQuery<users> query = session.createNativeQuery(sql, users.class);
		java.util.List<users> list = query.getResultList();
		for(users o : list){
	         System.out.println(o.toString());
	     }*/
		/*
		 * CriteriaQuery<users> criteriaQuery = session.getCriteriaBuilder().createQuery(users.class);
		criteriaQuery.from(users.class);
		java.util.List<users> list = session.createQuery(criteriaQuery).getResultList();
		System.out.println(list);
		tr.commit();*/
		
		/*CriteriaBuilder build = session.getCriteriaBuilder();
		CriteriaQuery<users> criteria = build.createQuery(users.class);
		criteria.from(users.class);
		session.createQuery("");*/
		
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		String hql = "from users";
		Query query = session.createQuery(hql);
		java.util.List<users> list = query.list();
		for(users u : list){
			System.out.println(u.toString());
		}   
	}
	
	@Test
	public static boolean idCardExit(String idCard){
		//身份证号存在检查
		 //创建查询(query)对象
		     //String idCard = "440682199812125634";
			 Session session = HibernateUtils.getCurrentSession();
			 Transaction tr = session.beginTransaction();
			 
			 String hql = "from users u where idcard = ?";
			 Query query = session.createQuery(hql);
			 query.setParameter(0, idCard);
			 java.util.List<users> list = query.list();
			 for(users u : list){
					System.out.println(u.toString());
			 }
			 if(list != null)
				 //System.out.println("true");
				 return true;
			 else
				 //System.out.println("false");
				 return false;
			
	}
	
	
}
