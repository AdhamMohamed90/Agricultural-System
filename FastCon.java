package ImportantClasses;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FastCon {


   public static Connection DBConnect(){
       try {
           Class.forName("oracle.jdbc.OracleDriver");
           Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
                      return c;
       } catch (ClassNotFoundException ex) {
           System.out.println(ex.getMessage());
       } catch (SQLException ex) {
           System.out.println(ex.getMessage());
       }
       return null;
   } 



}