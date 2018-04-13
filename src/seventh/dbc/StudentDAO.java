package seventh.dbc;

import java.util.List;

public class StudentDAO extends DAO<Student>{
	public List<Student> getAll(){
		String sql = "select * from student";
		return getForList(sql);
	}
}
