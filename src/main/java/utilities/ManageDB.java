package utilities;

import java.sql.DriverManager;

public class ManageDB extends CommonOps{

    public static void openConnection(String dbUrl, String username, String password){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbUrl, username, password);
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error Occurred while Connecting to DB, See Details: " + e);
        }
    }

    public static void closeConnection(){
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Error Occurred while Closing to DB, See Details: " + e);
        }
    }
}
