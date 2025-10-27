import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
        String query = "DELETE FROM STUDENT WHERE id = ?";

        //Statement
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, 5);
        // st.setString(1, "Gayur");
        // st.setString(2, "gayur123@gmail.com");
        // st.setString(3, "React Develper");
        // st.setString(4, "Noida");

        int deleteById = st.executeUpdate();
        
        //Execute Query
        // ResultSet rs = st.executeQuery();
        if(deleteById>0) {  
           System.out.println("Student Records Delete Successfully..: "+deleteById);
        }else{
            System.out.println("Student Records not found this id: "+deleteById);
        }
        System.out.println("This is a java Project and DB Connection code");
        con.close();
        st.close();
    }
}
