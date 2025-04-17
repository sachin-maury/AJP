iimport java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLJDBCExample {
    
    
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

          
            stmt = conn.createStatement();

          
            String createTableSQL = "CREATE TABLE Employees "
                                  + "(id INTEGER not NULL, "
                                  + " name VARCHAR(255), "
                                  + " age INTEGER, "
                                  + " PRIMARY KEY ( id ))";
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table created successfully...");

           
            String insertSQL = "INSERT INTO Employees (id, name, age) VALUES (1, 'John Doe', 30)";
            stmt.executeUpdate(insertSQL);
            insertSQL = "INSERT INTO Employees (id, name, age) VALUES (2, 'Jane Smith', 25)";
            stmt.executeUpdate(insertSQL);
            System.out.println("Records inserted successfully...");

           
            String selectSQL = "SELECT id, name, age FROM Employees";
            ResultSet rs = stmt.executeQuery(selectSQL);
            
            System.out.println("Data from Employees table:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

               
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }

            
            String updateSQL = "UPDATE Employees SET age = 35 WHERE id = 1";
            stmt.executeUpdate(updateSQL);
            System.out.println("Record updated successfully...");

          
            String deleteSQL = "DELETE FROM Employees WHERE id = 2";
            stmt.executeUpdate(deleteSQL);
            System.out.println("Record deleted successfully...");

            
            rs.close();
            stmt.close();
            conn.close();
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
