package seventh.dbc;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;  

public class DBHelper {
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    public static final String DB_URL = "jdbc:mysql://172.25.148.15:3306/ccb_atm?useSSL=false";//?useSSL=false��ӱ�����ʾSSL��½
    public static final String user = "atmuser";  
    public static final String password = "atmpass";  
  
    public Connection conn = null;  
    public PreparedStatement pst = null;  
    
    public void test (String sql){
        try {  
            Class.forName(JDBC_DRIVER);//ָ����������  
            conn = DriverManager.getConnection(DB_URL, user, password);//��ȡ����  
            pst = conn.prepareStatement(sql);//׼��ִ�����  
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
            	System.out.println(rs);
            }
            
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }
    
    public DBHelper() {  
    }  
  
    public void close() {  
        try {  
            this.conn.close();  
            this.pst.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
    

}
