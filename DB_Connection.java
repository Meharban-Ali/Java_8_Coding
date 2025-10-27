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
        String query = "UPDATE student SET name = ?, email = ?, role = ?, address = ? where id = ?"; 

        //Statement
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, "Shane Alam");
        st.setString(2, "shane123@gmail.com");
        st.setString(3, "Python Developer");
        st.setString(4, "Hydrabad");
        st.setInt(5, 7);

        int updateRecords = st.executeUpdate();
        
        //Execute Query
        // ResultSet rs = st.executeQuery();
        if (updateRecords>0) {
            System.out.println("Student records updated successfully");
        }else{
            System.out.println("Student Records not updated..");
        }
        con.close();
        st.close();
    }
}
