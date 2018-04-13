package seventh.dbc;

import java.io.IOException;
import java.sql.SQLException;

public class Test {
	public static void main(String[] args) {
		try {
			System.out.println(JDBCTools.getConnection());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
