package StudentManagement;
import java.sql.*; 
public class DBConnection {
    static public Connection returnCon(){
        String url = "jdbc:mysql://localhost:3306/jdbc_practice";
        String userName = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,userName,password);
            return con;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }   
}
