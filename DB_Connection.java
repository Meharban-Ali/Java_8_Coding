import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB_Connection {
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //url
        String url = "jdbc:mysql://localhost:3306/product_data";
        //username
        String username = "root";
        //password
        String password = "12345";
        // 1. Loard Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
       
        // 2. Connection
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("Database Connected Successfully..");

         //Insert Query
        // String query = "insert into student(name, email, role, address) VALUES(?, ?, ?, ?)"; 
        String query = "SELECT * FROM STUDENT";

        //Statement
        PreparedStatement st = con.prepareStatement(query);
        // st.setString(1, "Gayur");
        // st.setString(2, "gayur123@gmail.com");
        // st.setString(3, "React Develper");
        // st.setString(4, "Noida");

        // int insertedData = st.executeUpdate();
        
        //Execute Query
        ResultSet rs = st.executeQuery();
        System.out.println("Student Details Fetched Successfully...");
        System.out.println("----------------------------------------");
        while(rs.next()) {  
           int id= rs.getInt("id");
           String name = rs.getString("name");
           String email = rs.getString("email");
           String role = rs.getString("role");
           String address = rs.getString("address");
           System.out.println("Id: "+id);
           System.out.println("Name: "+name);
           System.out.println("Email: "+email);
           System.out.println("Role: "+role);
           System.out.println("Address: "+address);
           System.out.println("------------------------------------------");
        }
        System.out.println("This is a java Project and DB Connection code");
        con.close();
        st.close();
    }
}
