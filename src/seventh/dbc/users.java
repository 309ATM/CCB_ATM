package seventh.dbc;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.List;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Test;


import util.HibernateUtils;

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

	//查找
	public void searchMess(){}
	//修改
	public void updateMess(){}
	//添加
	public void insertMess(){}
	//删除
	public void delMess(){}
	//全查
	private Session session;
	private Transaction tr;
	@Before
	private void init() {
		session = HibernateUtils.getCurrentSession();
		tr = session.beginTransaction();
	}
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
		
		
		String hql = "from users";
		Query query = session.createQuery(hql);
		java.util.List<users> list = query.list();
		for(users u : list){
			System.out.println(u.toString());
		}   
	}
//	 int id,
//	 String name,
//	 String sex,
//	 String idcard,
//	 String phone,
//	 String address
	
	//插入信息
	@Test
	public boolean idCardExit(int ID,String NAME,String SEX,String idCard,String PHONE,String ADDRESS){
		//身份证号存在检查
		 //创建查询(query)对象
		     //String idCard = "440682199812125634";
			 String hql = "from users u where idcard = ?";
			 Query query = session.createQuery(hql);
			 query.setParameter(0, idCard);
			 java.util.List<users> list = query.list();
			 for(users u : list){
					System.out.println(u.toString());
			 }
			 if(list != null){
				 //System.out.println("true");
				 //return true;
				 users u = new users();
				 u.setId(ID);
				 u.setName(NAME);
				 u.setSex(SEX);
				 u.setIdcard(idCard);
				 u.setPhone(PHONE);
				 u.setAddress(ADDRESS);
				 session.save(u);
				 tr.commit();
				 return true;
				 
	}
			 else
				 //System.out.println("false");
				 return false;
	}
	
	
	
}
