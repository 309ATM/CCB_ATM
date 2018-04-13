package seventh.dbc;

import java.util.List;

import org.junit.Test;

public class AdminDAO extends DAO<Admin>{
	//@Test
	public void getAll(){
		//Test
		String sql = "select * from admin where adminId = ?";
		System.out.println(get(sql, "test"));
	}
	
	//@Test
	public boolean cheeckAdmin(String adminId,String passWd){
		//¼ì²éÕËºÅºÍÃÜÂëÊÇ·ñÒ»ÖÂ
		//ÊäÈëÕËºÅÃÜÂë£¬Êä³ö¶Ô´í
		//String adminId,String passWd
		//String adminId = "test";
		//String passWd = "123";
		String sql = "select * from admin where adminId = ? and passwd = ?";
		System.out.println(get(sql,adminId,passWd));
		if(get(sql,adminId,passWd) != null){
			//System.out.println("true");
			return true;
		}else{
			//System.out.println("false");
			return false;
		}
		
	
		
	} 
}
