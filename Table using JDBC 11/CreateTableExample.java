import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTableExample {

    
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/your_database_name"; 
    static final String USER = "your_username"; 
    static final String PASS = "your_password"; 

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        
        try {
           
            Class.forName(JDBC_DRIVER);

            
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

           
            System.out.println("Creating table in the database...");
            stmt = conn.createStatement();
            
            String sql = "CREATE TABLE Employees " +
                         "(id INT NOT NULL, " +
                         " name VARCHAR(255), " + 
                         " age INT, " + 
                         " PRIMARY KEY ( id ))";
            
            stmt.executeUpdate(sql);
            System.out.println("Table 'Employees' created successfully...");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
              
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
