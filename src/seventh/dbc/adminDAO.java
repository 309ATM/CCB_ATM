package seventh.dbc;

import java.util.List;

import org.junit.Test;

public class adminDAO extends DAO<admin>{
	@Test
	public void getAll(){
		String sql = "select * from admin where adminId = ?";
		System.out.println(get(sql, "test"));
	}
}
